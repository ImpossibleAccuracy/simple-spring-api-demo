package com.wsr.business.config.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public Session session() {
        SessionFactory factory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

//        factory.close();

        return session;
    }
}
