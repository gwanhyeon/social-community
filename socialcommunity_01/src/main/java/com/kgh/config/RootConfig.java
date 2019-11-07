package com.kgh.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.kgh.cook")

//Mapper Java설정
//@MapperScan(basePackages= {"com.kgh.mapper"})
	

public class RootConfig {
	// config에서는 bean을 사용한다
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory= new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();

	}

	private DataSource dataSource() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	// hikariConfig Java설정 
//	@Bean
//	public DataSource dataSource() {
//		HikariConfig hikariConfig = new HikariConfig();
//	hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	hikariConfig.setJdbcUrl("jdbc:oracle:thin@localhost:59161:XE");
//	hikariConfig.setUsername("book_ex");
//	hikariConfig.setPassword("book_ex");

	/*log4jdbc 사용할때 씀  
	hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
	hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost59161:XE");
	*/
//		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//		
//		return dataSource();
//	}
//	

}
