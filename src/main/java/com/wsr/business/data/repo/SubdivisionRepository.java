package com.wsr.business.data.repo;

import com.wsr.business.data.models.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
    Subdivision findByTitle(String title);
}