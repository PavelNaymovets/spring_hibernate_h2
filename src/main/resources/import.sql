DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255),  price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Молоко', 100), ('Хлеб', 70), ('Мороженое', 10), ('Конфеты', 90), ('Сахар', 50);
