package pools

import (
	"context"
	"time"
)

func ExecWithTimeout() error {
	db, err := Setup()
	if err != nil {
		return err
	}

	ctx := context.Background()

	ctx, _ = context.WithDeadline(ctx, time.Now())
	context.WithTimeout()

	_, err = db.BeginTx(ctx, nil)
	return err
}
