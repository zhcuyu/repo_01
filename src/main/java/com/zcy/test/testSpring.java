package com.zcy.test;

import com.zcy.dao.IaccountDao;
import com.zcy.domain.User;
import com.zcy.service.IaccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testSpring {
    //run1   测试spring方法
    @Test
    public void run1(){
        //1.加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.容器中新建对象    获取对象  用接口来接受
        IaccountService as = (IaccountService) ac.getBean("accountService");
        //3.调用方法
        as.findAll();
//        as.saveAccount();
    }
    //2.测试mybaites  findAll方法
    @Test
    public void run2() throws IOException {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        IaccountDao dao = session.getMapper(IaccountDao.class);
        // 调用查询的方法
        List<User> list = dao.findAll();
        for (User account : list) {
            System.out.println(account);
        }
        // 释放资源
        session.close();
        inputStream.close();
    }
    //2.测试mybaites  保存方法
    @Test
    public void run3() throws IOException {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        IaccountDao dao = session.getMapper(IaccountDao.class);
        User user = new User();
        user.setName("朵肥胖");
        user.setMoney(1000d);
        dao.saveAccount(user);

        //提交事务！！！否则不保存
        session.commit();

        // 释放资源
        session.close();
        inputStream.close();
    }
}
