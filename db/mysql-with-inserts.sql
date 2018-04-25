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
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `letta`.`user_event`
ADD CONSTRAINT `delete_user_fk` FOREIGN KEY (`id_user`) REFERENCES `letta`.`user`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `delete_event_fk` FOREIGN KEY (`id_event`) REFERENCES `letta`.`event`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; 

GRANT ALL ON `letta`.* TO 'daa'@'localhost' IDENTIFIED BY 'daa';

-- The password for each user is its login suffixed with "pass". For example, user "admin" has the password "adminpass".
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (1,'admin','2bdc94a3ae40227246a17831b833ba9047b4ff2778180b1a1c0c303e248e574e','Antonio','González','Antonio@email.com','2018-01-01' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (2,'marco','905d5c1331987f8670ff86955788628bda62ea165cc4c2c5b44b6402b669274d','Marco Aurelio','Paz González','marco@email.com','2018-01-02' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (3,'uxio','fc3c150e4032998daff4a4cf51b0a047e43616c42df447dff1a36c1c52fcea97','Uxío','González Fernández','uxio@email.com','2018-01-03' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (4,'alex','e6707bbebab392fbac2ed0f63388ee2388839f9133a27461f221231a27a540bb','Alex','Pérez','alex@email.com','2018-01-04' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (5,'victor','a67d077fb31b1b890c0f2f98651e402488faa41b095a4d935c2aff337d01f079','Victor','Rodríguez','victor@email.com','2018-01-05' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (6,'brais','5a9a2a1c917e8b8d94802dd31a0334802c4c86a19b48dfa4e51a546ef81375c7','Brais','Coto','brais@email.com','2018-01-06' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (7,'manu','defa1c40090e0e7b8d20c28b4b9d921e6f5e1b932d8ffb1b3c9f82896f16c0ca','Manuel','Gil','manu@email.com','2018-01-07' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (8,'guillermo','1138106e49b5545514428dc22d1c94de70e97f885d7ee24cbe168d86267a2e4f','Guillermo','Pazos','guillermo@email.com','2018-01-08' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES (9,'Gabriel','24e7655da3cee593d83f8dd2dcd1d9947e14860e3b48142a026dfda6d2d2f83b','Gabriel','Estevez','gabriel@email.com','2018-01-09' );
INSERT INTO `letta`.`user` (`id`,`login`,`password`,`name`,`surname`,`email`,`inscription_date`) VALUES 
(10,'Miguel','6b35bc5c2d00d9b95cf2c4a01aad68d70ae6e6da19257e9bd82a34e29cc8afbb','Miguel','Paz','miguel@email.com','2018-01-10' );

INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (1,'Cineforum American Beauty','Discusión sobre la película','2018-01-01','01:00:00','Cine',23,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (2,'Cineforum American history X','Discusión sobre la película','2018-02-02','02:00:00','Cine', 45,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (3,'Lectura de libro Las Dos Torres','Lectura de trozos del libro por distintas personalidades','2018-03-03','03:00:00','Literatura',60,'Biblioteca Municipal, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (4,'Visionado de partido LFP','Reunión para ver el partido Levante-Leganés','2018-04-04','04:00:00','Deportes',50,'Bar Eurosport, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (5,'Reunión de antiguos alumnos','Una reunión de reencuentro','2018-05-05','05:00:00','Otros',62, 'ESEI, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (6,'Reunion para debatir Dexter','','2018-06-13','13:00:00','Series',45,'Bar Grándola, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (7,'Cineforum Gladiator','','2018-07-15','13:00:00','Cine',45,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (8,'Cineforum 50 Sombras de Grey','','2018-08-18','13:00:00','Cine',45,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (9,'Cumpleaños de Uxio','','2018-09-20','13:00:00','Otros',50,'Bar Eurosport, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (10,'Cumpleaños de Antonio','','2018-10-24','13:00:00','Otros',50,'Bar Eurosport, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (11,'Cineforum Los Piratas del Caribe','Discusión sobre la película','2018-10-25','01:00:00','Cine',45,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (12,'Cineforum Sin Perdon','Discusión sobre la película','2018-10-26','02:00:00','Cine',45,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (13,'Lectura de libro Guerra y Paz','Lectura de trozos del libro por distintas personalidades','2018-11-01','03:00:00','Literatura',60,'Biblioteca Municipal, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (14,'Visionado del combate UFC','Reunión para ver el combate entre Lyoto Machida y Conon McGregor','2018-11-02','04:00:00','Deportes',50,'Bar Eurosport, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (15,'Reunión de aficionados al Cosplay','Una reunión de Cosplay','2018-11-05','05:00:00','Otros',45,'Bar Grándola, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (16,'Reunion para depedazar la filosofía de Lost','','2018-11-13','13:00:00','Series',45,'Bar Grándola, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (17,'Cineforum Espartaco','','2018-11-15','13:00:00','Cine',45,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (18,'Cineforum Esto no es Pais para Viejos','','2018-11-18','13:00:00','Cine',45,'Ponte Vella, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (19,'Reunion para el Maraton de Dragon Ball','8 horas de Dragon Ball','2018-12-15','13:00:00','Series',45,'Bar Grándola, Ourense');
INSERT INTO `letta`.`event` (`id`,`name`,`description`,`date`,`time`,`category`, `maxInscriptions`,`location`) VALUES (20,'Reunion para el Maraton de The Walking Dead','8 horas de The Walking Dead','2018-12-18','13:00:00','Series',45,'Bar Grándola, Ourense');


INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (1,1,1,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (2,2,1,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (3,3,1,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (4,4,1,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (5,5,1,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (6,6,1,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (7,7,1,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (8,8,2,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (9,7,2,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (10,6,2,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (11,1,3,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (12,2,4,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (13,3,4,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (14,4,5,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (15,5,5,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (16,6,5,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (17,7,6,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (18,8,6,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (19,9,7,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (20,10,8,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (21,1,8,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (22,2,9,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (23,2,9,0);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (24,3,10,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (25,7,11,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (26,8,12,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (27,9,13,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (28,10,14,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (29,1,15,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (30,2,16,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (31,2,17,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (32,3,18,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (33,5,19,1);
INSERT INTO `letta`.`user_event` (`id`,`id_user`,`id_event`,`moderator`) VALUES (34,7,20,1);



