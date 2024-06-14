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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (1,1,'2024-05-28','2024-10-31','DJ Agendamentos','Testando Agenda'),(2,1,'2024-05-15','2024-05-18','Lucas','absduy'),(4,5,'2024-05-11','2024-05-31','ttest consulkta','testando consulta'),(5,15,'2024-05-31','2024-07-31','espetinhos','teste espetinhos'),(6,16,'2024-06-30','2024-08-31','teste','teste'),(8,17,'2024-06-29','2024-08-29','adsadsa','adsadsa'),(10,20,'2024-06-13','2024-12-31','Limpeza dentária','Serviço de limpeza dos dentes'),(12,21,'2024-06-13','2024-10-18','teste f 1 CRUD agenda 100%','teste f  CRUD agenda 100%'),(13,22,'2024-06-20','2024-11-30','teste agenda','testt'),(14,24,'2024-06-14','2024-12-31','Procedimentos clínicos','limpeza e obturações simples'),(15,24,'2024-06-14','2024-12-31','Extrações','Extrações'),(16,24,'2024-06-14','2024-12-31','Pequenas cirurgias','extração de siso e etc.');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `id_agendamento` int NOT NULL AUTO_INCREMENT,
  `status_agendamento_id` int NOT NULL,
  `data_agendamento` date NOT NULL,
  `hora_inicio_agendamento` time DEFAULT NULL,
  `hora_final_agendamento` time DEFAULT NULL,
  `agenda_agendamento_id` int NOT NULL,
  `cliente_id` int NOT NULL,
  PRIMARY KEY (`id_agendamento`),
  KEY `status_agendamento_id_idx` (`status_agendamento_id`),
  KEY `agenda_agendamento_id_idx` (`agenda_agendamento_id`),
  KEY `cliente_id_idx` (`cliente_id`),
  CONSTRAINT `agenda_agendamento_id` FOREIGN KEY (`agenda_agendamento_id`) REFERENCES `agenda` (`id_agenda`),
  CONSTRAINT `cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `status_agendamento_id` FOREIGN KEY (`status_agendamento_id`) REFERENCES `status_agendamento` (`id_status_agendamento`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
INSERT INTO `agendamento` VALUES (1,1,'2024-06-29','07:00:00','09:00:00',1,2),(2,1,'2024-06-13','07:00:00','08:00:00',1,2),(3,1,'2024-06-28','07:00:00','09:00:00',1,3),(4,2,'2024-06-19','08:00:00','09:00:00',12,4),(5,2,'2024-06-24','09:00:00','10:00:00',13,6),(6,1,'2024-06-20','10:00:00','11:00:00',14,9),(7,1,'2024-06-14','14:00:00','15:00:00',15,9),(8,1,'2024-07-24','15:00:00','16:00:00',16,9),(9,2,'2024-06-14','15:00:00','16:00:00',14,11),(10,1,'2024-06-17','16:00:00','17:00:00',15,11),(11,1,'2024-08-22','12:30:00','13:30:00',16,12),(12,1,'2024-06-22','14:00:00','15:00:00',14,12),(13,1,'2024-09-26','15:00:00','16:00:00',16,12);
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cpf_cliente` varchar(14) NOT NULL,
  `nome_cliente` varchar(45) NOT NULL,
  `sobrenome_cliente` varchar(100) NOT NULL,
  `email_contato_cliente` varchar(100) NOT NULL,
  `endereco_cliente` varchar(100) NOT NULL,
  `cep_cliente` varchar(8) NOT NULL,
  `telefone_cliente` varchar(11) NOT NULL,
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `empresa_cliente_id` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf_cliente`),
  UNIQUE KEY `email_contato_cliente_UNIQUE` (`email_contato_cliente`),
  KEY `empresa_cliente_id_idx` (`empresa_cliente_id`),
  CONSTRAINT `empresa_cliente_id` FOREIGN KEY (`empresa_cliente_id`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('15236254125','Lucas','Luiz da Silva','lucas.oficial2727@gmail.com','Rua Dique, 102','21240800','977269505',2,1),('25425632587','teste','da silva','t@t.com','bfwibfw','15847862','21564536983',3,1),('1516','teste f 1 alt','cliente','t1@t1.com','rua teste f1','12315','516',4,21),('1518425632','Lucas','Luiz da ','lucas.oficial227@gmail.com','Rua Dique, 102','21240800','977269505',6,22),('197.024.337-62','tetst','adsa','l@l.com','afsfd','165156','11516',7,22),('368.519.420-89','Reginaldo','Pereira','reginaldo@gmail.com','Rua do relógio Nº37','21563542','21965487456',9,24),('816.271.280-18','Carla','Gomes','carla@gmail.com','Rua 10 Nº10','21532648','21548865632',11,24),('356.040.930-68','Felipe','Figueiredo','felipe@gmail.com','Rua bracamps Nº05','21523651','21545784563',12,24);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_indisponivel`
