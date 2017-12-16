package com.lzk.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class HibernateTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){
        sessionFactory = null;
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSessionCache(){
        News news = (News) session.get(News.class,1);
        System.out.println(news);
        News news2 = (News) session.get(News.class,1);
        System.out.println(news2);
    }

    /**
     * flush:使数据表中的记录和Session缓存中的对象的状态保持一致，则可能会发送对应的SQL语句
     * 1、在Transaction的commit()方法中：先调用session的flush方法，在提交事务
     * 2、flush()方法可能会发送SQL语句，但不会提交事务
     * 3、注意：在未提交事务或显示的调用session.flush()方法之前，也有可能会进行flush()操作
     *1）在执行HQL或 QBC查询，会先进行flush()操作，以得到数据表的最新记录
     *2）若记录的ID是由底层数据库使用自增的方式生成的，则在调用save()方法后，就会立即发送INSERT语句
     * 因为save方法后，必须保证对象的ID存在
     * *
     */
    @Test
    public void testSessionFlush(){
        News news = (News) session.get(News.class,1);
        news.setAuthor("aaa");

        //News news1 = (News) session.createCriteria(News.class).uniqueResult();
        //System.out.println(news1);
    }
    @Test
    public void testSessionFlush2(){
        News news = new News("JAVA","SUM",new java.sql.Date(new Date().getTime()));
        session.save(news);
    }

    //reflush():会强制发送SELECT 语句，以使Session缓存中的对象的状态和数据库对应的记录保持一致
    @Test
    public void testReflush(){
        News news = (News) session.get(News.class,1);
        System.out.println(news);
        session.refresh(news);
        System.out.println(news);
    }
    //clear()：清理缓存
    @Test
    public void testClear(){
        News news = (News) session.get(News.class,1);
        session.clear();
        News news1 = (News) session.get(News.class,1);
    }

    //持久化对象的状态：临时对象，持久化状态，删除状态，游离状态
    //Session的特定方法能是对象从一个状态变为另一个状态

    /**
     * save()方法
     * 1、使一个临时对象变为持久化对象
     * 2、为对象分配ID
     * 3、在flush缓存时会发送一条INSERT语句
     * 4、在save方法之前分配ID无效
     * 5、持久化对象的ID无法修改
     *
     */
    @Test
    public void testSave(){
        News news = new News("Java","Orcle",new java.sql.Date(new Date().getTime()));
        news.setId(110);
        System.out.println(news);
        session.save(news);
        System.out.println(news);
        news.setId(101);
    }

    /**
     * persist()方法也会执行INSERT操作
     *
     * 和save()方法区别
     * 在调用persist方法之前，若对象已有ID，则不会执行INSERT语句，而抛出异常
     *
     */
    @Test
    public void testPersist(){
        News news = new News("Java","Orcle",new java.sql.Date(new Date().getTime()));
        news.setId(110);
        System.out.println(news);
        session.persist(news);
        System.out.println(news);
    }

    /**
     * get VS load
     *
     * 1、执行get方法：会立即加载对象，立即检索
     *    执行load方法：若不使用该对象，则不会立即执行查询操作，而是返回一个代理对象，延迟检索
     * 2、load加载可能会抛出LazyInitializationException异常：
     * 在需要初始化代理对象之前已经关闭了Session
     *3、若数据表中没有对应的记录,且Session也没有关闭，同时需要使用对象时
     *    get返回null
     *    load 若不使用该对象的任何属性，没问题；若需要初始化，抛异常
     *
     */
    @Test
    public void testGet(){
        News news = (News) session.get(News.class,1);
        System.out.println(news);
    }

    @Test
    public void testLoad(){
        News news = (News) session.load(News.class,1);
        System.out.println(news);
    }

    /**
     *
     * update:
     * 1.若更新一个持久化对象，不需要显示调用update方法。
     * 因为在调用Transaction的commit()的方法时，会先执行Session的flush方法
     * 2.更新一个游离对象使，需要显示调用update方法。可以把一个游离对象变为持久化对象
     *
     * 需要注意
     * 1.无论要更新的游离对象和数据表是否一致，都会发送UPDATE语句
     *      如何让update方法不在盲目的触发UPDATE语句呢？在.hbm.xml文件的节点设置
     *      select-before-update="true"(默认为false)。但通常不需要设置该属性
     *      除非设置了update相关的触发器
     * 2.若数据表中没有对应的记录，但还调用了update方法，会抛异常
     * 3.当update方法关联一个游离对象时，
     * 若果在Session的缓存在已经存在相同的OID的持久化对象，会抛异常
     * 因为在Session缓存中不能有两个OID相同的对象
     */
    @Test
    public void testUpdate(){
        News news = (News) session.get(News.class,1);
        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        news.setAuthor("Orcle");
        //2news.setId(200);
        //3News news2 = (News) session.get(News.class,1);
        session.update(news);
    }

    /**
     *
     * 同时包含save和update的方法的功能
     * 判断OID是否为null来执行save或update
     * 1、若OID为null执行save
     * 2、若OID不为null执行update
     * 注意：
     * 1、若OID不为null，但数据表中还没有和其对应的记录，会抛异常
     * 2、OID等于id的unsave-value属性值得时候，也被认为是一个游离对象
     */
    @Test
    public void testSaveOrUpdate(){
        //News news = new News("BB","bb",new java.sql.Date(new Date().getTime()));
        News news = new News("BB","bb",new java.sql.Date(new Date().getTime()));
        news.setId(1);
        session.saveOrUpdate(news);
    }

    /**
     * delete方法可以删除游离对象，也可以删除持久化对象
     * 只要OID和数据表中一条记录对应，就会准备delete操作
     * 若OID在数据表中没有对应的记录，则抛出异常
     *
     * 可以通过设置hibernate配置文件<property name="use_identifier_rollback">true</property>
     * 使其删除对象后，把其OID置为null
     */
    @Test
    public void testDelete(){
        /*//删除游离对象
        News news = new News();
        news.setId(1);*/

        /*//删除持久化对象*/
        News news = (News) session.get(News.class,4);
        session.delete(news);
        System.out.println(news);
    }

    /**
     * evict：从sesion缓存中把特定的持久化对象移除
     *
     */
    @Test
    public void testEvict(){
        News news1 = (News) session.get(News.class,2);
        News news2 = (News) session.get(News.class,3);
        news1.setAuthor("AA");
        news2.setAuthor("BB");
        session.evict(news2);
    }

    @Test
    public void testDoWork(){
        session.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                System.out.println(connection);
                //com.mchange.v2.c3p0.impl.NewProxyConnection@149f5761 [wrapping: com.mysql.jdbc.JDBC4Connection@4210c4c]
            }
        });
    }

    @Test
    public void testDynamicUpdate(){
        News news = (News) session.get(News.class,2);
        news.setTitle("AA");
    }

    @Test
    public void testWorker(){
        Worker worker = new Worker();
        worker.setName("aa");
        Pay pay = new Pay();
        pay.setMonthlyPay(1000);
        pay.setYearPay(10000);
        pay.setVocationWithPay(500);
        worker.setPay(pay);
        session.save(worker);
    }
}
