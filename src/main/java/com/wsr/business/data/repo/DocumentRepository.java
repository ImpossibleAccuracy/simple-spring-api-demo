package com.wsr.business.data.repo;

import com.wsr.business.data.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}