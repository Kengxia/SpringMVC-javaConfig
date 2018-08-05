package com.my.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 9:45 2018/7/19
 * @Description:
 */

@Configuration
@ComponentScan(basePackages = "com.my.work")
@EnableTransactionManagement
@MapperScan(basePackages = "com.my.work.mapper")
public class MyBatisConfig implements TransactionManagementConfigurer {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceConfig.getDriver());
        dataSource.setUsername(dataSourceConfig.getUsername());
        dataSource.setPassword(dataSourceConfig.getPassword());
        dataSource.setUrl(dataSourceConfig.getUrl());
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSessionFactory(DruidDataSource ds) throws IOException {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setConfigLocation(new ClassPathResource("configuration.xml"));
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        factory.setDataSource(ds);
        return factory;
    }
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DruidDataSource ds){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(ds);
        return manager;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return getTransactionManager(getDruidDataSource());
    }

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader.getResource("").getPath());


    }
}