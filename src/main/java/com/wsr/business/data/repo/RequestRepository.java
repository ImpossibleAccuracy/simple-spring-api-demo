package com.wsr.business.data.repo;

import com.wsr.business.data.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByVisitors_Id(Long id);
}