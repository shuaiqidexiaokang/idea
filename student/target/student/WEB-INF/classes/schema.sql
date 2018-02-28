drop database if EXISTS student;
create database student;
use student;
CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `age` int(11) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

insert into tb_student(name,age)
VALUES ('张三',20),
  ('李四',22),
  ('王五',23),
  ('赵六',24),
  ('张三',25),
  ('张三',27),
  ('张三',28),
  ('张三',20),
  ('张三',22),
  ('张三',23),
  ('张三',24),
  ('张三',25),
  ('张三',27),
  ('张三',28);