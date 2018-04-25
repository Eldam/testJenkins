Drop DATABASE if exists `letta`;
CREATE DATABASE `letta`;

CREATE TABLE `letta`.`user` (
	`id` int NOT NULL AUTO_INCREMENT,
	`login` varchar(100) NOT NULL,
	`password` varchar(64) NOT NULL,
	`name` varchar(50),
	`surname` varchar(50),
	`email` varchar(50),
	`inscription_date` date,
	PRIMARY KEY (`id`),
	CONSTRAINT UC_User UNIQUE (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `letta`.`event` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`description` varchar(150),
	`date` date NOT NULL,
	`time` time NOT NULL,
	`category` varchar(25) NOT NULL,
	`maxInscriptions` int NOT NULL,
	`location` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `letta`.`user_event` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_user` int NOT NULL,
	`id_event` int NOT NULL,
	`moderator` boolean,
	`description` varchar(150),
	`date` date,
	`time` time,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `letta`.`user_event`
ADD CONSTRAINT `delete_user_fk` FOREIGN KEY (`id_user`) REFERENCES `letta`.`user`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `delete_event_fk` FOREIGN KEY (`id_event`) REFERENCES `letta`.`event`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; 

GRANT ALL ON `letta`.* TO 'daa'@'localhost' IDENTIFIED BY 'daa';
