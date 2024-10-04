create table users(
    id bigint primary key GENERATED ALWAYS AS IDENTITY,
    name varchar,
    username varchar
);