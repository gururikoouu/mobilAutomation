# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.17)
# Database: mobileAutomation
# Generation Time: 2017-08-28 17:07:16 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table locators
# ------------------------------------------------------------

DROP TABLE IF EXISTS `locators`;

CREATE TABLE `locators` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `locator` text,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `locators` WRITE;
/*!40000 ALTER TABLE `locators` DISABLE KEYS */;

INSERT INTO `locators` (`id`, `name`, `locator`, `created_on`, `updated_on`)
VALUES
	(680,'home.del','//android.widget.Button[@text=\'del\']','2017-08-28 15:04:06','2017-08-28 15:04:17'),
	(681,'home.plus','//android.widget.Button[@text=\'+\']','2017-08-28 15:04:06','2017-08-28 15:04:42'),
	(682,'home.equal','//android.widget.Button[@text=\'=\']','2017-08-28 15:04:06','2017-08-28 15:20:08'),
	(683,'home.editText','android.widget.EditText','2017-08-28 15:04:06','2017-08-28 15:18:42'),
	(684,'home.buttonTxt','//android.widget.Button[@text=\'locTxt\']','2017-08-28 15:04:06','2017-08-28 15:20:18');

/*!40000 ALTER TABLE `locators` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
