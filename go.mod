module github.com/seungyeop-lee/bookstore_oauth-api

go 1.13

require (
	github.com/federicoleon/golang-restclient v0.0.0-20191104170228-162ed620df66
	github.com/gin-gonic/gin v1.5.0
	github.com/gocql/gocql v0.0.0-20191126110522-1982a06ad6b9
	github.com/seungyeop-lee/bookstore_users-api v0.0.0-20191218025756-43d77edec1af
	github.com/seungyeop-lee/bookstore_utils-go v0.0.0
	github.com/stretchr/testify v1.4.0
)

replace github.com/seungyeop-lee/bookstore_utils-go v0.0.0 => ../bookstore_utils-go
