package oauthstore

import (
	"context"
	"fmt"
	"golang.org/x/oauth2"
)

//Storage 구조체는 범용적인(generic) 스토리지 인터페이스이다.
type Storage interface {
	GetToken() (*oauth2.Token, error)
	SetToken(*oauth2.Token) error
}

//GetToken 은 깃허브의 oauth2 토큰을 가져온다.
func GetToken(ctx context.Context, conf Config) (*oauth2.Token, error) {
	token, err := conf.Storage.GetToken()
	if err == nil && token.Valid() {
		return token, err
	}
	url := conf.AuthCodeURL("state")
	fmt.Printf("Type the following url into your browser and follow the directions on screen: %v\n", url)
	fmt.Println("Paste the code returned in the redirect URL and hit Enter:")

	var code string
	if _, err := fmt.Scan(&code); err != nil {
		return nil, err
	}
	return conf.Exchange(ctx, code)
}