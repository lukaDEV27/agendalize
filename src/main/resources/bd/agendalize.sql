CREATE DATABASE  IF NOT EXISTS `agendalize` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agendalize`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: agendalize
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenda` (
  `id_agenda` int NOT NULL AUTO_INCREMENT,
  `empresa_agenda_id` int NOT NULL,
  `data_disponivel_inicial` date NOT NULL,
  `data_disponivel_final` date NOT NULL,
  `nome_agenda` varchar(45) NOT NULL,
  `descricao_agenda` text,
  PRIMARY KEY (`id_agenda`),
  KEY `empresa_agenda_id_idx` (`empresa_agenda_id`),
  CONSTRAINT `empresa_agenda_id` FOREIGN KEY (`empresa_agenda_id`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (1,1,'2024-05-28','2024-10-31','DJ Agendamentos','Testando Agenda'),(2,1,'2024-05-09','2024-05-09','dfsf','festa'),(3,1,'2024-05-09','2024-05-09','salacao','festa'),(4,5,'2024-05-11','2024-05-31','ttest consulkta','testando consulta'),(5,15,'2024-05-31','2024-07-31','espetinhos','teste espetinhos'),(6,16,'2024-06-30','2024-08-31','teste','teste'),(7,1,'2024-07-31','2024-08-31','bsaudbhsuay','adsadsa'),(8,17,'2024-06-29','2024-08-29','adsadsa','adsadsa');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agenda_segmento`
--

DROP TABLE IF EXISTS `agenda_segmento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenda_segmento` (
  `agenda_id_agenda` int NOT NULL,
  `segmento_id_segmento` int NOT NULL,
  KEY `agenda_id_agenda_idx` (`agenda_id_agenda`),
  KEY `segmento_id_segmento_idx` (`segmento_id_segmento`),
  CONSTRAINT `agenda_id_agenda` FOREIGN KEY (`agenda_id_agenda`) REFERENCES `agenda` (`id_agenda`),
  CONSTRAINT `segmento_id_segmento` FOREIGN KEY (`segmento_id_segmento`) REFERENCES `segmento` (`id_segmento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda_segmento`
--

LOCK TABLES `agenda_segmento` WRITE;
/*!40000 ALTER TABLE `agenda_segmento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda_segmento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `id_agendamento` int NOT NULL AUTO_INCREMENT,
  `cliente_cpf_id` varchar(11) NOT NULL,
  `staus_agendamento_id` int NOT NULL,
  `valor_agendamento` decimal(10,2) NOT NULL,
  `data_agendamento` date NOT NULL,
  `hora_inicio_agendamento` time DEFAULT NULL,
  `hora_final_agendamento` time DEFAULT NULL,
  `agenda_agendamento_id` int NOT NULL,
  PRIMARY KEY (`id_agendamento`),
  KEY `status_agendamento_id_idx` (`staus_agendamento_id`),
  KEY `cliente_cpf_id_idx` (`cliente_cpf_id`),
  KEY `agenda_agendamento_id_idx` (`agenda_agendamento_id`),
  CONSTRAINT `agenda_agendamento_id` FOREIGN KEY (`agenda_agendamento_id`) REFERENCES `agenda` (`id_agenda`),
  CONSTRAINT `cliente_cpf_id` FOREIGN KEY (`cliente_cpf_id`) REFERENCES `cliente` (`cpf_cliente`),
  CONSTRAINT `status_agendamento_id` FOREIGN KEY (`staus_agendamento_id`) REFERENCES `status_agendamento` (`id_status_agendamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cpf_cliente` varchar(11) NOT NULL,
  `nome_cleinte` varchar(45) NOT NULL,
  `sobrenome_cliente` varchar(100) NOT NULL,
  `email_contato_cliente` varchar(100) NOT NULL,
  `endereco_cliente` varchar(100) NOT NULL,
  `cep_cliente` varchar(8) NOT NULL,
  `telefone_cliente` varchar(11) NOT NULL,
  PRIMARY KEY (`cpf_cliente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf_cliente`),
  UNIQUE KEY `email_contato_cliente_UNIQUE` (`email_contato_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_indisponivel`
--

DROP TABLE IF EXISTS `data_indisponivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_indisponivel` (
  `id_data_indisponivel` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `agenda_ind_id` int NOT NULL,
  PRIMARY KEY (`id_data_indisponivel`),
  KEY `agenda_dataInd_id_idx` (`agenda_ind_id`),
  CONSTRAINT `agenda_ind_id` FOREIGN KEY (`agenda_ind_id`) REFERENCES `agenda` (`id_agenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_indisponivel`
--

LOCK TABLES `data_indisponivel` WRITE;
/*!40000 ALTER TABLE `data_indisponivel` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_indisponivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `cnpj_empresa` varchar(14) NOT NULL,
  `nome_empresa` varchar(100) NOT NULL,
  `email_contato_empresa` varchar(100) NOT NULL,
  `descricao_empresa` text,
  `usuario_empresa_id` int NOT NULL,
  `telefone_empresa` varchar(11) NOT NULL,
  `endereco_empresa` varchar(100) NOT NULL,
  `cep_empresa` varchar(8) NOT NULL,
  `id_empresa` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_empresa`),
  UNIQUE KEY `cnpj_UNIQUE` (`cnpj_empresa`),
  UNIQUE KEY `email_contato_empresa_UNIQUE` (`email_contato_empresa`),
  KEY `usuario_empresa_id_idx` (`usuario_empresa_id`),
  CONSTRAINT `usuario_empresa_id` FOREIGN KEY (`usuario_empresa_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES ('15975365425','burger king','admin@admin.com',NULL,1,'21912345678','jardim america','12345678',1),('79579879578','gusfestas','gustafestas@contatos.com',NULL,11,'21967540521','Rua ierê 273 vicente de carvalho','21370530',2),('13648573165','Testando','testando@contato.com',NULL,7,'14523654781','teste rua 103','25865475',3),('75867567','Isas espaco','isabela@gmaill.com',NULL,13,'21912345678','jardim america','12345678',5),('1234567891054','Isas espaco','aluno@gmail.com',NULL,14,'21912345678','jardim america','12345678',8),('25647856312451','Novidades Usuais','contatoNoviades@contato.com',NULL,15,'21258478632','Rua da novidade 32, Bairro novo','32560800',14),('25485421523214','Espertinhos','contato@contato.com',NULL,16,'21584552365','espetinho 32','21548769',15),('12365696325415','mais um teste','teste@contato.com',NULL,17,'21258741236','test tetst','23654125',16),('12536245698735','asdasda','asdsa@adsa.com',NULL,19,'21563254786','Rua sdbaydbisad','23152428',17);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissao` (
  `id_permissao` int NOT NULL AUTO_INCREMENT,
  `descricao_permissao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_permissao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (3,'admin'),(4,'empresa');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segmento`
--

DROP TABLE IF EXISTS `segmento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `segmento` (
  `id_segmento` int NOT NULL AUTO_INCREMENT,
  `descricao_segmento` varchar(100) NOT NULL,
  PRIMARY KEY (`id_segmento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segmento`
--

LOCK TABLES `segmento` WRITE;
/*!40000 ALTER TABLE `segmento` DISABLE KEYS */;
/*!40000 ALTER TABLE `segmento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semana`
--

DROP TABLE IF EXISTS `semana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semana` (
  `id_semana` int NOT NULL AUTO_INCREMENT,
  `nome_dia` varchar(45) NOT NULL,
  `hora_inicial` time NOT NULL DEFAULT '00:00:00',
  `hora_final` time NOT NULL DEFAULT '00:00:00',
  `agenda_semana_id` int NOT NULL,
  PRIMARY KEY (`id_semana`),
  KEY `agenda_semana_id_idx` (`agenda_semana_id`),
  CONSTRAINT `agenda_semana_id` FOREIGN KEY (`agenda_semana_id`) REFERENCES `agenda` (`id_agenda`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semana`
--

LOCK TABLES `semana` WRITE;
/*!40000 ALTER TABLE `semana` DISABLE KEYS */;
INSERT INTO `semana` VALUES (3,'Segunda','07:00:00','08:00:00',2);
/*!40000 ALTER TABLE `semana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_agendamento`
--

DROP TABLE IF EXISTS `status_agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status_agendamento` (
  `id_status_agendamento` int NOT NULL AUTO_INCREMENT,
  `descricao_status_agendamento` varchar(100) NOT NULL,
  PRIMARY KEY (`id_status_agendamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_agendamento`
--

LOCK TABLES `status_agendamento` WRITE;
/*!40000 ALTER TABLE `status_agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `status_agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `email_usuario` varchar(100) NOT NULL,
  `senha_usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_usuario_UNIQUE` (`email_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin@admin.com','$2a$10$Q0lQAqnjcKus7LpxI.MoUO5ek6kiF1oTdRAtAJPSQgWRPd8pdzZvG'),(3,'aluno@gmail.com','aluno'),(4,'lucasteste@gmail.com','123456'),(5,'mariahnegerente@gmail.com','159357'),(6,'teste@gmail.com','123369'),(7,'teste2@gmail.com','$2a$10$IdYjS8ft8wZKJS/y690DdezTKHIfUllDKBuYSNYaq7LRJrYhON336'),(8,'novo@gmail.com','$2a$10$QeZb8viUrycOLvjT.1iDE.mUTMfKx4wdsBChof3idjjCiUzcYFXSu'),(10,'a@a.com','$2a$10$7uU9WP/sM3.VRjzBdBbcieoKbagEoM5I959OR2Rql7HKF4xn0lexK'),(11,'gustateste@gmail.com','$2a$10$TBgYonIX83q9Fw4YzoEYOenJlknYgx4cnXvrYFbU8kDyV4Y0bgLAy'),(13,'testando@gamil.com','$2a$10$9vVg4pEfEEFpybtdc/MvdeJrFXFCSRyZ8U5kaJAnYzsU3d7wR0kli'),(14,'exemplo03@gmail.com','$2a$10$uUsUBxVGCWjuXgj6JjYea.BoLpAg0lKfriW98MkdXgzIUhezC6NoS'),(15,'novousuario@novo.com','$2a$10$3LpXVW1HlQoTXNmjK0yovuXPVyM.EFUpYPpkfyOckJcRsbXDtwLpu'),(16,'testandonovo@fluxo.com','$2a$10$mVsyZ/Qg//7jS6Q/FQz60uoLWhbLEJmMhMSJTumeGB4gLcRi/Z8Cq'),(17,'maisumteste@gmail.com','$2a$10$w8sDAg8kMJbt4dw/1nwXqewCUak1I6PxrlbVvCuWLfrOtML7MxTp.'),(18,'testeprint@gmail.com','$2a$10$bZMmOeTFDDiDqbBOudKQQ.uMHAUWfcx8ZEkOHpE2sl9lzneQP6p2a'),(19,'vamove@gmail.com','$2a$10$1fp3kJINkLSN8rpn9F5W4eUwKGw8DBy94wR/8kzMtnLzyX5DBfNLS');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_permissao`
--

DROP TABLE IF EXISTS `usuario_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_permissao` (
  `usuario_id_usuario` int NOT NULL,
  `permissao_id_permissao` int NOT NULL,
  KEY `usuario_id_usuario_idx` (`usuario_id_usuario`),
  KEY `permissao_id_permissao_idx` (`permissao_id_permissao`),
  CONSTRAINT `permissao_id_permissao` FOREIGN KEY (`permissao_id_permissao`) REFERENCES `permissao` (`id_permissao`),
  CONSTRAINT `usuario_id_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_permissao`
--

LOCK TABLES `usuario_permissao` WRITE;
/*!40000 ALTER TABLE `usuario_permissao` DISABLE KEYS */;
INSERT INTO `usuario_permissao` VALUES (1,3),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(10,4),(11,4),(13,4),(14,4),(15,4),(16,4),(17,4),(18,4),(19,4);
/*!40000 ALTER TABLE `usuario_permissao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-08 15:32:00
