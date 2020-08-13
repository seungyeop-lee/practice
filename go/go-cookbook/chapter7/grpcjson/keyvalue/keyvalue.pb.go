// Code generated by protoc-gen-go. DO NOT EDIT.
// source: keyvalue.proto

package keyvalue

import (
	context "context"
	fmt "fmt"
	proto "github.com/golang/protobuf/proto"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	math "math"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion3 // please upgrade the proto package

type SetKeyValueRequest struct {
	Key                  string   `protobuf:"bytes,1,opt,name=key,proto3" json:"key,omitempty"`
	Value                string   `protobuf:"bytes,2,opt,name=value,proto3" json:"value,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *SetKeyValueRequest) Reset()         { *m = SetKeyValueRequest{} }
func (m *SetKeyValueRequest) String() string { return proto.CompactTextString(m) }
func (*SetKeyValueRequest) ProtoMessage()    {}
func (*SetKeyValueRequest) Descriptor() ([]byte, []int) {
	return fileDescriptor_d36e29ec3bae7218, []int{0}
}

func (m *SetKeyValueRequest) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_SetKeyValueRequest.Unmarshal(m, b)
}
func (m *SetKeyValueRequest) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_SetKeyValueRequest.Marshal(b, m, deterministic)
}
func (m *SetKeyValueRequest) XXX_Merge(src proto.Message) {
	xxx_messageInfo_SetKeyValueRequest.Merge(m, src)
}
func (m *SetKeyValueRequest) XXX_Size() int {
	return xxx_messageInfo_SetKeyValueRequest.Size(m)
}
func (m *SetKeyValueRequest) XXX_DiscardUnknown() {
	xxx_messageInfo_SetKeyValueRequest.DiscardUnknown(m)
}

var xxx_messageInfo_SetKeyValueRequest proto.InternalMessageInfo

func (m *SetKeyValueRequest) GetKey() string {
	if m != nil {
		return m.Key
	}
	return ""
}

func (m *SetKeyValueRequest) GetValue() string {
	if m != nil {
		return m.Value
	}
	return ""
}

type GetKeyValueRequest struct {
	Key                  string   `protobuf:"bytes,1,opt,name=key,proto3" json:"key,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *GetKeyValueRequest) Reset()         { *m = GetKeyValueRequest{} }
func (m *GetKeyValueRequest) String() string { return proto.CompactTextString(m) }
func (*GetKeyValueRequest) ProtoMessage()    {}
func (*GetKeyValueRequest) Descriptor() ([]byte, []int) {
	return fileDescriptor_d36e29ec3bae7218, []int{1}
}

func (m *GetKeyValueRequest) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetKeyValueRequest.Unmarshal(m, b)
}
func (m *GetKeyValueRequest) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetKeyValueRequest.Marshal(b, m, deterministic)
}
func (m *GetKeyValueRequest) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetKeyValueRequest.Merge(m, src)
}
func (m *GetKeyValueRequest) XXX_Size() int {
	return xxx_messageInfo_GetKeyValueRequest.Size(m)
}
func (m *GetKeyValueRequest) XXX_DiscardUnknown() {
	xxx_messageInfo_GetKeyValueRequest.DiscardUnknown(m)
}

var xxx_messageInfo_GetKeyValueRequest proto.InternalMessageInfo

func (m *GetKeyValueRequest) GetKey() string {
	if m != nil {
		return m.Key
	}
	return ""
}

