BEGIN TRANSACTION;
DROP TABLE IF EXISTS collection;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS card;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	email varchar(100),
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE card (
    card_id int,
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
    collection_id SERIAL,
    collection_name varchar(100) NOT NULL,
    cards card[]
);

COMMIT TRANSACTION;















