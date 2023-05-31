INSERT INTO roles (id, role) VALUES ('56323662-02e1-4b8d-ac78-2f9caa23a281', 'ADMIN');
INSERT INTO roles (id, role) VALUES ('56323662-02e2-4b8d-ac78-2f9caa23a281', 'USER');

-- Inserting data into the carts table
--INSERT INTO carts (id, total_cost, user_id) VALUES
--    ('1', 148.76, '1'),
--    ('2', 28.99, '2'),
--    ('3', 44.89, '3');

-- Inserting data into the carts table
INSERT INTO carts (id, user_id) VALUES
    ('1', '1'),
    ('2', '2'),
    ('3', '3');


   -- Inserting data into the cart_product table
INSERT INTO cart_items (id, name, quantity, price, cart_id, product_id) VALUES
    ('1', James, 108.69, '1', '1'),
    ('2', Anna, 39.99, '2', '2'),
    ('3', Lizzy, 44.89, '3', '3'),
    ('4', Joe, 57.98, '1', '2');

-- Inserting data into the cart_product table
--INSERT INTO cart_items (id, name, quantity, price, cart_id, product_id) VALUES
--    ('1', 1, 108.69, '1', '1'),
--    ('2', 1, 39.99, '2', '2'),
--    ('3', 1, 44.89, '3', '3'),
--    ('4', 2, 57.98, '1', '2');

-- Inserting data into the orders table
--INSERT INTO orders (id, created_at, total_cost, user_id) VALUES
--    ('1', CURRENT_TIMESTAMP, 148.76, '1'),
--    ('2', CURRENT_TIMESTAMP, 39.99, '2'),
--    ('3', CURRENT_TIMESTAMP, 158.67, '3');
--
---- Inserting data into the order_items table
--INSERT INTO order_items (id, quantity, price, order_id, product_id) VALUES
--    ('1', 1, 108.69, '1', '1'),
--    ('2', 2, 57.98, '1', '2'),
--    ('3', 1, 39.99, '2', '2'),
--    ('4', 1, 44.89, '3', '3');