type KeyValueResponse struct {
	Success              string   `protobuf:"bytes,1,opt,name=success,proto3" json:"success,omitempty"`
	Value                string   `protobuf:"bytes,2,opt,name=value,proto3" json:"value,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *KeyValueResponse) Reset()         { *m = KeyValueResponse{} }
func (m *KeyValueResponse) String() string { return proto.CompactTextString(m) }
func (*KeyValueResponse) ProtoMessage()    {}
func (*KeyValueResponse) Descriptor() ([]byte, []int) {
	return fileDescriptor_d36e29ec3bae7218, []int{2}
}

func (m *KeyValueResponse) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_KeyValueResponse.Unmarshal(m, b)
}
func (m *KeyValueResponse) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_KeyValueResponse.Marshal(b, m, deterministic)
}
func (m *KeyValueResponse) XXX_Merge(src proto.Message) {
	xxx_messageInfo_KeyValueResponse.Merge(m, src)
}
func (m *KeyValueResponse) XXX_Size() int {
	return xxx_messageInfo_KeyValueResponse.Size(m)
}
func (m *KeyValueResponse) XXX_DiscardUnknown() {
	xxx_messageInfo_KeyValueResponse.DiscardUnknown(m)
}

var xxx_messageInfo_KeyValueResponse proto.InternalMessageInfo

func (m *KeyValueResponse) GetSuccess() string {
	if m != nil {
		return m.Success
	}
	return ""
}

func (m *KeyValueResponse) GetValue() string {
	if m != nil {
		return m.Value
	}
	return ""
}

func init() {
	proto.RegisterType((*SetKeyValueRequest)(nil), "keyvalue.SetKeyValueRequest")
	proto.RegisterType((*GetKeyValueRequest)(nil), "keyvalue.GetKeyValueRequest")
	proto.RegisterType((*KeyValueResponse)(nil), "keyvalue.KeyValueResponse")
}

func init() { proto.RegisterFile("keyvalue.proto", fileDescriptor_d36e29ec3bae7218) }

var fileDescriptor_d36e29ec3bae7218 = []byte{
	// 172 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0xe2, 0xe2, 0xcb, 0x4e, 0xad, 0x2c,
	0x4b, 0xcc, 0x29, 0x4d, 0xd5, 0x2b, 0x28, 0xca, 0x2f, 0xc9, 0x17, 0xe2, 0x80, 0xf1, 0x95, 0x6c,
	0xb8, 0x84, 0x82, 0x53, 0x4b, 0xbc, 0x53, 0x2b, 0xc3, 0x40, 0xdc, 0xa0, 0xd4, 0xc2, 0xd2, 0xd4,
	0xe2, 0x12, 0x21, 0x01, 0x2e, 0xe6, 0xec, 0xd4, 0x4a, 0x09, 0x46, 0x05, 0x46, 0x0d, 0xce, 0x20,
	0x10, 0x53, 0x48, 0x84, 0x8b, 0x15, 0xac, 0x41, 0x82, 0x09, 0x2c, 0x06, 0xe1, 0x28, 0xa9, 0x71,
	0x09, 0xb9, 0x13, 0xa1, 0x5b, 0xc9, 0x89, 0x4b, 0x00, 0xa1, 0xa8, 0xb8, 0x20, 0x3f, 0xaf, 0x38,
	0x55, 0x48, 0x82, 0x8b, 0xbd, 0xb8, 0x34, 0x39, 0x39, 0xb5, 0xb8, 0x18, 0xaa, 0x12, 0xc6, 0xc5,
	0x6e, 0x97, 0xd1, 0x04, 0x46, 0x2e, 0x0e, 0x98, 0x21, 0x42, 0x8e, 0x5c, 0xcc, 0xc1, 0xa9, 0x25,
	0x42, 0x32, 0x7a, 0x70, 0x8f, 0x61, 0xfa, 0x42, 0x4a, 0x0a, 0x21, 0x8b, 0x6e, 0xbb, 0x12, 0x03,
	0xc8, 0x08, 0x77, 0x54, 0x23, 0xdc, 0x49, 0x34, 0x22, 0x89, 0x0d, 0x1c, 0x9a, 0xc6, 0x80, 0x00,
	0x00, 0x00, 0xff, 0xff, 0x40, 0x88, 0xa1, 0xa3, 0x5f, 0x01, 0x00, 0x00,
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConnInterface

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion6

// KeyValueClient is the client API for KeyValue service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://godoc.org/google.golang.org/grpc#ClientConn.NewStream.
type KeyValueClient interface {
	Set(ctx context.Context, in *SetKeyValueRequest, opts ...grpc.CallOption) (*KeyValueResponse, error)
	Get(ctx context.Context, in *GetKeyValueRequest, opts ...grpc.CallOption) (*KeyValueResponse, error)
}

type keyValueClient struct {
	cc grpc.ClientConnInterface
}

func NewKeyValueClient(cc grpc.ClientConnInterface) KeyValueClient {
	return &keyValueClient{cc}
}

func (c *keyValueClient) Set(ctx context.Context, in *SetKeyValueRequest, opts ...grpc.CallOption) (*KeyValueResponse, error) {
	out := new(KeyValueResponse)
	err := c.cc.Invoke(ctx, "/keyvalue.KeyValue/Set", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *keyValueClient) Get(ctx context.Context, in *GetKeyValueRequest, opts ...grpc.CallOption) (*KeyValueResponse, error) {
	out := new(KeyValueResponse)
	err := c.cc.Invoke(ctx, "/keyvalue.KeyValue/Get", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// KeyValueServer is the server API for KeyValue service.
type KeyValueServer interface {
	Set(context.Context, *SetKeyValueRequest) (*KeyValueResponse, error)
	Get(context.Context, *GetKeyValueRequest) (*KeyValueResponse, error)
}

// UnimplementedKeyValueServer can be embedded to have forward compatible implementations.
type UnimplementedKeyValueServer struct {
}

func (*UnimplementedKeyValueServer) Set(ctx context.Context, req *SetKeyValueRequest) (*KeyValueResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method Set not implemented")
}
func (*UnimplementedKeyValueServer) Get(ctx context.Context, req *GetKeyValueRequest) (*KeyValueResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method Get not implemented")
}

func RegisterKeyValueServer(s *grpc.Server, srv KeyValueServer) {
	s.RegisterService(&_KeyValue_serviceDesc, srv)
}

func _KeyValue_Set_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(SetKeyValueRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(KeyValueServer).Set(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/keyvalue.KeyValue/Set",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(KeyValueServer).Set(ctx, req.(*SetKeyValueRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _KeyValue_Get_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetKeyValueRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(KeyValueServer).Get(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/keyvalue.KeyValue/Get",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(KeyValueServer).Get(ctx, req.(*GetKeyValueRequest))
	}
	return interceptor(ctx, in, info, handler)
}

var _KeyValue_serviceDesc = grpc.ServiceDesc{
	ServiceName: "keyvalue.KeyValue",
	HandlerType: (*KeyValueServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Set",
			Handler:    _KeyValue_Set_Handler,
		},
		{
			MethodName: "Get",
			Handler:    _KeyValue_Get_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "keyvalue.proto",
}
