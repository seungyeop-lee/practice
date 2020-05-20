//테스트 용 echo 서버
package main

import (
	"fmt"
	"log"
	"net/http"
	"net/http/httputil"
)

func multipartHandler(w http.ResponseWriter, r *http.Request) {
	dump, err := httputil.DumpRequest(r, true)
	if err != nil {
		http.Error(w, fmt.Sprint(err), http.StatusInternalServerError)
		return
	}
	fmt.Println(string(dump))
	fmt.Fprintf(w,
		`
<html>
	<body>hello</body>
	<form method="POST" enctype="multipart/form-data">
		<input name="attachment-file" type="file" />
		<input type="submit" />
	</form>
</html>
`)
}

func main() {
	var httpServer http.Server
	http.HandleFunc("/", multipartHandler)
	log.Println("start http listening :18888")
	httpServer.Addr = ":18888"
	log.Println(httpServer.ListenAndServe())
}
