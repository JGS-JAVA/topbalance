package com.topBalance.wishTree.config;



import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration // 설정클래스로 동작
@PropertySource("classpath:/config.properties") // config.properties 파일 읽어와 설정에 사용
public class DBConfig {


    @Autowired // 스프링컨테이너에서 타입에 맞는 Bean을 필드에 주입(의존성 주입, Dependency Injection)
    private ApplicationContext applicationContext; // 현재 프로젝트

    @Bean // 수동으로 생성한 객체(Bean)를 스프링컨테이너에 등록
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    // config.properties 파일에서 spring.datasource.hikari로 시작하는 값을 읽어와 HikariConfig에 자동세팅
    public HikariConfig hikariConfig() {

        return new HikariConfig();
    }


    @Bean
    public DataSource dataSource(HikariConfig config) {

        DataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception{

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();


        sessionFactoryBean.setDataSource(dataSource);

        sessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:/mappers/**.xml")  );

        sessionFactoryBean.setTypeAliasesPackage("c");

        sessionFactoryBean.setConfigLocation(
                applicationContext.getResource("classpath:mybatis-config.xml"));

        // 설정 내용이 모두 적용된 객체 반환
        return sessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }


    @Bean
    public DataSourceTransactionManager
    dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}