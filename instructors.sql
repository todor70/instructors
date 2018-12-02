DROP SCHEMA IF EXISTS `instructors`;

CREATE SCHEMA `instructors`;
use `instructors`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `enabled` BIT(1) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
(1,'zeljko','{bcrypt}$2a$10$ewdVrbKvNx0FdkdVsp.iGeQto7B5M3/.8wtbMvGOu.Y9AeSPhj2Ei');

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `authority` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`authority`,`username`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` 
VALUES 
('ROLE_ADMIN','zeljko');

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `instructor_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `day_of_birth` DATE NULL DEFAULT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`instructor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `start` DATE NULL DEFAULT NULL,
  `end` DATE NULL DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`instructor_id`) 
  REFERENCES `instructor` (`instructor_id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




