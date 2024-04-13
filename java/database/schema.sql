BEGIN TRANSACTION;


DROP TABLE IF EXISTS collection_cards;
DROP TABLE IF EXISTS collection;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS card;

-- Create tables in the order they are referenced by foreign keys

CREATE TABLE users (
  user_id SERIAL,
  username varchar(50) NOT NULL UNIQUE,
  password_hash varchar(200) NOT NULL,
  email varchar(100),
  role varchar(50) NOT NULL,
  CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE card (
  card_id SERIAL UNIQUE,
  card_name varchar(100) NOT NULL,
  manacost varchar(20) NOT NULL,
  colors varchar(10) NOT NULL,
  coloridentity varchar(10) NOT NULL,
  type varchar(50),
  subtype varchar(50),
  rarity varchar(20),
  set varchar(20),
  set_name varchar(50),
  text varchar(250),
  artist varchar(100),
  image BYTEA
);

CREATE TABLE collection (
  collection_id SERIAL UNIQUE,
  collection_name varchar(100) UNIQUE NOT NULL,

  CONSTRAINT unique_collection_name UNIQUE (collection_name)
);

CREATE TABLE collection_cards (
  collection_id int,
  card_id int,
  quantity int DEFAULT 1,
  CONSTRAINT PK_collection_cards PRIMARY KEY(collection_id, card_id),
  CONSTRAINT FK_collection_cards_collection FOREIGN KEY(collection_id) REFERENCES collection(collection_id),
  CONSTRAINT FK_collection_cards_cards FOREIGN KEY(card_id) REFERENCES card(card_id)  -- Corrected typo here
);

COMMIT TRANSACTION;