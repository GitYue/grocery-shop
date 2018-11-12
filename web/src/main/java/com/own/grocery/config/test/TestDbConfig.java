package com.own.grocery.config.test;

import com.own.grocery.config.common.BaseDbConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.own.grocery.center.test.repository"},sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestDbConfig extends BaseDbConfig{

    @Bean
    @ConfigurationProperties(prefix = "datasource.test")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource) throws Exception{
        return instanceSqlSessionFactory(dataSource,"test");
    }
}
