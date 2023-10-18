CREATE DATABASE demo_db;


CREATE TABLE IF NOT EXISTS pears
( id INTEGER NOT NULL AUTO_INCREMENT,
  img VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  article VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS coconuts
( id INTEGER NOT NULL AUTO_INCREMENT,
  img VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  article VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
( id INTEGER NOT NULL AUTO_INCREMENT,
  order_code VARCHAR(255) NOT NULL,
  buyer_name VARCHAR(255) NOT NULL,
  buyer_phone VARCHAR(255) NOT NULL,
  buyer_email VARCHAR(255) NOT NULL,
  content VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO
 pears (img, name, article, description, price)
VALUES
 ('pear-conference.jpg', 'Pear conference', 'pc095g7', 'Lorem ipsum conference', 95.43),
 ('pears.jpg', 'Pear single', 'pc095g8', 'Lorem ipsum single', 80.45),
 ('pears-isolated.jpg', 'Pear new', 'pc095g9', 'Lorem ipsum new', 75.85);


INSERT INTO
 coconuts (img, name, article, description, price)
VALUES
 ('coconut.jpg', 'Coconut', 'qw055k9', 'Lorem ipsum coconut dark', 55.95),
 ('coconut-green.jpg', 'Coconut green', 'qw075k9', 'Lorem ipsum coconut green', 65.55),
 ('coconut-half.jpg', 'Coconut half', 'qw085k9', 'Lorem ipsum half', 45.55);


SELECT * FROM coconuts;

DELETE FROM coconuts WHERE id = 2;

UPDATE coconuts SET price = 88.88 WHERE id = 5;

SELECT * FROM coconuts ORDER BY name;

SELECT * FROM pears;

DELETE FROM pears WHERE id = 2;

UPDATE pears SET price = 55.55 WHERE id = 5;

SELECT * FROM pears ORDER BY name;