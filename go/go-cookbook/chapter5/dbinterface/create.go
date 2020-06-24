package dbinterface

import (
	"database/sql"
)

const (
	createTable = `
		create table example (
			name VARCHAR(20),
			created DATETIME
		)`
	insertRow = `
		insert into example (name, created)
		values ("Aaron", NOW())`
)

func Create(db *sql.DB) error {
	if _, err := db.Exec(createTable); err != nil {
		return err
	}

	if _, err := db.Exec(insertRow); err != nil {
		return err
	}

	return nil
}
