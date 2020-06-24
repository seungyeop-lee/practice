package database

import (
	"database/sql"
	"fmt"
)

const selectQuery = `
	select name, created
	from example
	where name=?`

func Query(db *sql.DB) error {
	name := "Aaron"
	rows, err := db.Query(selectQuery, name)
	if err != nil {
		return err
	}
	defer rows.Close()

	for rows.Next() {
		var e Example
		if err := rows.Scan(&e.Name, &e.Created); err != nil {
			return err
		}
		fmt.Printf("Results:\n\tName: %s\n\tCreated: %v\n", e.Name, e.Created)
	}
	return rows.Err()
}
