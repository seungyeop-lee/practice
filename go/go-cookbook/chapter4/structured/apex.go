package structured

import (
	"errors"
	"github.com/apex/log"
	"github.com/apex/log/handlers/text"
	"os"
)

func ThrowError() error {
	err := errors.New("a crazy failure")
	log.WithField("id", "123").Trace("ThrowError").Stop(&err)
	return err
}

type CustomHandler struct {
	id string
	handler log.Handler
}

func (h *CustomHandler) HandleLog(e *log.Entry) error {
	e.WithField("id", h.id)
	return h.handler.HandleLog(e)
}

func Apex() {
	log.SetHandler(&CustomHandler{"123", text.New(os.Stdout)})
	err := ThrowError()

	log.WithError(err).Error("an error occurred")
}