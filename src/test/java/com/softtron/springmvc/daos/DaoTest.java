package com.softtron.springmvc.daos;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtron.springmvc.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml" })
public class DaoTest {
	
	@Autowired
	UserService UserService;
	@Autowired
	OrderDao orderDao;
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	
	public void test() {
		for (int i = 0; i < 500; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(orderDao.getOrders());
					SqlSession sqlSession = sqlSessionFactory.openSession();
					System.out.println(sqlSession.selectList("com.softtron.springmvc.daos.OrderDao.getOrders"));
					sqlSession.close();
				}
			});
			thread.start();
			
		}
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test2() {
		UserService.task();
	}
	
}
