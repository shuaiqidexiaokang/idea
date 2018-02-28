drop database if exists blog;
create database blog;
use blog;

create table user(
  user_id int auto_increment comment '用户编号',
  username varchar(40) comment '用户名',
  password varchar(40) comment '密码',
  primary key(user_id)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='用户表';

insert into user(username,password)
values('admin','admin');

create table article(
  article_id int not null auto_increment comment '文章编号',
  title varchar(40) not null comment '标题',
  type_id int not null comment '类型编号',
  keyword varchar(20) not null comment '关键字',
  summary text not null comment '概要',
  context text not null comment '内容',
  read_number int not null comment '阅读数',
  create_time timestamp not null comment '创建时间',
  primary key(article_id),
  key idx_type_id(type_id),
  key idx_read_number(read_number),
  key idx_create_time(create_time)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='博客文章表';

insert into
  article(title,type_id,keyword,summary,context,read_number,create_time)
values
  ('使用C#开发信息管理系统',1,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',200,now()),
  ('电子购物商城系统(C%23实现)',1,'商城系统',': cr330326 举报的资源分',': 取  消 提  交 电子购物商城系统(C%23实',150,now()),
  ('零基础学Java系列从入门到精通 ',2,'Java开发','程涵盖内容包括Java开发环境','学员可在最短时间内掌握Java',120,now()),
  ('使用C系列从管理系统',2,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',452,now()),
  ('使用C#开发系列从管理系统',2,'C#开发信系列从息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',150,now()),
  ('使用C#开发信息管理系统',2,'C#开发信系列从息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',211564,now()),
  ('使用系列从C#开发信息系列从管理系统',2,'C#开发信系列从息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',5023,now()),
  ('使用C#开发信息管理系统',4,'C#开发信系列从息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',7845,now()),
  ('使用C#开发信息管理系统',5,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',456,now()),
  ('使用C#开发信息管理系统',5,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',785151,now()),
  ('使用从C#开发信息管理系统',7,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',123,now()),
  ('使用C#开发信息管理系统',7,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',120,now()),
  ('使用C#开发信息管理系统',8,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',320,now()),
  ('使用C#开发信息管理系统',8,'C#开发信息管理','ADO.NET技术','能够帮助C#学员顺利掌握企业项目开发的核心技能。',875,now());
create table type(
  type_id int not null auto_increment comment '类别编号',
  type_name varchar(10) not null comment'类别名',
  number int not null comment '数量',
  primary key(type_id)
)engine=InnoDB auto_increment=1 default charset=utf8 comment='类别表';
insert into type(type_name,number)
values
  ('c#',2),
  ('java',5),
  ('javaee',0),
  ('linux',0),
  ('随笔',2),
  ('前端',0),
  ('ajax',2),
  ('maven',2),
  ('mysql',0),
  ('设计模式',0);

create table comment(
  comment_id int not null auto_increment comment '评论编号',
  article_id int not null comment '文章编号',
  name varchar(10) not null comment '评论者姓名',
  email varchar(40) not null comment '评论者邮箱',
  context text not null comment '内容',
  creat_time timestamp not null comment '创建时间',
  thumbs_number int not null comment '点赞数',
  toes_number int not null comment '狂踩数',
  primary key(comment_id),
  key idx_creat_time(creat_time),
  key idx_thumbs_number(thumbs_number)
)engine=InnoDB auto_increment=1 default charset=utf8 comment='评论表';

