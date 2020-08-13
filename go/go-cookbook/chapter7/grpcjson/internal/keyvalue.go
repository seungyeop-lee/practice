package internal

import (
	"chapter7/grpcjson/keyvalue"
	"context"
	"sync"

	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
)

//KeyValue 는 맵을 저장하고 있는 구조체이다.
type KeyValue struct {
	mutex sync.RWMutex
	m     map[string]string
}

//NewKeyValue 함수는 맵과 컨트롤러를 초기화한다.
func NewKeyValue() *KeyValue {
	return &KeyValue{
		m: make(map[string]string),
	}
}

//Set 함수는 키에 값을 저장한 다음 그 값을 리턴한다.
func (k *KeyValue) Set(ctx context.Context, r *keyvalue.SetKeyValueRequest) (*keyvalue.KeyValueResponse, error) {
	k.mutex.Lock()
	defer k.mutex.Unlock()

	k.m[r.GetKey()] = r.GetValue()

	return &keyvalue.KeyValueResponse{Value: r.GetValue()}, nil
}

//Get 함수는 입력받은 키에 해당하는 값을 가져오거나
//값이 없는 경우 찾을 수 없다고 응답한다.
func (k *KeyValue) Get(ctx context.Context, r *keyvalue.GetKeyValueRequest) (*keyvalue.KeyValueResponse, error) {
	k.mutex.RLock()
	defer k.mutex.RUnlock()

	val, ok := k.m[r.GetKey()]
	if !ok {
		return nil, status.Errorf(codes.NotFound, "key no set")
	}

	return &keyvalue.KeyValueResponse{Value: val}, nil
}
