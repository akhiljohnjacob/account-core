package com.localtym.account_core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.localtym.account_core.repository", entityManagerFactoryRef = "", transactionManagerRef = "")
public class AccountRepositoryConfig {

    @Autowired
    private Environment env;

    @Bean(name = "accountDataSource")
    public DataSource searchDataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.account.driverClassName"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.account.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.account.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.account.password"));
        
        

        return null;
    }

}
