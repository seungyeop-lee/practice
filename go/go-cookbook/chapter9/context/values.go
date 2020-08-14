package context

import "context"

type key string

const (
	timeoutKey  key = "TimeoutKey"
	deadlineKey key = "DeadlineKey"
)

//Setup 함수는 몇 가지 값을 설정한다.
func Setup(ctx context.Context) context.Context {
	ctx = context.WithValue(ctx, timeoutKey, "timeout exceeded")
	ctx = context.WithValue(ctx, deadlineKey, "deadline exceeded")
	return ctx
}

//GetValue 함수는 주어진 키의 값을 가져와서
//그 값의 문자열 표현(string representation)을 리턴한다.
func GetValue(ctx context.Context, k key) string {
	if val, ok := ctx.Value(k).(string); ok {
		return val
	}
	return ""
}
