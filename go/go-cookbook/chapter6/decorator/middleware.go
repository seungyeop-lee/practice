package decorator

import (
	"log"
	"net/http"
	"time"
)

//Logger 는 우리가 만든 '미들웨어'의
//데코레이터(decorator) 중 하나이다.
func Logger(l *log.Logger) Decorator {
	return func(c http.RoundTripper) http.RoundTripper {
		return TransportFunc(func(r *http.Request) (*http.Response, error) {
			start := time.Now()
			l.Printf("started request to %s at %s", r.URL, start.Format("2006-01-02 15:04:05"))
			resp, err := c.RoundTrip(r)
			l.Printf("completed request to %s in %s", r.URL, time.Since(start))
			return resp, err
		})
	}
}

//BasicAuth 는 또 다른 '미들웨어' 데코레이터 중 하나이다.
func BasicAuth(username, password string) Decorator {
	return func(c http.RoundTripper) http.RoundTripper {
		return TransportFunc(func(r *http.Request) (*http.Response, error) {
			r.SetBasicAuth(username, password)
			resp, err := c.RoundTrip(r)
			return resp, err
		})
	}
}