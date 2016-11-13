-- MySQL dump 10.13  Distrib 5.6.33, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ticket_for_events
-- ------------------------------------------------------
-- Server version	5.6.33-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event_tickets`
--

DROP TABLE IF EXISTS `event_tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `left` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tickets`
--

LOCK TABLES `event_tickets` WRITE;
/*!40000 ALTER TABLE `event_tickets` DISABLE KEYS */;
INSERT INTO `event_tickets` VALUES (2,12,'HMIF Graduation','Acara Wisuda HMIF tahun 2016',25000,100),(3,15,'SOA Oriented Architecture','Seminar SOA',13000,100),(4,3219,'adrian','desription adrian',200,83140),(5,3219,'adrian','desription adrian',200,83148),(6,3219,'adrian','desription adrian',200,83148),(7,3219,'adrian','desription adrian',200,83148),(8,3219,'adrian','desription adrian',200,83148),(9,3219,'adrian','desription adrian',200,83148),(10,48038290,'adrian','desription adrian',200,83148),(11,48038290,'adrian','desription adrian',200,83148),(12,3219,'adrian','desription adrian',200,83148),(13,48038290,'adrian','desription adrian',200,83148),(14,3219,'adrian','desription adrian',200,83148),(15,48038290,'adrian','new',100,83148),(16,3219,'adrian','desription adrian',200,83148),(17,48038290,'adrian','desription adrian',200,83148),(18,3219,'adrian','desription adrian',200,83148),(19,321243,'adrian','desription adrian',200,83148),(20,48038290,'adrian','desription adrian',200,83148),(21,321243,'adrian','desription adrian',200,83148),(22,48038290,'adrian','desription adrian',200,83148),(23,321243,'adrian','desription adrian',200,83148);
/*!40000 ALTER TABLE `event_tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(60) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `description` text,
  `endTime` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  `pictureUrl` varchar(200) DEFAULT NULL,
  `postalCode` int(6) DEFAULT NULL,
  `startTime` datetime NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `tags` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `userID` int(10) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (13,'Gang Buntu 100','Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 5','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-13 07:59:50','2016-11-12 17:00:00'),(15,'Gang Buntu 100','Ruteng','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 1','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','In Place',2,'2016-11-13 07:33:19','2016-11-12 17:00:00'),(21,'Gang Buntu 100','Ruteng','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event10','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','In Place',2,'2016-11-13 07:33:19','2016-11-12 17:00:00'),(22,'Gang Buntu 100','Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 1','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(23,NULL,'Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 2','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(24,'Gang Buntu 100','Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 1','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(25,NULL,'Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 2','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(26,'Gang Buntu 100','Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 1','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(27,NULL,'Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 2','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(28,'Gang Buntu 100','Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 1','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(29,NULL,'Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 2','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(30,'Gang Buntu 100','Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 1','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00'),(31,NULL,'Surabaya','Indonesia','Khusus Orang Gila','2016-01-01 00:00:00','Event 2','http://imagetri/pic1.jpg',0,'2016-01-01 00:00:00','Jawa Timur','published','tri','Online',1,'2016-11-12 17:00:00','2016-11-12 17:00:00');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(30) NOT NULL DEFAULT 'PENDING',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (11,1,1,1,'PREMIUM',10000,'albert','adrian','alberttri23@gmail.com','2016-11-13 06:06:07','2016-11-13 06:06:07','PENDING'),(12,2,2,2,'PREMIUM',10000,'ivan','andrianto','ivan19@gmail.com','2016-11-13 06:06:52','2016-11-13 06:06:52','PENDING'),(13,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 06:48:45','2016-11-13 06:48:45','PENDING'),(14,19,0,0,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 06:58:49','2016-11-13 06:58:49','PENDING'),(15,19,0,0,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 06:59:04','2016-11-13 06:59:04','PENDING'),(16,19,0,0,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 06:59:12','2016-11-13 06:59:12','PENDING'),(17,48902,948903,3409284,'PREMIUM',0,'Fitra','Rahma','fitra@gmail.com','2016-11-13 06:59:50','2016-11-13 06:59:50','PENDING'),(18,400,400,2100,'PREMIUM',2000,'Lie','Adrian','lie@gmail.com','2016-11-13 07:26:30','2016-11-13 07:27:52','CANCELLED'),(19,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 07:26:49','2016-11-13 07:26:49','PENDING'),(20,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 07:30:20','2016-11-13 07:30:20','PENDING'),(21,19,20,21,'PREMIUM',2000,'haha','hihih','haha@gmail.com','2016-11-13 07:31:52','2016-11-13 07:33:18','PENDING'),(22,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 07:35:59','2016-11-13 07:35:59','PENDING'),(23,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 07:37:15','2016-11-13 07:37:15','PENDING'),(24,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 07:41:45','2016-11-13 07:41:45','PENDING'),(25,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 07:42:43','2016-11-13 07:42:43','PENDING'),(26,19,20,21,'PREMIUM',2000,'Fitra','Rahma','fitra@gmail.com','2016-11-13 07:55:08','2016-11-13 07:55:08','PENDING');
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `email` varchar(30) NOT NULL,
  `external_id` int(11) NOT NULL,
  `status` varchar(30) NOT NULL DEFAULT 'PENDING',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (2,12243,500,'alberttri23@gmail.com',2345678,'COMPLETED'),(3,12243,500,'alberttri23@gmail.com',2345678,'PENDING'),(4,12243,500,'alberttri23@gmail.com',2345678,'PENDING'),(5,12243,500,'alberttri23@gmail.com',2345678,'PENDING'),(6,1267,500,'alberttri23@gmail.com',2345678,'PENDING'),(7,1267,500,'alberttri23@gmail.com',2345678,'PENDING'),(8,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(9,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(10,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(11,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(12,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(13,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(14,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(15,1895,500,'alberttri23@gmail.com',2345678,'PENDING'),(16,1895,500,'alberttri23@gmail.com',2345678,'PENDING');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `postalCode` int(6) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'tole',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'eo 1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-13 15:18:21
