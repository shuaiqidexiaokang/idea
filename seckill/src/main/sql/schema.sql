-- 数据库初始化脚本
-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
-- 创建秒杀数据库
CREATE TABLE seckill
(
	seckill_id  bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
	name VARCHAR(120) NOT NULL COMMENT '商品名称',
	number int NOT NULL COMMENT '库存数量',
	start_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT'秒杀开启时间',
	end_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (seckill_id),
	KEY idx_create_time(create_time),
	KEY idx_start_time(start_time),
	KEY idx_end_time(end_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 初始化数据
INSERT INTO
	seckill(name,number,start_time,end_time)
VALUES
	('1000元秒杀iphone6',100,'2017-02-03 00:00:00','2017-02-04 00:00:00'),
	('500元秒杀ipad2',200,'2017-02-03 00:00:00','2017-02-04 00:00:00'),
	('300元秒杀小米4',300,'2017-02-03 00:00:00','2017-02-04 00:00:00'),
	('200元秒杀红米note',400,'2017-02-03 00:00:00','2017-02-04 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE success_killed(
	`seckill_id` bigint NOT NULL COMMENT '秒杀商品id',
	`user_phone` bigint NOT NULL COMMENT '用户手机号',
	`state` tinyint NOT NULL DEFAULT -1 COMMENT '状态标示:-1:无效 0:成功 1:已付款 2:已发货',
	`create_time` timestamp NOT NULL COMMENT '创建时间',
	PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
	KEY idx_create_time(create_time)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- 连接数据库控制台
-- mysql -uroot -p123

-- 为什么手写DDL
-- 纪录每次上线的DDL修改
-- 上线V1.1
ALTER TABLE seckill
	DROP INDEX idx_create_time,
	ADD INDEX idx_c_s(start_time,create_time);

-- 上线V1.2
-- ddl

-- <=
-- <![CDATA[ <= ]]>
DELIMITER $$
--
-- 存储过程
--
CREATE PROCEDURE `executeSeckill`(IN fadeSeckillId INT,IN fadeUserPhone VARCHAR (15),IN fadeKillTime TIMESTAMP ,OUT fadeResult INT)
	BEGIN
		DECLARE insertCount INT DEFAULT 0;
		START TRANSACTION ;
		INSERT IGNORE success_killed(seckill_id,user_phone,state,create_time) VALUES(fadeSeckillId,fadeUserPhone,0,fadeKillTime);
		SELECT ROW_COUNT() INTO insertCount;
		IF(insertCount = 0) THEN
			ROLLBACK ;
			SET fadeResult = -1;
		ELSEIF(insertCount < 0) THEN
			ROLLBACK ;
			SET fadeResult = -2;
		ELSE
			UPDATE seckill SET number = number -1 WHERE seckill_id = fadeSeckillId AND start_time < fadeKillTime AND end_time > fadeKillTime AND number > 0;
			SELECT ROW_COUNT() INTO insertCount;
			IF (insertCount = 0)  THEN
				ROLLBACK ;
				SET fadeResult = 0;
			ELSEIF (insertCount < 0) THEN
				ROLLBACK ;
				SET fadeResult = -2;
			ELSE
				COMMIT ;
				SET  fadeResult = 1;
			END IF;
		END IF;
	END$$

DELIMITER ;

set @fadeResult = -3;
call executeSeckill(1003,11111111111,now(),@fadeResult);
select @fadeResult;
