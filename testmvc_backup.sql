CREATE DATABASE  IF NOT EXISTS `testmvc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `testmvc`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: testmvc
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `departement`
--

DROP TABLE IF EXISTS `departement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departement` (
  `id_departement` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_departement`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departement`
--

LOCK TABLES `departement` WRITE;
/*!40000 ALTER TABLE `departement` DISABLE KEYS */;
INSERT INTO `departement` VALUES (1,'Managua'),(2,'Masaya'),(3,'Granda'),(4,'Carazo'),(5,'Chinandega'),(6,'Leon'),(7,'Boaco'),(8,'Jinotega'),(9,'Rivas'),(10,'Chontales'),(11,'Nueva Segovia'),(12,'Madrid'),(13,'Esteli'),(14,'RACN'),(15,'RACS');
/*!40000 ALTER TABLE `departement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipally`
--

DROP TABLE IF EXISTS `municipally`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipally` (
  `idmunicipally` int(11) NOT NULL AUTO_INCREMENT,
  `municipally_name` varchar(50) NOT NULL,
  `id_department` int(11) NOT NULL,
  PRIMARY KEY (`idmunicipally`),
  KEY `id_department_idx` (`id_department`),
  CONSTRAINT `id_department` FOREIGN KEY (`id_department`) REFERENCES `departement` (`id_departement`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipally`
--

LOCK TABLES `municipally` WRITE;
/*!40000 ALTER TABLE `municipally` DISABLE KEYS */;
INSERT INTO `municipally` VALUES (1,'Managua',1),(3,'Ciudad Sandino',1);
/*!40000 ALTER TABLE `municipally` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `idperson` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` bit(1) NOT NULL,
  `born_date` date NOT NULL,
  `born_dapartment` int(11) NOT NULL,
  `born_municipaly` int(11) NOT NULL,
  `identification` varchar(50) NOT NULL,
  PRIMARY KEY (`idperson`),
  KEY `born_department_idx` (`born_dapartment`),
  KEY `born_municipally_idx` (`born_municipaly`),
  CONSTRAINT `born_department` FOREIGN KEY (`born_dapartment`) REFERENCES `departement` (`id_departement`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `born_municipally` FOREIGN KEY (`born_municipaly`) REFERENCES `municipally` (`idmunicipally`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Moises','Mena',19,'','1997-11-05',1,1,'001-051197-0019T'),(2,'Moises','Mena',19,'','1997-11-05',1,1,'19971105'),(3,'Alex','Coin',12,'','1997-11-05',1,1,'002-00000-0000a'),(4,'Alex','Alencar',12,'','1997-11-05',1,1,'000-000000-0000a'),(5,'Chandler','Withrows',23,'','1997-11-05',1,1,'000-000000-0000a'),(6,'Kattya','Lopez',26,'','1997-11-05',1,1,'sin cedula'),(7,'Aska','Langly',14,'','1997-11-05',1,1,'sin cedula'),(8,'Misa','Amane',21,'','1997-11-05',1,1,'sin identificacion'),(9,'Ligth','Yagami',23,'','1997-11-05',1,1,'sin registrarse'),(10,'Brand','Palmer',28,'','1997-11-05',1,1,'sin registro'),(11,'Rei','Ayanami',15,'','1997-11-05',1,1,'sin registro'),(12,'Gendo','ikari',30,'','1997-11-05',1,1,'no'),(13,' Elias','Zelaya',22,'','1997-11-05',1,1,'sin cedula'),(14,'Bryan','Jimenez',18,'','1997-11-05',1,1,'sin cedula');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-06 10:03:25
