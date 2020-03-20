package services

import (
	"github.com/seungyeop-lee/bookstore_items-api/domain/items"
	"github.com/seungyeop-lee/bookstore_utils-go/rest_errors"
	"net/http"
)

var (
	ItemsService itemsServiceInterface = &itemsService{}
)

type itemsServiceInterface interface {
	Create(items.Item) (*items.Item, *rest_errors.RestErr)
	Get(string) (*items.Item, *rest_errors.RestErr)
}

type itemsService struct{}

func (s *itemsService) Create(item items.Item) (*items.Item, *rest_errors.RestErr) {
	if err := item.Save(); err != nil {
		return nil, err
	}

	return &item, nil
}

func (s *itemsService) Get(string) (*items.Item, *rest_errors.RestErr) {
	return nil, &rest_errors.RestErr{
		Message: "implement me!",
		Status:  http.StatusNotImplemented,
		Error:   "not_implemented",
	}
}
