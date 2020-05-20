package main

import (
	"io/ioutil"
	"log"
	"net/http"
)

func main() {
	//오류체크 생략
	resp, _ := http.Get("http://localhost:18888")
	defer resp.Body.Close()
	body, _ := ioutil.ReadAll(resp.Body)
	log.Println(string(body))

	//상태정보
	log.Println("Status:", resp.Status)	// "200 OK"
	//상태코드
	log.Println("Status:", resp.StatusCode)	// 200
	//헤더 (맵)
	log.Println("Headers:", resp.Header)	// map[Content-Length:[32] Content-Type:[text/html; charset=utf-8] Date:[Wed, 20 May 2020 10:14:08 GMT]]
	//헤더의 특정 값
	log.Println("Content-Length:", resp.Header.Get("Content-Length"))	// 32
}
