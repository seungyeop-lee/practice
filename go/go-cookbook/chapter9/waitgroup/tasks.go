package waitgroup

import (
	"fmt"
	"log"
	"net/http"
	"strings"
	"time"
)

//GetURL 은 url 을 읽어오고 소요 시간을 기록한다.
func GetURL(url string) (*http.Response, error) {
	start := time.Now()
	log.Printf("getting %s", url)
	resp, err := http.Get(url)
	log.Printf("completed getting %s in %s", url, time.Since(start))
	return resp, err
}

//CrawlError 는 에러를 집계(aggregate)하기 위한
//사용자 정의 타입이다.
type CrawlError struct {
	Errors []string
}

//Add 함수는 또 다른 에러를 추가한다.
func (c *CrawlError) Add(err error) {
	c.Errors = append(c.Errors, err.Error())
}

//Error 함수는 error 인터페이스를 구현한다.
func (c *CrawlError) Error() string {
	return fmt.Sprintf("All Errors: %s", strings.Join(c.Errors, ","))
}

//Valid 함수는 에러 여부를 판단해
//CrawlError 를 리턴할지 여부를 결정한다.
func (c *CrawlError) Valid() bool {
	return len(c.Errors) != 0
}
