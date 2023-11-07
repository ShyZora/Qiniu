-- MySQL dump 10.13  Distrib 5.7.44, for Linux (x86_64)
--
-- Host: localhost    Database: qiniu
-- ------------------------------------------------------
-- Server version	5.7.44

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
-- Current Database: `qiniu`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `qiniu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `qiniu`;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` tinyint(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'游戏'),(2,'体育'),(3,'时尚'),(4,'音乐'),(5,'娱乐'),(6,'二次元'),(7,'知识'),(8,'美食');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `video_id` bigint(20) unsigned NOT NULL COMMENT '视频ID',
  `comment_text` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,2,1,'你好啊，视频不错','2023-11-05 11:30:35'),(2,2,1,'视频还行','2023-11-04 11:31:28'),(3,2,1,'继续加油','2023-11-02 11:31:45'),(4,2,1,'JABXLYDee0','2013-09-25 16:34:57'),(5,2,1,'38X35sP6OZ','2000-07-18 13:06:57'),(6,2,1,'keunj2ShHM','2009-09-24 00:16:55'),(7,2,2,'ADlmLIVs9q','2010-08-29 16:43:09'),(8,2,2,'biKECd2e9c','2007-07-05 17:03:56'),(9,2,2,'t096aX1hfi','2006-03-28 00:53:42'),(10,2,2,'raEZnnAtm4','2021-01-07 06:27:31'),(11,2,2,'rSBGxJlBpa','2022-09-09 14:42:53'),(12,2,2,'LwWa1Nyej7','2003-01-05 04:33:00'),(13,2,2,'HDC6ua5eew','2014-11-22 09:48:40'),(14,2,3,'2vr2PAyYBj','2019-11-16 01:34:36'),(15,2,3,'xOOW06ZWsi','2003-11-01 06:14:05'),(16,2,3,'kJxOF4jB9d','2013-07-16 23:45:27'),(17,2,3,'CcqvNByckn','2014-03-07 12:38:28'),(18,2,3,'pejkx782mb','2018-04-09 08:27:10'),(19,2,3,'3EMuAR7Mh5','2008-01-09 18:58:42'),(20,2,4,'54TRNOK87Q','2009-02-23 13:59:29'),(21,2,4,'tWpEecFean','2013-06-02 00:06:46'),(22,2,4,'Oq1iZQpRnS','2016-03-13 10:15:06'),(23,2,4,'I4Egb9wUCb','2014-11-18 17:51:28'),(24,2,4,'Moq1gfw0ZA','2014-02-24 11:23:54'),(25,2,4,'xjXTlUulYw','2012-05-04 11:16:36'),(26,2,5,'LTOIAC5eMZ','2015-09-20 07:26:04'),(27,2,5,'bv0ZCVrYmJ','2008-09-12 04:14:14'),(28,2,5,'r255qknfSg','2015-12-09 23:33:53'),(29,2,5,'ujQWUoRqHt','2020-07-22 10:20:28'),(30,2,5,'cS3FQETlyv','2002-02-10 09:46:42'),(31,2,5,'9hZxKH4Z4H','2006-10-06 18:37:35'),(32,2,6,'xSDCWtusFu','2019-08-15 03:33:47'),(33,2,6,'7nSXXei7u8','2005-10-18 08:27:00'),(34,2,6,'XOHCsgsKtT','2009-07-26 19:18:39'),(35,2,6,'4PzdocKAJT','2016-12-20 07:09:56'),(36,2,6,'V4OnqBbjKt','2005-03-15 03:00:22'),(37,2,6,'SELE0RzESH','2018-06-12 15:53:33'),(38,2,7,'XccbM1lJf1','2006-11-04 14:16:15'),(39,2,7,'DBjDCcHuj3','2012-05-13 20:56:25'),(40,2,7,'1Fim9lA481','2021-04-26 13:01:52'),(41,2,7,'nvCVTXJQZE','2008-04-21 12:53:23'),(42,2,7,'G250hussra','2020-11-06 02:30:59'),(43,2,7,'iNDeg9jjEW','2009-12-19 00:34:07'),(44,2,1,'hWAtUMuv3R','2001-07-18 05:20:05'),(45,2,2,'CJhjP74RY2','2010-11-30 08:48:57'),(46,2,3,'Qa7cXF40s8','2004-09-28 22:10:00'),(47,2,4,'JcbkFzJgT6','2020-11-25 21:43:37'),(48,2,5,'tJn0kWdbsE','2022-06-06 10:01:46'),(49,2,6,'XeGHvtTvHe','2016-09-23 00:52:59'),(50,2,7,'fG5rmbRTXD','2005-06-26 21:19:10'),(51,2,1,'1GZyueXCXf','2022-10-03 15:44:51'),(52,2,2,'KdAxXJaLRn','2001-12-10 21:24:30'),(53,2,3,'UynmZhARTF','2006-07-11 08:36:05');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_dislike`
--

DROP TABLE IF EXISTS `comment_dislike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_dislike` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '不喜欢id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `comment_id` bigint(20) unsigned NOT NULL COMMENT '评论id',
  `dislike_num` smallint(6) unsigned NOT NULL DEFAULT '0' COMMENT '不喜欢数量',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_dislike`
