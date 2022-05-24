# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.31)
# Database: logisticsadaptor
# Generation Time: 2022-03-11 09:50:38 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bucket
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bucket`;

CREATE TABLE `bucket` (
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `bucket` WRITE;
/*!40000 ALTER TABLE `bucket` DISABLE KEYS */;

INSERT INTO `bucket` (`name`, `value`)
VALUES
	('search','Available for delivery');

/*!40000 ALTER TABLE `bucket` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


# Dump of table rateCard
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rateCard`;

CREATE TABLE  rateCard
(
    id        VARCHAR(255) NOT NULL,
    basePrice DOUBLE       NULL,
    CONSTRAINT pk_ratecard PRIMARY KEY (id)
    );


INSERT INTO `rateCard` (`id`, `basePrice`)
VALUES
    ('1', 23.00),
    ('2', 24.00),
    ('3', 25.00),
    ('4', 26.00)
    ;

/*!40000 ALTER TABLE `bucket` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table merchant
# ------------------------------------------------------------

DROP TABLE IF EXISTS `merchant`;

CREATE TABLE  merchant
(
    id           VARCHAR(255) NOT NULL,
    merchantCode VARCHAR(255) NULL,
    authHeader   VARCHAR(255) NULL,
    rateCardId   VARCHAR(255) NULL,
    CONSTRAINT pk_merchant PRIMARY KEY (id)
    );

ALTER TABLE merchant
    ADD CONSTRAINT FK_MERCHANT_ON_RATECARDID FOREIGN KEY (rateCardId) REFERENCES rateCard (id);


INSERT INTO `merchant` (`id`, `merchantCode` ,`authHeader`, `rateCardId`)
VALUES
    ('https://mock_bap.com/', 'JYN', 'TEST', '1'),
    ('test_id', 'test', 'TEST', '2')
    ;