CREATE DATABASE rhythmJava;

USE rythmJava;

CREATE TABLE tbluser (
  userId varchar(20) NOT NULL,
  userPw varchar(20) NOT NULL,
  userName varchar(20) NOT NULL,
  PRIMARY KEY (userId)
);

CREATE TABLE tblmusic (
  musicNum int NOT NULL,
  musicTitle varchar(45) NOT NULL,
  musicTime int NOT NULL,
  composer varchar(45) NOT NULL,
  musicLevel int NOT NULL,
  PRIMARY KEY (musicNum)
);


INSERT INTO tblmusic (musicNum,musicTitle,musicTime,composer,musicLevel) VALUES (0,'Time-Alone',86,'softy x Lucid Green',1);
INSERT INTO tblmusic (musicNum,musicTitle,musicTime,composer,musicLevel) VALUES (1,'U&Cloud',84,'Sawano Hiroyuki',2);
INSERT INTO tblmusic (musicNum,musicTitle,musicTime,composer,musicLevel) VALUES (2,'Reminiscence',147,'no',3);
INSERT INTO tblmusic (musicNum,musicTitle,musicTime,composer,musicLevel) VALUES (3,'Far East Princess',139,'Nauts',4);
INSERT INTO tblmusic (musicNum,musicTitle,musicTime,composer,musicLevel) VALUES (4,'ex',30,'ex',5);


CREATE TABLE tblscore (
  musicNum int,
  score int,
  userId varchar(20),
  FOREIGN KEY (musicNum) REFERENCES tblmusic (musicNum),
  FOREIGN KEY (userId) REFERENCES tbluser (userId)
);



CREATE user 'root'@'10.100.204.54' identified BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'10.100.204.54';
flush PRIVILEGES;

