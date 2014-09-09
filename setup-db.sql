#-----------------------------------
#SCHEMA CREATION
#-----------------------------------
CREATE DATABASE `jee-training`;

USE `jee-training`;


#-----------------------------------
#TABLE CREATION
#-----------------------------------
CREATE  TABLE user (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `login` VARCHAR(255) NOT NULL ,

  `password` VARCHAR(45) NULL ,

  PRIMARY KEY (`id`) );

#-----------------------------------
#DEFAULT ENTRIES
#-----------------------------------
INSERT INTO user (login, password) VALUES ('root', 'toor');
INSERT INTO user (login, password) VALUES ('user1', 'qwerty');
INSERT INTO user (login, password) VALUES ('user2', '123456');


#-----------------------------------
#USER RIGHTS MANAGEMENT
#-----------------------------------
CREATE USER 'jee-training'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON `jee-training`.* TO 'jee-training'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;
