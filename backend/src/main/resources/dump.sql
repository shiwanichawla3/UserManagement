-- Dumping database structure for usermanagement
CREATE DATABASE IF NOT EXISTS `usermanagement`;
USE `usermanagement`;
-- Dumping structure for table usermanagement.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
-- Dumping structure for table usermanagement.students
CREATE TABLE IF NOT EXISTS `students` (
  `student_id` int(5) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
-- Dumping structure for table usermanagement.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `course_id` int(5) NOT NULL AUTO_INCREMENT,
  `subject` varchar(200) NOT NULL,
  `marks` int(5) NOT NULL,  
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
-- Dumping structure for table usermanagement.student_course
CREATE TABLE IF NOT EXISTS `student_course` (
  `student_id` int(5) NOT NULL,
  `course_id` int(5) NOT NULL, 
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`course_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
-- Dumping data for table usermanagementuser: ~2 rows (approximately)
INSERT INTO `users` (`username`) VALUES
	('Shiwani Chawla'),
	('Shivani Chawla'),
	('Shivani'); 
	
INSERT INTO `courses` VALUES 
	(1,'BCA',25),
	(2,'BBA',66),
	(3,'MTECH',99),
	(4,'BTECH',22),
	(5,'BCOM',11),
	(6,'MCOM',32),
	(7,'MBA',76),
	(8,'MCA',34);

INSERT INTO `students` VALUES 
	(1,'shivanichawla3@gmail.com','shivani', '1234');
