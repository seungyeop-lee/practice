create keyspace oauth with replication = {'class':'SimpleStrategy', 'replication_factory':1};

create table access_tokens(
    access_token varchar PRIMARY KEY,
    user_id bigint,
    client_id bigint,
    expires bigint
);

select *
from access_tokens
where access_token='sdfj';

select *
from access_tokens
where user_id=123;