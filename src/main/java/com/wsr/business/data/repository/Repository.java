package com.wsr.business.data.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Repository {
    @Autowired
    protected Session session;

    public <T> List<T> findAll(Class<T> tClass) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(tClass);
        criteria.from(tClass);

        return session.createQuery(criteria).getResultList();
    }

    public <T> T findById(long id, Class<T> tClass) {
        return session.get(tClass, id);
    }
}
