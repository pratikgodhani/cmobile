package com.cognizant.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.cognizant.repository")
@PropertySource("database.properties")
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Autowired
	Environment env;
	@Bean  
    public DataSource dataSource() {  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();  
  
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));  
        dataSource.setUrl(env.getRequiredProperty("db.url"));  
        dataSource.setUsername(env.getRequiredProperty("db.username"));  
        dataSource.setPassword(env.getRequiredProperty("db.password"));  
  
        return dataSource;  
    }  
  
    @Bean  
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {  
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();  
        entityManagerFactoryBean.setDataSource(dataSource());  
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);  
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("entitymanager.packages.to.scan"));  
          
        entityManagerFactoryBean.setJpaProperties(hibProperties());  
          
        return entityManagerFactoryBean;  
    }  
  
    private Properties hibProperties() {  
        Properties properties = new Properties();  
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));  
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));  
        return properties;  
    }  
  
    @Bean  
    public JpaTransactionManager transactionManager() {  
        JpaTransactionManager transactionManager = new JpaTransactionManager();  
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());  
        return transactionManager;  
    }  
}
