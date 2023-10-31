package com.spring.boot.data.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan("com.spring.boot.data.dao")
public class MySQLConfig {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
			throws Exception {
			// SqlSessionFactoryBean: SqlSessionFactory를 생성해주는 클래스
			final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			// setDataSource(): datasource를 참조
			sessionFactory.setDataSource(dataSource);
			// PathMatchingResourcePatternResolver
			// resource 위치 검색을 돕는 Spring class
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
			sessionFactory.setTypeAliasesPackage("com.spring.boot.data.dto");
			return sessionFactory.getObject();
			}

}