--

LOCK TABLES `data_indisponivel` WRITE;
/*!40000 ALTER TABLE `data_indisponivel` DISABLE KEYS */;
INSERT INTO `data_indisponivel` VALUES (3,'2024-06-19','feriado',1),(7,'2024-06-14','feriado',10),(9,'2024-06-15','feriado 2',12),(10,'2024-06-17','recesso',12),(11,'2024-06-21','feriao',13),(12,'2024-09-07','feriado',14),(13,'2024-12-25','feriado',14),(14,'2024-12-31','feriado',14),(15,'2024-09-07','feriado',15),(16,'2024-12-25','feriado',15),(17,'2024-12-31','feriado',15);
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES ('15975365425','teste alterar','admin@admin.com',NULL,1,'21912345678','jardim america','12345678',1),('79579879578','gusfestas','gustafestas@contatos.com',NULL,11,'21967540521','Rua ierê 273 vicente de carvalho','21370530',2),('13648573165','Testando','testando@contato.com',NULL,7,'14523654781','teste rua 103','25865475',3),('75867567','Isas espaco','isabela@gmaill.com',NULL,13,'21912345678','jardim america','12345678',5),('1234567891054','Isas espaco','aluno@gmail.com',NULL,14,'21912345678','jardim america','12345678',8),('25647856312451','Novidades Usuais','contatoNoviades@contato.com',NULL,15,'21258478632','Rua da novidade 32, Bairro novo','32560800',14),('25485421523214','Espertinhos','contato@contato.com',NULL,16,'21584552365','espetinho 32','21548769',15),('12365696325415','mais um teste','teste@contato.com',NULL,17,'21258741236','test tetst','23654125',16),('12536245698735','asdasda','asdsa@adsa.com',NULL,19,'21563254786','Rua sdbaydbisad','23152428',17),('12345678945216','agendinha','teste@tes.com',NULL,20,'21254256356','Rua teste','15935746',18),('15756325463246','Lexicorp','b@b.com',NULL,22,'21254563256','rua lexi','25632145',19),('15632546978546','Equilab','c@c.com',NULL,23,'21256365232','Rua taçtes','12345689',20),('123516','test f 1','a@A.com',NULL,24,'152541','rua teste f 1','213',21),('15412356215565','interprise','ts@ts.com',NULL,25,'21365425848','rua teste','21352142',22),('154263','teste cnpj','test@hdua.com',NULL,27,'15851','akndo','151',23),('55060135000134','Odonto Clean','odontoclean@contato.com',NULL,28,'21948526351','Rua dos pinheiros Nº19','21245862',24);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (3,'admin'),(4,'empresa'),(5,'cliente');
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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semana`
--

LOCK TABLES `semana` WRITE;
/*!40000 ALTER TABLE `semana` DISABLE KEYS */;
INSERT INTO `semana` VALUES (3,'Segunda','07:00:00','08:00:00',2),(5,'Segunda','07:00:00','19:30:00',1),(9,'Terça','07:00:00','19:00:00',1),(10,'Quinta','07:00:00','14:09:00',1),(11,'Sexta','08:00:00','22:00:00',1),(12,'Segunda','07:30:00','19:00:00',10),(13,'Terça','07:00:00','19:00:00',10),(19,'Segunda','07:00:00','09:00:00',12),(20,'Terça','07:00:00','09:00:00',12),(21,'Quarta','07:00:00','10:00:00',12),(22,'Segunda','09:00:00','10:00:00',13),(23,'Segunda','09:00:00','17:00:00',14),(24,'Terça','09:00:00','17:00:00',14),(25,'Quarta','09:00:00','17:00:00',14),(26,'Quinta','09:00:00','17:00:00',14),(27,'Sexta','09:00:00','17:00:00',14),(28,'Sábado','09:00:00','14:00:00',14),(29,'Segunda','09:00:00','17:00:00',15),(30,'Terça','09:00:00','17:00:00',15),(31,'Quarta','09:00:00','17:00:00',15),(32,'Quinta','09:00:00','17:00:00',15),(33,'Sexta','09:00:00','17:00:00',15),(34,'Segunda','09:00:00','17:00:00',16),(35,'Terça','09:00:00','17:00:00',16),(36,'Quarta','09:00:00','17:00:00',16),(37,'Quinta','09:00:00','17:00:00',16),(38,'Sexta','09:00:00','17:00:00',16);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_agendamento`
--

