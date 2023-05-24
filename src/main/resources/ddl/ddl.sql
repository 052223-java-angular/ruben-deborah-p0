DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS restaurants CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;

CREATE TABLE roles (
    id VARCHAR PRIMARY KEY,
    role VARCHAR NOT NULL
);

CREATE TABLE users (
    id VARCHAR PRIMARY KEY,
    username VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    role_id VARCHAR NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);

CREATE TABLE reviews (
    id VARCHAR PRIMARY KEY,
    review VARCHAR NOT NULL,
    rating VARCHAR NOT NULL,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE products (
    id VARCHAR PRIMARY KEY,
    name VARCHAR NOT NULL,
    price VARCHAR NOT NULL,
    category VARCHAR NOT NULL,
    review_id VARCHAR NOT NULL,
    FOREIGN KEY (review_id) REFERENCES reviews (id)
);
