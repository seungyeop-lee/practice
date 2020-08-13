package mocking

import (
	"errors"
	"testing"
)

func TestThrowError(t *testing.T) {
	tests := []struct {
		name    string
		wantErr bool
	}{
		{"base-case", true},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if err := ThrowError(); (err != nil) != tt.wantErr {
				t.Errorf("DoSomeStuff() error = %v, wantErr %v", err, tt.wantErr)
			}
		})
	}
}

func TestDoSomeStuff(t *testing.T) {
	tests := []struct {
		name       string
		DoStuff    error
		ThrowError error
		wantErr    bool
	}{
		{"base-case", nil, nil, false},
		{"DoStuff error", errors.New("failed"), nil, true},
		{"ThrowError error", nil, errors.New("failed"), true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			//mock 구조체를 사용해 테스트용 인터페이스를 구현(mocking)한 예
			d := MockDoStuffer{}
			d.MockDoStuff = func(string) error {
				return tt.DoStuff
			}

			defer Patch(&ThrowError, func() error {
				return tt.ThrowError
			}).Restore()

			if err := DoSomeStuff(&d); (err != nil) != tt.wantErr {
				t.Errorf("DoSomeStuff() error = %v, wantErr %v", err, tt.wantErr)
			}
		})
	}
}
