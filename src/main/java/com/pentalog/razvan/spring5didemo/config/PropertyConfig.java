package com.pentalog.razvan.spring5didemo.config;

import com.pentalog.razvan.spring5didemo.examplebeans.FakeDataSource;
import com.pentalog.razvan.spring5didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${penta.username}")
    String user;
    @Value("${penta.password}")
    String password;
    @Value("${penta.dburl}")
    String url;


    @Value("${penta.jms.username}")
    String jmsUsername;
    @Value("${penta.jms.password}")
    String jmsPassword;
    @Value("${penta.jms.dburl}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(this.user);
        System.out.println(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(this.password);
        fakeDataSource.setUrl(this.url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUsername(this.jmsUsername);
        fakeJmsBroker.setPassword(this.jmsPassword);
        fakeJmsBroker.setUrl(this.jmsUrl);
        return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
