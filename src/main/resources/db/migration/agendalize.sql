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
  `empresa_cnpj_id` varchar(14) NOT NULL,
  `agendamento_id` int NOT NULL,
  `data_disponivel_inicial` date NOT NULL,
  `data_disponivel_final` date NOT NULL,
  `nome_agenda` varchar(45) NOT NULL,
  `descricao_agenda` text,
  PRIMARY KEY (`id_agenda`),
  KEY `empresa_cnpj_id_idx` (`empresa_cnpj_id`),
  KEY `agendamento_agenda_id_idx` (`agendamento_id`),
  CONSTRAINT `agendamento_id` FOREIGN KEY (`agendamento_id`) REFERENCES `agendamento` (`id_agendamento`),
  CONSTRAINT `empresa_cnpj_id` FOREIGN KEY (`empresa_cnpj_id`) REFERENCES `empresa` (`cnpj_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cpf_cliente` varchar(11) NOT NULL,
  `usuario_cliente_id` int NOT NULL,
  `nome_cleinte` varchar(45) NOT NULL,
  `sobrenome_cliente` varchar(100) NOT NULL,
  `email_contato_cliente` varchar(100) NOT NULL,
  `telefone_cliente_id` int NOT NULL,
  `endereco_cliente_id` int NOT NULL,
  PRIMARY KEY (`cpf_cliente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf_cliente`),
  UNIQUE KEY `email_contato_cliente_UNIQUE` (`email_contato_cliente`),
  KEY `usuario_id_idx` (`usuario_cliente_id`),
  KEY `telefone_cliente_id_idx` (`telefone_cliente_id`),
  KEY `endereco_cliente_id_idx` (`endereco_cliente_id`),
  CONSTRAINT `endereco_cliente_id` FOREIGN KEY (`endereco_cliente_id`) REFERENCES `endereco` (`id_endereco`),
  CONSTRAINT `telefone_cliente_id` FOREIGN KEY (`telefone_cliente_id`) REFERENCES `telefone` (`id_telefone`),
  CONSTRAINT `usuario_cliente_id` FOREIGN KEY (`usuario_cliente_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `endereco_empresa_id` int NOT NULL,
  `descricao_empresa` text,
  `usuario_empresa_id` int NOT NULL,
  `telefone_empresa_id` int NOT NULL,
  PRIMARY KEY (`cnpj_empresa`),
  UNIQUE KEY `cnpj_UNIQUE` (`cnpj_empresa`),
  UNIQUE KEY `email_contato_empresa_UNIQUE` (`email_contato_empresa`),
  KEY `usuario_empresa_id_idx` (`usuario_empresa_id`),
  KEY `telefone_empresa_id_idx` (`telefone_empresa_id`),
  KEY `endereco_empresa_id_idx` (`endereco_empresa_id`),
  CONSTRAINT `endereco_empresa_id` FOREIGN KEY (`endereco_empresa_id`) REFERENCES `endereco` (`id_endereco`),
  CONSTRAINT `telefone_empresa_id` FOREIGN KEY (`telefone_empresa_id`) REFERENCES `telefone` (`id_telefone`),
  CONSTRAINT `usuario_empresa_id` FOREIGN KEY (`usuario_empresa_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id_endereco` int NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `complemento` varchar(45) NOT NULL,
  `cep` varchar(8) NOT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissao` (
  `id_permissoes` int NOT NULL AUTO_INCREMENT,
  `descricao_permissao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_permissoes`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefone` (
  `id_telefone` int NOT NULL AUTO_INCREMENT,
  `opcao_1` varchar(11) NOT NULL,
  `opcao_2` varchar(11) DEFAULT NULL,
  `opcao_3` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_telefone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  CONSTRAINT `permissao_id_permissao` FOREIGN KEY (`permissao_id_permissao`) REFERENCES `permissao` (`id_permissoes`),
  CONSTRAINT `usuario_id_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-16 10:45:22
