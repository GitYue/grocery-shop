package com.own.grocery.config.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseDbConfig {

    public SqlSessionFactory instanceSqlSessionFactory(DataSource dataSource,String modulName) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        String mapperXmlPath = "classpath*:mapping/"+ modulName +"/*/*Mapper.xml";
        List<Resource> resourceList = new ArrayList<>();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Collections.addAll(resourceList, resolver.getResources(mapperXmlPath));
        Resource[] resources = resourceList.toArray(new Resource[0]);

        factoryBean.setMapperLocations(resources);
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
