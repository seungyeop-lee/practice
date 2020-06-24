package pools

import (
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
)

func Setup() (*sql.DB, error)  {
	db, err := sql.Open("mysql", "root:root@tcp(127.0.0.1:3308)/testdb?parseTime=true")
	if err != nil {
		return nil, err
	}

	db.SetMaxOpenConns(24)

	db.SetMaxIdleConns(24)

	return db, nil
}
