CREATE TABLE IF NOT EXISTS CRYPTO_CURRENCY_TYPE (
    id INT primary key,
    crypto_name VARCHAR(30)
);
CREATE TABLE IF NOT EXISTS CRYPTO_CURRENCY (
    id INT primary key auto_increment,
    id_crypto_currency_type INT not null unique,
    price DECIMAL(10,2) not null,
    FOREIGN KEY(id_crypto_currency_type) REFERENCES CRYPTO_CURRENCY_TYPE(id)
);
CREATE TABLE IF NOT EXISTS USER_CURRENCY (
     id INT primary key auto_increment,
     id_crypto_currency_type INT not null,
     user_name VARCHAR (100) not null,
     price DECIMAL(10,2) not null,
     FOREIGN KEY(id_crypto_currency_type) REFERENCES CRYPTO_CURRENCY_TYPE(id)
);