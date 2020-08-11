package oauthstore

import (
	"encoding/json"
	"errors"
	"golang.org/x/oauth2"
	"os"
	"sync"
)

//FileStorage 구조체는 우리가 만든 스토리지 인터페이스를 만족한다.
type FileStorage struct {
	Path string
	mu sync.RWMutex
}

//GetToken 은 파일에서 토큰을 가져온다.
func (f *FileStorage) GetToken() (*oauth2.Token, error) {
	f.mu.RLock()
	defer f.mu.RUnlock()
	in, err := os.Open(f.Path)
	if err != nil {
		return nil, err
	}
	defer in.Close()
	var t *oauth2.Token
	data := json.NewDecoder(in)
	return t, data.Decode(&t)
}

//SetToken 은 파일에서 토큰을 생성하거나, 추출 및 저장한다.
func (f *FileStorage) SetToken(t *oauth2.Token) error {
	if t == nil || !t.Valid() {
		return errors.New("bad token")
	}

	f.mu.Lock()
	defer f.mu.Unlock()
	out, err := os.OpenFile(f.Path, os.O_RDWR|os.O_CREATE|os.O_TRUNC, 0755)
	if err != nil {
		return err
	}
	defer out.Close()
	data, err := json.Marshal(&t)
	if err != nil {
		return err
	}

	_, err = out.Write(data)
	return err
}