--

LOCK TABLES `comment_dislike` WRITE;
/*!40000 ALTER TABLE `comment_dislike` DISABLE KEYS */;
INSERT INTO `comment_dislike` VALUES (1,2,1,721,'2021-09-12 20:20:56'),(2,2,2,740,'2018-11-18 17:21:17'),(3,2,3,228,'2017-07-17 16:20:46'),(4,2,4,412,'2012-01-22 22:23:23'),(5,2,5,75,'2015-09-02 00:19:06'),(6,2,6,932,'2004-02-16 23:24:34'),(7,2,7,263,'2001-08-17 08:03:49');
/*!40000 ALTER TABLE `comment_dislike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_like`
--

DROP TABLE IF EXISTS `comment_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_like` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `comment_id` bigint(20) unsigned NOT NULL COMMENT '评论id',
  `like_num` smallint(6) unsigned NOT NULL DEFAULT '0' COMMENT '点赞数量',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_like`
--

LOCK TABLES `comment_like` WRITE;
/*!40000 ALTER TABLE `comment_like` DISABLE KEYS */;
INSERT INTO `comment_like` VALUES (1,2,1,3,'2007-03-12 06:05:38'),(2,2,2,812,'2009-06-23 20:15:23'),(3,2,3,94,'2012-11-21 11:51:58'),(4,2,4,828,'2014-10-20 15:28:55'),(5,2,5,40,'2003-05-02 14:23:45'),(6,2,6,548,'2006-08-12 15:56:06'),(7,2,7,105,'2005-10-30 17:18:55');
/*!40000 ALTER TABLE `comment_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_reply`
--

DROP TABLE IF EXISTS `comment_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_reply` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '回复id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `comment_id` bigint(20) unsigned NOT NULL COMMENT '评论id',
  `reply_text` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '回复内容',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_reply`
--

LOCK TABLES `comment_reply` WRITE;
/*!40000 ALTER TABLE `comment_reply` DISABLE KEYS */;
INSERT INTO `comment_reply` VALUES (1,2,1,'G51yPwCtZj','2004-10-20 12:44:20'),(2,2,2,'F5VKnftTkV','2005-11-19 09:08:50'),(3,2,3,'btyuUXjy4N','2016-11-26 09:01:34'),(4,2,4,'sRM5JhB59s','2008-06-14 13:05:33'),(5,2,5,'D2pIHZLMxB','2010-02-12 09:15:50'),(6,2,6,'bUQaeMeKWh','2013-04-29 10:44:46'),(7,2,7,'ll9xjm1ntT','2019-06-25 18:47:12'),(8,2,1,'vxcM8yeyqB','2004-02-01 10:38:20'),(9,2,2,'YYdoF15YVC','2011-09-16 08:05:45'),(10,2,3,'f3aDYz1MFi','2004-12-16 03:10:01'),(11,2,4,'HYGWicCc72','2009-10-14 20:57:08'),(12,2,5,'4rzVLaYSK9','2006-08-31 07:20:32'),(13,2,6,'CwjntfRiHh','2001-02-18 12:27:11'),(14,2,7,'dgMbpljbkK','2020-11-10 04:35:28'),(15,2,1,'fMMCC7YJfq','2003-09-02 08:19:14'),(16,2,1,'BKs6Wa0QPM','2012-10-12 14:30:40'),(17,2,1,'TYJBPlxhPk','2017-12-29 00:44:24'),(18,2,1,'6PjtWGTc9g','2006-05-09 17:50:05'),(19,2,1,'zAwclSfJ8D','2014-01-02 14:04:36'),(20,2,2,'m27WHoorIR','2012-05-14 22:05:37');
/*!40000 ALTER TABLE `comment_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favourite`
--

DROP TABLE IF EXISTS `favourite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favourite` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `video_id` bigint(20) NOT NULL COMMENT '视频id',
  `title` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `video_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '视频地址',
  `cover_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '封面图片地址',
  `create_time` datetime NOT NULL COMMENT '上传时间',
  `update_time` datetime NOT NULL COMMENT '更改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite`
--

LOCK TABLES `favourite` WRITE;
/*!40000 ALTER TABLE `favourite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favourite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good_video`
--

DROP TABLE IF EXISTS `good_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good_video` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '喜欢id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `video_id` bigint(20) NOT NULL COMMENT '视频id',
  `title` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `video_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '视频地址',
  `cover_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '封面图片地址',
  `create_time` datetime NOT NULL COMMENT '上传时间',
  `update_time` datetime NOT NULL COMMENT '更改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good_video`
--

LOCK TABLES `good_video` WRITE;
/*!40000 ALTER TABLE `good_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `good_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like`
--

DROP TABLE IF EXISTS `like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `like` (
  `id` bigint(20) NOT NULL COMMENT '喜欢id',
  `video_id` bigint(20) NOT NULL COMMENT '视频id',
  `title` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `video_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '视频地址',
  `cover_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '封面图片地址',
  `create_time` datetime NOT NULL COMMENT '上传时间',
  `update_time` datetime NOT NULL COMMENT '更改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like`
--

LOCK TABLES `like` WRITE;
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
/*!40000 ALTER TABLE `like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色权限表主键id',
  `menu_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '角色权限名称',
  `menu_key` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '角色权限关键字',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `menu_name` (`menu_name`) USING BTREE,
  UNIQUE KEY `menu_key` (`menu_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'用户登录','action::login'),(2,'用户登出','action::logout'),(3,'用户注册','action::register'),(4,'访问测试页面','action::visited.test');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '角色关键字',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `role_key` (`role_key`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'管理员','sys::admin'),(2,'普通用户','sys::user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '角色权限id',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色及角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES (1,4),(2,1),(2,2),(2,3);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nick_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hello','$2a$10$aCrpUCOsmCqJHuWGzhwG/uHvVurU/RZDKCsLA13INcE5WG5yM0.fO'),(2,'user','$2a$10$pSySiEoLkmfSb25wBt/pKeXEZEewLjW5sdr.6hW7DvswxnlEXHOHW'),(13,'1234','$2a$10$ilhfxB9qRigp.F6IjCoyvOg3U0UaXmGwzGaD2dFjWR2iU6R8OcjvG'),(14,'12345','$2a$10$nspZ/X3O2vbl82eI0uBOT.wbhUn6KckhYcvafU44j8ufRw8QS4vf.'),(15,'12345','$2a$10$Q1knvL9e7O6YFrXwq653YeTz0/y5OkHZNdBoD5BvzlBiFCkJS5mtG');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(1,2),(2,2),(11,2),(12,2),(13,2),(14,2),(15,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '视频ID',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `title` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '视频标题',
  `category_id` tinyint(4) unsigned NOT NULL COMMENT '分类ID',
  `video_url` varchar(150) COLLATE utf8_bin NOT NULL COMMENT '视频地址',
  `cover_url` varchar(150) COLLATE utf8_bin NOT NULL COMMENT '封面 图片地址',
  `like_num` bigint(6) NOT NULL DEFAULT '0' COMMENT '点赞数量',
  `favourite_num` bigint(6) NOT NULL DEFAULT '0' COMMENT '收藏数量',
  `share_num` bigint(6) NOT NULL DEFAULT '0' COMMENT '分享数量',
  `create_time` datetime NOT NULL COMMENT '上传时间',
  `update_time` datetime NOT NULL COMMENT '更改时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `category_id` (`category_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,2,'我可真机智呀',8,'http://s32tuvjv2.hn-bkt.clouddn.com/video/我可真机智呀.mp4','暂无',10,0,0,'2023-11-05 11:21:04','2023-11-05 11:21:08'),(2,2,'【阿蛋在哪】更新啦，赶紧来围观吧！',8,'http://s32tuvjv2.hn-bkt.clouddn.com/video/【阿蛋在哪】更新啦，赶紧来围观吧！.mp4','暂无',0,0,0,'2023-11-05 11:24:33','2023-11-05 11:24:35'),(3,2,'人间真实',8,'http://s32tuvjv2.hn-bkt.clouddn.com/video/人间真实.mp4','暂无',3,90,10,'2023-11-05 11:25:27','2023-11-05 11:25:31'),(4,2,'吃饭极速版',8,'http://s32tuvjv2.hn-bkt.clouddn.com/video/吃饭极速版.mp4','暂无',0,0,0,'2023-11-05 11:26:18','2023-11-05 11:26:21'),(5,2,'学校水龙头',5,'http://s32tuvjv2.hn-bkt.clouddn.com/video/学校水龙头.mp4','暂无',0,0,0,'2023-11-05 11:27:09','2023-11-05 11:27:12'),(6,2,'救助小松鼠',5,'\r\nhttp://s32tuvjv2.hn-bkt.clouddn.com/video/救助小松鼠.mp4','暂无',0,0,0,'2023-11-05 11:27:52','2023-11-05 11:27:55'),(7,2,'没想到冬天来得这么快，外面突然就飘雪花了',5,'http://s32tuvjv2.hn-bkt.clouddn.com/video/没想到冬天来得这么快，外面突然就飘雪花了.mp4','暂无',0,0,0,'2023-11-05 11:29:07','2023-11-05 11:29:12');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_operation`
--

DROP TABLE IF EXISTS `video_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video_operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `video_id` bigint(20) NOT NULL,
  `operation_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_operation`
--

LOCK TABLES `video_operation` WRITE;
/*!40000 ALTER TABLE `video_operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `video_operation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-07 12:50:36
