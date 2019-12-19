module github.com/seungyeop-lee/bookstore_items-api

go 1.13

require (
	github.com/fortytw2/leaktest v1.3.0 // indirect
	github.com/google/go-cmp v0.3.1 // indirect
	github.com/gorilla/mux v1.7.3
	github.com/mailru/easyjson v0.7.0 // indirect
	github.com/olivere/elastic v6.2.26+incompatible
	github.com/seungyeop-lee/bookstore_oauth-go v0.0.0-20191218114459-38187f373f2a
	github.com/seungyeop-lee/bookstore_utils-go v0.0.0
	go.uber.org/zap v1.13.0
	gopkg.in/yaml.v2 v2.2.7 // indirect
)

replace github.com/seungyeop-lee/bookstore_utils-go v0.0.0 => ../bookstore_utils-go
