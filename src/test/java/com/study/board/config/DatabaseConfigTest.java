package com.study.board.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DatabaseConfigTest {

    //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DatabaseConfig.class);
    @Autowired
    private ApplicationContext ac;
    @Autowired
    private SqlSessionFactory sessionFactory;

    @Test
    void contextLoads(){

    }

//    @Test
//    public void testByApplicationContext(){
//        //SqlSessionFactory sqlFactoryBean = ac.getBean(SqlSessionFactory.class);
//        Object sqlSessionFactory = ac.getBean("sqlSessionFactory");
//        assertThat(sqlSessionFactory).isNotNull();
//    }

    @Test
    public void testByApplicationContext() {
//        try {
//            System.out.println("=========================");
//            System.out.println(ac.getBean("sqlSessionFactory"));
//            System.out.println("=========================");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //assertThat(ac.getBean(SqlSessionFactory.class)).isNotNull();
    }

    @Test
    void testBySqlSessionFactory(){
//        System.out.println("=========================");
//        System.out.println(sessionFactory.toString());
//        System.out.println("=========================");
        //assertThat(sessionFactory.toString()).isNotNull();
    }

}