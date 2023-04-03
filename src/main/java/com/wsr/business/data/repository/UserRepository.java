package com.wsr.business.data.repository;

import com.wsr.business.data.models.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository extends Repository {
    public List<User> findAll() {
        return this.findAll(User.class);
    }

    public User findById(long id) {
        return this.findById(id, User.class);
    }

    public User findByName(String name) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> root = criteria.from(User.class);
        criteria.where(builder.equal(builder.lower(root.get("name")), name.toLowerCase()));

        return session.createQuery(criteria).getSingleResultOrNull();
    }
}
