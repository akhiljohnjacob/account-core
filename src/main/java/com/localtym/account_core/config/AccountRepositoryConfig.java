package com.localtym.account_core.config;

import java.util.Objects;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.localtym.account_core.repository" }, entityManagerFactoryRef = "accountEntityManager", transactionManagerRef = "accountTransactionManager")
public class AccountRepositoryConfig {

    @Autowired
    private Environment env;

    @Bean(name = "accountDataSource")
    public DataSource getAccountDataSource() {

        HikariDataSource datasource = new HikariDataSource();
        datasource.setDriverClassName(env.getProperty("spring.datasource.account.driverClassName"));
        datasource.setJdbcUrl(env.getProperty("spring.datasource.account.url"));
        datasource.setUsername(env.getProperty("spring.datasource.account.username"));
        datasource.setPassword(env.getProperty("spring.datasource.account.password"));

        datasource.setConnectionInitSql(
                Objects.requireNonNull(env.getProperty("spring.datasource.hikari.connectionInitSql")));
        datasource.setMaximumPoolSize(
                Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.hikari.maximumPoolSize"))));
        datasource.setConnectionTimeout(Integer
                .parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.hikari.connectionTimeout"))));

        datasource.setIdleTimeout(
                Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.hikari.idleTimeout"))));
        datasource.setMinimumIdle(
                Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.hikari.minimumIdle"))));
        datasource.setKeepaliveTime(
                Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.hikari.keepaliveTime"))));
        datasource.setMaxLifetime(
                Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.hikari.maxLifetime"))));
        datasource.setInitializationFailTimeout(Integer.parseInt(
                Objects.requireNonNull(env.getProperty("spring.datasource.hikari.initializationFailTimeout"))));
        datasource.setPoolName(Objects.requireNonNull(env.getProperty("spring.datasource.hikari.poolName")));
        return datasource;
    }

    @Bean(name = "accountEntityManager")
    public LocalContainerEntityManagerFactoryBean getAccountEntityManager(EntityManagerFactoryBuilder builder,
            @Qualifier(value = "accountDataSource") DataSource accountDataSource) {

        HashMap<String, Object> properties = new HashMap<>();
      //  properties.put("spring.jpa.hibernate.dialect", env.getProperty("spring.jpa.hibernate.dalect"));
        properties.put("spring.jpa.hibernate.naming.physical-strategy",
                env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));

        return builder.dataSource(accountDataSource).packages("com.localtym.account_core.dto")
                .persistenceUnit("account").properties(properties).build();
    }

    @Bean(name = "accountTransactionManager")
    public JpaTransactionManager getAccountTransactionManager(
            @Qualifier(value = "accountEntityManager") LocalContainerEntityManagerFactoryBean getAccountEntityManager) {

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(getAccountEntityManager.getNativeEntityManagerFactory());

        return jpaTransactionManager;
    }

}
