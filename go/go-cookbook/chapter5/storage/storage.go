package storage

import (
	"context"
	"gopkg.in/mgo.v2"
)

type Item struct {
	Name string
	Price int64
}

type Storage interface {
	GetByName(context.Context, string) (*Item, error)
	Put(context.Context, *Item) error
}

type MongoStorage struct {
	*mgo.Session
	DB string
	Collection string
}

func NewMongoStorage(connection, db, collection string) (*MongoStorage, error) {
	session, err := mgo.Dial(connection)
	if err != nil {
		return nil, err
	}
	ms := MongoStorage{
		Session:    session,
		DB:         db,
		Collection: collection,
	}
	return &ms, nil
}
