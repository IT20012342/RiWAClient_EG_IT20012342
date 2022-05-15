-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: electrogrid
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `accountNumber` int NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `NIC` varchar(20) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `reset_code` varchar(45) DEFAULT NULL,
  `userRole` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`),
  CONSTRAINT `role_constraint` CHECK (((`userRole` = _utf8mb4'Admin') or (`userRole` = _utf8mb4'User') or (`userRole` = _utf8mb4'Supplier')))
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kumar','123456',1166578970,'Colombo 6','991234231V','0774589232','reset123','Admin'),(6,'Akila','54321',1166345089,'Malabe 5','983425386V','0713425876','reset456','User'),(8,'Sachin','654321',1166345086,'Kur+2345','983459886V','0713485876','reset123','User'),(9,'Avishka','123456',1166345086,'Kur45','983459843V','0713485876','reset123','Admin'),(11,'Kavishka','kavish1999',1166343869,'Kur+80','983459656V','0713485473','reset456','User'),(13,'jmisuruprabhath','700310876vI@',1234567834,'Isuru 1999','991671323V','0774568111','reset123','Admin'),(14,'qubitmania','12345678',1122345637,'No. 6, Nagahawaththa, Makandura, Gonawila','991671323V','0774568111','reset345','Admin'),(15,'it20012342%40my.sliit.lk','12345678',1234567654,'No. 6, Nagahawaththa, Makandura, Gonawila','991734575V','0774568111','res234','Admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 19:32:36
