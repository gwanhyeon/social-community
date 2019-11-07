package com.kgh.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// 자바 설정 사용하는 경우
//@ContextConfiguration(classes= {RootConfig.class})

@Log4j
public class DataSourceTests {
	// root-context.xml에 추가한 <bean id 값으로AutoWired를 걸어서여기서 테스트를 한
	@Setter(onMethod_ = {@Autowired })
	private DataSource dataSource;
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory SqlSessionFactory;
	
	@Test
	public void testMyBatis() {
		try (SqlSession session = SqlSessionFactory.openSession();
			Connection con = session.getConnection();){
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			log.info(con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
