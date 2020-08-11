package oauthstore

import (
	"context"
	"golang.org/x/oauth2"
	"net/http"
)

// Config 구조체는 기본 oauth2.Config를 래핑하고.
// 스토리지를 추가해준다.
type Config struct {
	*oauth2.Config
	Storage
}

// Excahnge 함수는 토큰을 가져와서 저장한다.
func (c *Config) Exchange(ctx context.Context, code string) (*oauth2.Token, error) {
	token, err := c.Config.Exchange(ctx, code)
	if err != nil {
		return nil, err
	}
	if err := c.Storage.SetToken(token); err != nil {
		return nil, err
	}
	return token, nil
}

// TokenSource 함수는 저장된 토큰을 전달하거나,
// 새로운 토큰을 갖고 와서 저장한 후에 이것을
// 저장돼 있는 토큰으로 전달할 수 있다.
func (c *Config) TokenSource(ctx context.Context, t *oauth2.Token) oauth2.TokenSource {
	return StorageTokenSource(ctx, c, t)
}

//Client 함수는 우리가 만든 TokenSource 에 연결된다.
func (c *Config) Client(ctx context.Context, t *oauth2.Token) *http.Client {
	return oauth2.NewClient(ctx, c.TokenSource(ctx, t))
}