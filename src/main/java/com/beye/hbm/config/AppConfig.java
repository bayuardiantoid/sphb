package com.beye.hbm.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by MamaMia on 1/16/2017.
 */

@Configuration
@ComponentScan(basePackages = {"com.beye.hbm.**"})
@PropertySource({ "classpath:hibernate.properties" })
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource mysqlDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
    }



    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(mysqlDataSource());
        sessionFactoryBean.setPackagesToScan(new String[] { "com.beye.hbm" });
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }


    @Bean
    public SessionFactory sessionFactory() {
        return localSessionFactoryBean().getObject();
    }


    @Bean
    public HibernateTransactionManager transactionManager()
    {
        HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory());
        return txManager;
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }

    /*@Bean
    @Autowired
    public ViewResolver viewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

    @Bean
    public ContentNegotiationManager contentNegotiationManager() {
        return contentNegotiationManagerFactoryBean().getObject();
    }

    @Bean
    public ContentNegotiationManagerFactoryBean contentNegotiationManagerFactoryBean() {
        ContentNegotiationManagerFactoryBean bean = new ContentNegotiationManagerFactoryBean();
        bean.setFavorPathExtension(true);
        bean.setIgnoreAcceptHeader(true);
        bean.setDefaultContentType(MediaType.APPLICATION_JSON);
        bean.setUseJaf(false);

        Properties mediaTypes = new Properties();
        mediaTypes.setProperty("json", "application/json");
        mediaTypes.setProperty("xml", "application/xml");
        bean.setMediaTypes(mediaTypes);

        return bean;
    }*/
}
