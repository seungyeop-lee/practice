package listing12

import (
	"fmt"
	"net/http"
	"net/http/httptest"
	"testing"
)

const checkMark = "\u2713"
const ballotX = "\u2717"

var feed = `<?xml version="1.0" encoding="UTF-8"?>
<rss>
<channel>
    <title>Going Go Programming</title>
    <description>Golang : https://github.com/goinggo</description>
    <link>http://www.goinggo.net/</link>
    <item>
        <pubDate>Sun, 15 Mar 2015 15:04:00 +0000</pubDate>
        <title>Object Oriented Programming Mechanics</title>
        <description>Go is an object oriented language.</description>
        <link>http://www.goinggo.net/2015/03/object-oriented</link>
    </item>
</channel>
</rss>`

func mockServer() *httptest.Server {
	f := func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(200)
		w.Header().Set("Content-Type", "application/xml")
		fmt.Fprintf(w, feed)
	}

	return httptest.NewServer(http.HandlerFunc(f))
}

func TestDownload(t *testing.T) {
	statusCode := http.StatusOK

	server := mockServer()
	defer server.Close()

	t.Log("콘텐츠 다운로드 기능 테스트 시작.")
	{
		t.Logf("\tURL \"%s\" 호출 시 상태 코드가 \"%d\"인지 확인.", server.URL, statusCode)
		{
			resp, err := http.Get(server.URL)
			if err != nil {
				t.Fatal("\t\tHTTP GET 요청을 보냈는지 확인", ballotX, err)
			}
			t.Log("\t\tHTTP GET 요청을 보냈는지 확인.", checkMark)
			defer resp.Body.Close()

			if resp.StatusCode == statusCode {
				t.Logf("\t\t상태 코드가 \"%d\" 인지 확인. %v", statusCode, checkMark)
			} else {
				t.Errorf("\t\t상태 코드가 \"%d\" 인지 확인. %v %v", statusCode, ballotX, resp.StatusCode)
			}
		}
	}
}
