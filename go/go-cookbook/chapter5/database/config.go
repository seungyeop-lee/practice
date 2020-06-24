package database

import (
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
	"time"
)

type Example struct {
	Name string
	Created *time.Time
}

func Setup() (*sql.DB, error) {
	db, err := sql.Open("mysql", "root:root@tcp(127.0.0.1:3308)/testdb?parseTime=true")
	if err != nil {
		return nil, err
	}
	return db, nil
}
