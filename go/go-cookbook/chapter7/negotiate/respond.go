package negotiate

import (
	"io"

	"github.com/unrolled/render"
)

//Respond 함수는 콘텐트 타입(ContentType)에 따라
//응답을 전환(switch)한다.
func (n *Negotiator) Respond(w io.Writer, status int, v interface{}) {
	switch n.ContentType {
	case render.ContentJSON:
		n.Render.JSON(w, status, v)
	case render.ContentXML:
		n.Render.XML(w, status, v)
	default:
		n.Render.JSON(w, status, v)
	}
}
