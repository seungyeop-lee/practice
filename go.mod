module github.com/seungyeop-lee/bookstore_items-api

go 1.13

require (
	github.com/davecgh/go-spew v1.1.1 // indirect
	github.com/gorilla/mux v1.7.3
	github.com/seungyeop-lee/bookstore_oauth-go v0.0.0-20191218114459-38187f373f2a
	github.com/seungyeop-lee/bookstore_utils-go v0.0.0
	gopkg.in/yaml.v2 v2.2.7 // indirect
)

replace github.com/seungyeop-lee/bookstore_utils-go v0.0.0 => ../bookstore_utils-go
