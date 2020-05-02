package handlers_test

import (
	"encoding/json"
	"listing17/handlers"
	"net/http"
	"net/http/httptest"
	"testing"
)

const checkMark = "\u2713"
const ballotX = "\u2717"

func init() {
	handlers.Routes()
}

func TestSendJSON(t *testing.T) {
	t.Log("SendJSON 종단점의 동작에 대한 테스트 시작.")
	{
		req, err := http.NewRequest("GET", "/sendjson", nil)
		if err != nil {
			t.Fatal("\t웹 요청을 보내는지 확인.", ballotX, err)
		}
		t.Log("\t웹 요청을 보내는지 확인.", checkMark)

		rw := httptest.NewRecorder()
		http.DefaultServeMux.ServeHTTP(rw, req)

		if rw.Code != 200 {
			t.Fatal("\t응답 코드가 \"200\"인지 확인.", ballotX, rw.Code)
		}
		t.Log("\t응답 코드가 \"200\"인지 확인.", checkMark)

		u := struct {
			Name  string
			Email string
		}{}

		if err := json.NewDecoder(rw.Body).Decode(&u); err != nil {
			t.Fatal("\t응답 데이터 디코딩 동작 확인.", ballotX)
		}
		t.Log("\t응답 데이터 디코딩 동작 확인.", checkMark)

		if u.Name == "webgenie" {
			t.Log("\t응답 데이터의 이름 확인.", checkMark)
		} else {
			t.Log("\t응답 데이터의 이름 확인.", ballotX, u.Name)
		}

		if u.Email == "webgenie@email.com" {
			t.Log("\t응답 데이터의 메일 주소 확인.", checkMark)
		} else {
			t.Log("\t응답 데이터의 메일 주소 확인.", ballotX, u.Name)
		}
	}
}
