package com.wsr.business.data.repo;

import com.wsr.business.data.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}