LOCK TABLES `status_agendamento` WRITE;
/*!40000 ALTER TABLE `status_agendamento` DISABLE KEYS */;
INSERT INTO `status_agendamento` VALUES (1,'Em andamento'),(2,'Concluído'),(3,'Cancelado');
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin@admin.com','$2a$10$Q0lQAqnjcKus7LpxI.MoUO5ek6kiF1oTdRAtAJPSQgWRPd8pdzZvG'),(3,'aluno@gmail.com','aluno'),(4,'lucasteste@gmail.com','123456'),(5,'mariahnegerente@gmail.com','159357'),(6,'teste@gmail.com','123369'),(7,'teste2@gmail.com','$2a$10$IdYjS8ft8wZKJS/y690DdezTKHIfUllDKBuYSNYaq7LRJrYhON336'),(8,'novo@gmail.com','$2a$10$QeZb8viUrycOLvjT.1iDE.mUTMfKx4wdsBChof3idjjCiUzcYFXSu'),(10,'a@a.com','$2a$10$7uU9WP/sM3.VRjzBdBbcieoKbagEoM5I959OR2Rql7HKF4xn0lexK'),(11,'gustateste@gmail.com','$2a$10$TBgYonIX83q9Fw4YzoEYOenJlknYgx4cnXvrYFbU8kDyV4Y0bgLAy'),(13,'testando@gamil.com','$2a$10$9vVg4pEfEEFpybtdc/MvdeJrFXFCSRyZ8U5kaJAnYzsU3d7wR0kli'),(14,'exemplo03@gmail.com','$2a$10$uUsUBxVGCWjuXgj6JjYea.BoLpAg0lKfriW98MkdXgzIUhezC6NoS'),(15,'novousuario@novo.com','$2a$10$3LpXVW1HlQoTXNmjK0yovuXPVyM.EFUpYPpkfyOckJcRsbXDtwLpu'),(16,'testandonovo@fluxo.com','$2a$10$mVsyZ/Qg//7jS6Q/FQz60uoLWhbLEJmMhMSJTumeGB4gLcRi/Z8Cq'),(17,'maisumteste@gmail.com','$2a$10$w8sDAg8kMJbt4dw/1nwXqewCUak1I6PxrlbVvCuWLfrOtML7MxTp.'),(18,'testeprint@gmail.com','$2a$10$bZMmOeTFDDiDqbBOudKQQ.uMHAUWfcx8ZEkOHpE2sl9lzneQP6p2a'),(19,'vamove@gmail.com','$2a$10$1fp3kJINkLSN8rpn9F5W4eUwKGw8DBy94wR/8kzMtnLzyX5DBfNLS'),(20,'agenda@gmail.com','$2a$10$8AjPkA/Kc2Yn6Qs3yFzkfeDoArcSuYNuwRJzuEAf3pf5fXx9tT6m6'),(22,'b@b.com','$2a$10$jQjJRPO38ZUIg5w0qXQj/O6JoHBd6Rhez.RqDQt.MKygHYnZpOcqq'),(23,'c@c.com','$2a$10$9QmO85dsZSom38LE9sGKnulk8pn/UYDZ1ULDa4ZAPBe0NyN1wk8g2'),(24,'testef1@gmail.com','$2a$10$1wEkZf6vPab0ywPWYMw58OS0iSy1V55FBTJ3i4P7lDRf3y5CJvnry'),(25,'final@final.com','$2a$10$Tp87slqBPMpFHJsSIOif6e4K9m55EAe16xuDI8P/rqYc0uSaQeoMq'),(27,'testecnpj@p.com','$2a$10$Y1AazM1nwB50XrY4Glbaku6QlnEgMY1T5RNAhelCqu7MG20PqPMCK'),(28,'odontoclean@odonto.com','$2a$10$pFdfJkVkq4sJlLrcLYFAzuZNKd0tGtCIrkh/ccBnR2m1rvg93KX5y'),(29,'p@p.com','$2a$10$lwe3Q9R25UTZUzaAaMSafOMCWKDLvpqavJLqgcYxczeJRfuN8LI3i');
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
INSERT INTO `usuario_permissao` VALUES (1,3),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(10,4),(11,4),(13,4),(14,4),(15,4),(16,4),(17,4),(18,4),(19,4),(20,4),(22,4),(23,4),(24,4),(25,4),(27,4),(28,4),(29,4);
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

-- Dump completed on 2024-06-14 14:46:48
