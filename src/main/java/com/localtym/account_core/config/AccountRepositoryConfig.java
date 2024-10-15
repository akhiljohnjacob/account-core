package com.localtym.account_core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.localtym.account_core.repository"}, entityManagerFactoryRef = "", transactionManagerRef = "")
public class AccountRepositoryConfig {

    @Autowired
    private Environment env;


    @Bean(name = "accountsDataSource")
    public DataSource getDataSource(){

        HikariDataSource datasource = new HikariDataSource();
        datasource.setDriverClassName(null);
        datasource.setJdbcUrl(null);
        datasource.setUsername(null);
        datasource.setPassword(null);

        return null;
    }



}
