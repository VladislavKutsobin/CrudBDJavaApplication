CREATE DATABASE IF NOT EXISTS testDB DEFAULT CHARACTER SET utf8;

USE testDB;

CREATE TABLE IF NOT EXISTS akills (
id INT(5) AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS developers (
id INT(5) AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(64),
lastname VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS accounts (
id INT(5) AUTO_INCREMENT PRIMARY KEY,
login VARCHAR(10),
developerdata VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS users_skills(
  user_id INT NOT NULL ,
  skill_id INT NOT NULL ,
  PRIMARY KEY (user_id , skill_id),
  FOREIGN KEY (user_id) REFERENCES users(id) on delete cascade,
  FOREIGN KEY (skill_id) REFERENCES skills(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS users_accounts(
  user_id INT NOT NULL UNIQUE ,
  account_id INT NOT NULL UNIQUE,
  PRIMARY KEY (user_id , account_id),
  FOREIGN KEY (user_id) REFERENCES users(id) on delete cascade,
  FOREIGN KEY (account_id) REFERENCES accounts(id) on delete cascade
);

