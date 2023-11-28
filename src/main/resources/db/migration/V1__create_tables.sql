create table users(
   id BIGINT NOT NULL AUTO_INCREMENT,
   username VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   avatar_url VARCHAR(255) NOT NULL,
   PRIMARY KEY (id)
);


create table product(
   id BIGINT NOT NULL AUTO_INCREMENT,
   seller_id BIGINT NOT NULL,
   title VARCHAR(255),
   description VARCHAR(1024),
   attachments_url VARCHAR(1024),
   category VARCHAR(100),
   initial_bid DECIMAL(15,2),
   min_raise DECIMAL(15,2),
   autosell_price DECIMAL(15,2),
   start_at TIMESTAMP,
   end_at TIMESTAMP,
   PRIMARY KEY (id)
);

create table bid(
   id BIGINT NOT NULL AUTO_INCREMENT,
   product_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL,
   amount DECIMAL(15,2),
   created_at TIMESTAMP,
   PRIMARY KEY (id)
);

create table message(
   id BIGINT NOT NULL AUTO_INCREMENT,
   room_id BIGINT NOT NULL,
   content VARCHAR(1024),
   caption VARCHAR(255),
   sent_at TIMESTAMP,
   PRIMARY KEY (id)
);

create table chatroom(
   id BIGINT NOT NULL AUTO_INCREMENT,
   product_id BIGINT NOT NULL,
   seller_id BIGINT NOT NULL,
   buyer_read  TIMESTAMP,
   seller_read TIMESTAMP,
   PRIMARY KEY (id)
);