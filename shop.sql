DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `title` text NOT NULL,
                            `price` int NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `products` WRITE;

INSERT INTO `products` VALUES (1,'Product_1',10),
                              (2,'Product_2',20),
                              (3,'Product_3',30),
                              (4,'Product_4',40),
                              (5,'Product_5',50),
                              (6,'Product_6',60),
                              (7,'Product_7',70),
                              (8,'Product_8',80),
                              (9,'Product_9',90),
                              (10,'Product_10',100),
                              (11,'Product_11',110),
                              (12,'Product_12',120),
                              (13,'Product_13',130),
                              (14,'Product_14',140),
                              (15,'Product_15',150),
                              (16,'Product_16',160),
                              (17,'Product_17',170),
                              (18,'Product_18',180),
                              (19,'Product_19',190),
                              (20,'Product_20',200);

UNLOCK TABLES;
