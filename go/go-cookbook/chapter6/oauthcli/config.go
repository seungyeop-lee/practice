package oauthcli

import (
	"context"
	"fmt"
	"golang.org/x/oauth2"
	"golang.org/x/oauth2/github"
	"os"
)

// Setup 함수는 깃허브와 통신하도록 구성된 oauth2Config를
// 리턴해주며, 이를 위해서는 ID와 비밀번호를 환경 변수에
// 설정해줘야 한다.
func Setup() *oauth2.Config {
	return &oauth2.Config{
		ClientID: os.Getenv("GITHUB_CLIENT"),
		ClientSecret: os.Getenv("GITHUB_SECRET"),
		Scopes: []string{"repo", "user"},
		Endpoint: github.Endpoint,
	}
}

// GetToken은 깃허브의 oauth2 토큰을 가져온다.
func GetToken(ctx context.Context, conf *oauth2.Config) (*oauth2.Token, error) {
	url := conf.AuthCodeURL("state")
	fmt.Printf("Type the following url into your browser and follow the directions on screen: %v\n", url)
	fmt.Println("Paste the code returned in the redirect URL and hit Enter:")

	var code string
	if _, err := fmt.Scan(&code); err != nil {
		return nil, err
	}
	return conf.Exchange(ctx, code)
}