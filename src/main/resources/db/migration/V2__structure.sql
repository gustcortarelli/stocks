create schema if not exists stocks;

create sequence stocks.hibernate_sequence;

create table stocks.user (
    id int4 not null,
    username varchar(255) not null,
    primary key (id),
    constraint ukc_username unique(username)
);

create table stocks.stocks_data (
    id int4 not null,
    data text not null,
    function varchar(255) not null,
    driver varchar(255) not null,
    request_date timestamp not null,
    request_parameters varchar(255) not null,
    symbol varchar(255) not null,
    primary key (id),
    constraint ukc_symbol_function unique(symbol, function, driver)
);

create table stocks.user_stocks (
    id int4 not null,
    date timestamp not null,
    quantity numeric not null,
    symbol varchar(255) not null,
    user_id int4 not null,
    value numeric not null,
    primary key (id)
);