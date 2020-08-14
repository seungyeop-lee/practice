package waitgroup

import (
	"log"
	"sync"
	"time"
)

//Crawl 함수는 인자로 전달받은 목록에 있는 URL에서
//응답을 수집한다. 모든 요청에 대한 응답이
//완료될 때까지 기다렸다가 리턴한다.
func Crawl(sites []string) ([]int, error) {
	start := time.Now()
	log.Printf("starting crawling")
	wg := &sync.WaitGroup{}

	var resps []int
	cerr := &CrawlError{}
	for _, v := range sites {
		wg.Add(1)
		go func(v string) {
			defer wg.Done()
			resp, err := GetURL(v)
			if err != nil {
				cerr.Add(err)
				return
			}
			resps = append(resps, resp.StatusCode)
		}(v)
	}
	wg.Wait()
	if cerr.Valid() {
		return resps, cerr
	}
	log.Printf("completed crawling in %s", time.Since(start))
	return resps, nil
}
