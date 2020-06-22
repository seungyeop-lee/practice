package templates

import (
	"html/template"
	"io/ioutil"
	"os"
	"path/filepath"
)

func CreateTemplate(path string, data string) error {
	return ioutil.WriteFile(path, []byte(data), os.FileMode(0755))
}

func InitTemplates() error {
	tempDir, err := ioutil.TempDir("", "temp")
	if err != nil {
		return err
	}
	defer os.RemoveAll(tempDir)
	err = CreateTemplate(filepath.Join(tempDir, "t1.tmpl"), `
		Template 1! {{ .Var1 }}
		{{ block "template2" .}} {{end}}
		{{ block "template3" .}} {{end}}
	`)
	if err != nil {
		return err
	}
	err = CreateTemplate(filepath.Join(tempDir, "t2.tmpl"),
		`{{ define "template2"}}Template 2! {{ .Var2 }}{{end}}`)
	if err != nil {
		return err
	}

	err = CreateTemplate(filepath.Join(tempDir, "t3.tmpl"),
		`{{ define "template3"}}Template 3! {{ .Var3 }}{{end}}`)
	if err != nil {
		return err
	}
	pattern := filepath.Join(tempDir, "*.tmpl")

	tmpl, err := template.ParseGlob(pattern)
	if err != nil {
		return err
	}
	tmpl.Execute(os.Stdout, map[string]string {
		"Var1": "Var1!!",
		"Var2": "Var2!!",
		"Var3": "Var3!!",
	})
	return nil
}