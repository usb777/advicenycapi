/*
SQLyog Ultimate v12.2.6 (64 bit)
MySQL - 10.4.11-MariaDB : Database - usb777_advicenyc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`usb777_advicenyc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `usb777_advicenyc`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values 
(1,'Sightseeing'),
(2,'Museum'),
(3,'Cultural Arts'),
(4,'Flea Market'),
(5,'Dinning'),
(6,'Shopping'),
(7,'string7777');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`role_name`) values 
(1,'administrator'),
(2,'moderator'),
(3,'superuser'),
(4,'user');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `role` int(11) DEFAULT 4,
  `role_name` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `fk_role` (`role`),
  KEY `FKio7xawwvpk025stk4xkq2t0y8` (`role_name`),
  CONSTRAINT `FKio7xawwvpk025stk4xkq2t0y8` FOREIGN KEY (`role_name`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`fullname`,`email`,`username`,`password`,`role`,`role_name`) values 
(1,'Dzmitry Samoila','dzsamoila@gmail.com','admin777admin','fight160583ds',1,NULL),
(2,'Timur Zakieff','tzakieff@gmail.com','tsimur','zxcdsaqwe',2,NULL),
(4,'aNDREI kOINASH','KOINASH@GMAIL.COM','koinash','123',4,NULL),
(5,'OaeNaxam','allinuskase@mail.ru','OaeNaxam','j7fvN9c5fF',4,NULL),
(6,'RomosoVZ','romanmol90@mail.ru','RomosoVZ','He837wyvQ',4,NULL),
(9,'Dzen 777Dzen','dzen5789@gmaiol.com','vasilJarko','passw',2,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
