package rest_errors

import (
	"encoding/json"
	"errors"
	"fmt"
	"net/http"
)

type RestErr interface {
	Message() string
	Status() int
	Error() string
	Causes() []interface{}
	GetStruct() map[string]interface{}
}

type restErr struct {
	message string        `json:"message"`
	status  int           `json:"status"`
	error   string        `json:"error"`
	causes  []interface{} `json:"causes"`
}

func (e restErr) Error() string {
	return fmt.Sprintf("message: %s - status %d - error: %s - causes: %v",
		e.message, e.status, e.error, e.causes)
}

func (e restErr) Message() string {
	return e.message
}
func (e restErr) Status() int {
	return e.status
}
func (e restErr) Causes() []interface{} {
	return e.causes
}

func (e restErr) GetStruct() map[string]interface{} {
	return map[string]interface{}{
		"Message": e.Message(),
		"Status": e.Status(),
		"Error": e.Error(),
		"Causes": e.Causes(),
	}
}

type tempRestErr struct {
	Message string        `json:"message"`
	Status  int           `json:"status"`
	Error   string        `json:"error"`
	Causes  []interface{} `json:"causes"`
}

func (e tempRestErr) convertToRestErr() RestErr {
	return restErr{
		message: e.Message,
		status: e.Status,
		error: e.Error,
		causes: e.Causes,
	}
}

func NewRestError(message string, status int, err string, causes []interface{}) RestErr {
	return restErr{
		message: message,
		status:  status,
		error:   err,
		causes:  causes,
	}
}

func NewRestErrorFromBytes(bytes []byte) (RestErr, error) {
	var apiErr tempRestErr
	if err := json.Unmarshal(bytes, &apiErr); err != nil {
		return nil, errors.New("invalid json")
	}
	return apiErr.convertToRestErr(), nil
}

func NewBadRequestError(message string) RestErr {
	return restErr{
		message: message,
		status:  http.StatusBadRequest,
		error:   "bad_request",
	}
}

func NewNotFoundError(message string) RestErr {
	return restErr{
		message: message,
		status:  http.StatusNotFound,
		error:   "not_found",
	}
}

func NewUnauthorizedError(message string) RestErr {
	return restErr{
		message: message,
		status:  http.StatusUnauthorized,
		error:   "unauthorized",
	}
}

func NewInternalServerError(message string, err error) RestErr {
	result := restErr{
		message: message,
		status:  http.StatusInternalServerError,
		error:   "internal_server_error",
	}
	if err != nil {
		result.causes = append(result.causes, err.Error())
	}
	return result
}