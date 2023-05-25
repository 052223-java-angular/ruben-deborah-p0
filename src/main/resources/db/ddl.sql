drop table if exists carts cascade;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
drop table if exists products cascade;
drop table if exists cart_items cascade;
drop table if exists categories cascade;
drop table if exists order_items cascade;

CREATE TABLE roles (
    id VARCHAR PRIMARY KEY NOT NULL,
    role VARCHAR NOT NULL
);

CREATE TABLE users (
    id VARCHAR PRIMARY KEY NOT NULL,
    username VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    role_id VARCHAR NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

create table carts (
	id varchar primary key,
	user_id varchar not null,
	foreign key (user_id) references users(id)
);

create table categories (
	id VARCHAR primary key not null,
	category VARCHAR not null
);

CREATE TABLE products (
    id VARCHAR PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    price VARCHAR NOT NULL,
    category_id VARCHAR NOT null,
    foreign key (category_id) references categories (id)
);

create table cart_items (
	id VARCHAR primary key,
	quantity varchar not null,
	price varchar not null,
	cart_id varchar not null,
	product_id varchar not null,
	foreign key (cart_id) references carts (id),
	foreign key (product_id) references products (id)
);

CREATE TABLE reviews (
    id VARCHAR PRIMARY KEY NOT NULL,
    review VARCHAR NOT NULL,
    rating VARCHAR NOT NULL,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE orders (
    id VARCHAR PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    price VARCHAR NOT NULL,
    amount VARCHAR NOT NULL,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

create table order_items (
	id varchar primary key not null,
	quantity varchar not null,
	price varchar not null,
	order_id varchar not null,
	product_id varchar not null,
	foreign key (order_id) references orders (id),
	foreign key(product_id) references products (id)
);

