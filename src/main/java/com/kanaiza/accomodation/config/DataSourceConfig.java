package com.kanaiza.accomodation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by kanaiza on 11/3/16.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return localDataSource();
    }

    private DataSource localDataSource() {
        String username = "root";
        String password = "tool";
        String dbUrl = "jdbc:mysql://localhost:3306/home";
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        return factoryBean;
    }


}
