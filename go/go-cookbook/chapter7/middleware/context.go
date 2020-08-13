package middleware

import (
	"context"
	"net/http"
	"strconv"
)

//ContextID 타입은 컨텍스트 객체를 검색하기 위한
//사용자 정의 타입이다.
type ContextID int

//ID 는 우리가 임의로 정의한 ID 이다.
const ID ContextID = 0

//SetID 함수는 컨텍스트의 ID를 업데이트하고
//그 값을 1 만큼 증가시킨다.
func SetID(start int64) Middleware {
	return func(next http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			ctx := context.WithValue(r.Context(), ID, strconv.FormatInt(start, 10))
			start++
			r = r.WithContext(ctx)
			next(w, r)
		}
	}
}

//GetID 함수는 ID가 설정된 경우 컨텍스트에서 ID를 가져온다.
//설정되지 않은 경우 빈 문자열을 리턴한다.
func GetID(ctx context.Context) string {
	if val, ok := ctx.Value(ID).(string); ok {
		return val
	}
	return ""
}
