/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.15 : Database - mydays
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydays` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `mydays`;

/*Table structure for table `tab_account` */

DROP TABLE IF EXISTS `tab_account`;

CREATE TABLE `tab_account` (
  `accountID` int(10) NOT NULL AUTO_INCREMENT,
  `userID` int(10) NOT NULL,
  `email` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastEditTime` datetime DEFAULT NULL,
  PRIMARY KEY (`accountID`),
  UNIQUE KEY `email` (`email`),
  KEY `userID` (`userID`),
  CONSTRAINT `tab_account_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tab_person` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tab_account` */

insert  into `tab_account`(`accountID`,`userID`,`email`,`password`,`createTime`,`lastEditTime`) values 
(1,1,'sssss','GZYH','2019-05-12 08:08:48','2019-05-12 08:08:52');

/*Table structure for table `tab_person` */

DROP TABLE IF EXISTS `tab_person`;

CREATE TABLE `tab_person` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) DEFAULT NULL,
  `profileImg` varchar(1024) DEFAULT NULL,
  `email` varchar(1024) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `enableStatus` int(2) NOT NULL DEFAULT '0' COMMENT '0禁止使用，1可以使用',
  `userType` int(2) NOT NULL DEFAULT '1' COMMENT '1用户2超管',
  `createTime` datetime DEFAULT NULL,
  `lastEditTime` datetime DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `tab_person` */

insert  into `tab_person`(`userID`,`userName`,`profileImg`,`email`,`gender`,`enableStatus`,`userType`,`createTime`,`lastEditTime`) values 
(1,'Ding','1','sssss','n',0,1,'2019-03-30 10:28:00','2019-03-31 10:28:05'),
(2,'Hao','2','wwwww','n',0,1,'2019-03-30 10:28:08','2019-03-31 10:28:12'),
(5,'He','3','qqqqq','n',0,1,'2019-03-30 10:29:22','2019-03-30 10:29:25'),
(20,'Wu','4','rrrrr','n',1,2,'2019-03-31 00:00:00','2019-03-31 00:00:00'),
(50,'TxgT','5xg','uuuuxgu','n',1,2,'2019-03-31 00:00:00','2019-03-31 00:00:00'),
(51,'Wu','4','rrrrr','n',1,2,'2019-05-12 00:00:00','2019-05-12 00:00:00');

/*Table structure for table `tab_shcedule` */

DROP TABLE IF EXISTS `tab_shcedule`;

CREATE TABLE `tab_shcedule` (
  `taskID` int(30) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `taskDesc` varchar(2048) DEFAULT NULL,
  `startTime` varchar(20) DEFAULT NULL,
  `endTime` varchar(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastEditTime` datetime DEFAULT NULL,
  `userID` int(10) NOT NULL,
  `perorities` int(2) DEFAULT '0',
  `enableStatus` int(2) DEFAULT '0',
  PRIMARY KEY (`taskID`),
  KEY `userID` (`userID`),
  CONSTRAINT `tab_shcedule_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tab_person` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_shcedule` */

/*Table structure for table `tab_wechataccount` */

DROP TABLE IF EXISTS `tab_wechataccount`;

CREATE TABLE `tab_wechataccount` (
  `weChatID` int(10) NOT NULL AUTO_INCREMENT,
  `openID` varchar(1024) NOT NULL,
  `userID` int(10) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`weChatID`),
  UNIQUE KEY `openID` (`openID`),
  KEY `userID` (`userID`),
  CONSTRAINT `tab_wechataccount_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tab_person` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_wechataccount` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
