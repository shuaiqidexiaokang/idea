package com.lzk.service.impl;

import com.lzk.dto.Exposer;
import com.lzk.dto.SeckillExecution;
import com.lzk.entity.Seckill;
import com.lzk.exception.RepeatKillException;
import com.lzk.exception.SeckillCloseException;
import com.lzk.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills = seckillService.getSeckillList();
        logger.info("seckills={}",seckills);
        //18:59:16.786 [main] INFO  c.l.s.impl.SeckillServiceImplTest -
        // seckills=[Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Fri Feb 03 00:00:00 CST 2017, endTime=Sat Feb 04 00:00:00 CST 2017, createTime=Thu Dec 07 16:13:24 CST 2017},
        // Seckill{seckillId=1001, name='500元秒杀ipad2', number=200, startTime=Fri Feb 03 00:00:00 CST 2017, endTime=Sat Feb 04 00:00:00 CST 2017, createTime=Thu Dec 07 16:13:24 CST 2017}, Seckill{seckillId=1002, name='300元秒杀小米4', number=300, startTime=Fri Feb 03 00:00:00 CST 2017, endTime=Sat Feb 04 00:00:00 CST 2017, createTime=Thu Dec 07 16:13:24 CST 2017}, Seckill{seckillId=1003, name='200元秒杀红米note', number=400, startTime=Fri Feb 03 00:00:00 CST 2017, endTime=Sat Feb 04 00:00:00 CST 2017, createTime=Thu Dec 07 16:13:24 CST 2017}]

    }

    @Test
    public void getById() throws Exception {
        long id = 1001L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
        //19:00:20.464 [main] INFO  c.l.s.impl.SeckillServiceImplTest -
        // seckill=Seckill{seckillId=1001, name='500元秒杀ipad2', number=200, startTime=Fri Feb 03 00:00:00 CST 2017, endTime=Sat Feb 04 00:00:00 CST 2017, createTime=Thu Dec 07 16:13:24 CST 2017}

    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
        //19:10:25.855 [main] INFO  c.l.s.impl.SeckillServiceImplTest -
        // exposer=Exposer{秒杀状态=true,
        // md5加密值='84a869dab7d979926762134c848aafdb',
        // 秒杀ID=1000, 当前时间=0, 开始时间=0, 结束=0}

    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000L;
        long phone = 17777777777L;
        String md5 = "84a869dab7d979926762134c848aafdb";
        SeckillExecution seckillExecution = seckillService.executeSeckill(id,phone,md5);
        logger.info("seckillExecution={}",seckillExecution);
        //19:14:22.700 [main] INFO  c.l.s.impl.SeckillServiceImplTest -
        // seckillExecution=SeckillException{秒杀的商品ID=1, 秒杀状态=1,
        // 秒杀状态信息='秒杀成功', 秒杀的商品=SuccessKilled{seckillId=1000,
        // userPhone=17777777777, state=0, createTime=Mon Dec 18 19:14:22 CST 2017}}
    }

    //测试代码完整代码，注意可重复
    @Test
    public void testSeckillLogic(){
        long id = 1002L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 17777777773L;
            String md5 = exposer.getMd5();
            try{
                SeckillExecution seckillExecution = seckillService.executeSeckill(id,phone,md5);
                logger.info("seckillExecution={}",seckillExecution);
            }catch(RepeatKillException e){
                logger.error(e.getMessage());
            }catch(SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }else{
            //秒杀未开启
            logger.info("exposer={}",exposer);
        }
    }
}