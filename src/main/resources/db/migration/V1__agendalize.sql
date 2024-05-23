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
  `agendamento_id` int NOT NULL,
  `data_disponivel_inicial` date NOT NULL,
  `data_disponivel_final` date NOT NULL,
  `nome_agenda` varchar(45) NOT NULL,
  `descricao_agenda` text,
  PRIMARY KEY (`id_agenda`),
  KEY `agendamento_agenda_id_idx` (`agendamento_id`),
  KEY `empresa_agenda_id_idx` (`empresa_agenda_id`),
  CONSTRAINT `agendamento_id` FOREIGN KEY (`agendamento_id`) REFERENCES `agendamento` (`id_agendamento`),
  CONSTRAINT `empresa_agenda_id` FOREIGN KEY (`empresa_agenda_id`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
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
  PRIMARY KEY (`id_agendamento`),
  KEY `status_agendamento_id_idx` (`staus_agendamento_id`),
  KEY `cliente_cpf_id_idx` (`cliente_cpf_id`),
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES ('15975365425','burger king','admin@admin.com',NULL,1,'21912345678','jardim america','12345678',1),('79579879578','gusfestas','gustafestas@contatos.com',NULL,11,'21967540521','Rua ierê 273 vicente de carvalho','21370530',2);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','<< Flyway Baseline >>','BASELINE','<< Flyway Baseline >>',NULL,'root','2024-04-16 20:09:41',0,1),(2,'2','agendalize','SQL','V2__agendalize.sql',-717402143,'root','2024-04-20 22:16:19',3555,1),(3,'3','agendalize','SQL','V3__agendalize.sql',1021812080,'root','2024-05-14 17:02:58',2977,1),(4,'4','agendalize','SQL','V4__agendalize.sql',411674160,'root','2024-05-15 21:35:24',642,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin@admin.com','$2a$10$Q0lQAqnjcKus7LpxI.MoUO5ek6kiF1oTdRAtAJPSQgWRPd8pdzZvG'),(3,'aluno@gmail.com','aluno'),(4,'lucasteste@gmail.com','123456'),(5,'mariahnegerente@gmail.com','159357'),(6,'teste@gmail.com','123369'),(7,'teste2@gmail.com','$2a$10$IdYjS8ft8wZKJS/y690DdezTKHIfUllDKBuYSNYaq7LRJrYhON336'),(8,'novo@gmail.com','$2a$10$QeZb8viUrycOLvjT.1iDE.mUTMfKx4wdsBChof3idjjCiUzcYFXSu'),(10,'a@a.com','$2a$10$7uU9WP/sM3.VRjzBdBbcieoKbagEoM5I959OR2Rql7HKF4xn0lexK'),(11,'gustateste@gmail.com','$2a$10$TBgYonIX83q9Fw4YzoEYOenJlknYgx4cnXvrYFbU8kDyV4Y0bgLAy');
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
INSERT INTO `usuario_permissao` VALUES (1,3),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(10,4),(11,4);
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

-- Dump completed on 2024-05-22 21:16:09
