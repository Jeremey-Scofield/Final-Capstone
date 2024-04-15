BEGIN TRANSACTION;


DROP TABLE IF EXISTS collection_cards;
DROP TABLE IF EXISTS collection;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS images;

-- Create tables in the order they are referenced by foreign keys

CREATE TABLE users (
  user_id SERIAL,
  username varchar(50) NOT NULL UNIQUE,
  password_hash varchar(200) NOT NULL,
  email varchar(50),
  role varchar(50) NOT NULL,
  CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE collections (
 	collection_id SERIAL,
  	collection_name varchar(100) NOT NULL,
	user_id int,
	
	CONSTRAINT PK_collection PRIMARY KEY (collection_id),
	CONSTRAINT FK_collection_user FOREIGN KEY(user_id) REFERENCES users(user_id)
  	
);

CREATE TABLE collection_cards (
  collection_id int,
  card_id varchar(100),
  
  CONSTRAINT FK_collection_cards_collection FOREIGN KEY(collection_id) REFERENCES collections(collection_id)
 
);

COMMIT TRANSACTION;