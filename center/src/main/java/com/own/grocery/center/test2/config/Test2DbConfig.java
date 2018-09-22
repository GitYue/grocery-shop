package com.own.grocery.center.test2.config;

import org.springframework.context.annotation.Configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@MapperScan(basePackages = {"com.own.grocery.center.test2.repository"},sqlSessionFactoryRef = "test2SqlSessionFactory")
public class Test2DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "datasource.test2")
    public DataSource test2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSourceTransactionManager test2TransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        String mapperXmlPath = "classpath*:mapping/test2/*/*Mapper.xml";
        List<Resource> resourceList = new ArrayList<>();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Collections.addAll(resourceList, resolver.getResources(mapperXmlPath));
        Resource[] resources = resourceList.toArray(new Resource[0]);

        factoryBean.setMapperLocations(resources);
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
