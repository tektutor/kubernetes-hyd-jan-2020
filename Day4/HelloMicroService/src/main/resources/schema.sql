CREATE TABLE message ( 
	id INTEGER NOT NULL AUTO_INCREMENT,
	message VARCHAR(50),
	PRIMARY_KEY(id)
);

INSERT INTO message(message) VALUES ("Message from Mysql DB");
