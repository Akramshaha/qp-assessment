create database qp_assessment;

use qp_assessment;

INSERT INTO `users`(email, full_name, password) VALUES
('akram.user@gmail.com','Akram Shaha','$2y$10$j/doq/bCNxy5IfCk86J67e3okM4t77DxzKOZfUD4QGdjt7OdPNeHm'), 
('akram.admin@gmail.com','Admin','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu');

-- Email				Password
-- akram.user@gmail 	Akram
-- akram.admin@gmail 	admin

INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
INSERT INTO `users_roles` VALUES (2,1),(1,2);