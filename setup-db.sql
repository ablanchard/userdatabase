#-----------------------------------
#SCHEMA CREATION
#-----------------------------------
CREATE DATABASE `jee-training`;

USE `jee-training`;


#-----------------------------------
#TABLE CREATION
#-----------------------------------
CREATE  TABLE user (

  `id` BIGINT NOT NULL AUTO_INCREMENT ,

  `first_name` VARCHAR(255) NOT NULL ,

  `last_name` VARCHAR(255) NULL ,

  PRIMARY KEY (`id`) );

#-----------------------------------
#DEFAULT ENTRIES
#-----------------------------------
INSERT INTO user (first_name, last_name) VALUES ('john', 'doe');
INSERT INTO user (first_name, last_name) VALUES ('alex', 'blanchard');
INSERT INTO user (first_name, last_name) VALUES ('loic', 'ortola');


#-----------------------------------
#USER RIGHTS MANAGEMENT
#-----------------------------------
CREATE USER 'jee-training'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON `jee-training`.* TO 'jee-training'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;
