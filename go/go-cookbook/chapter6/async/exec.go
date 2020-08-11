package async

//FetchAll 함수는 URL 목록을 가져온다.
func FetchAll(urls []string, c *Client) {
	for _, url := range urls {
		go c.AsyncGet(url)
	}
}
