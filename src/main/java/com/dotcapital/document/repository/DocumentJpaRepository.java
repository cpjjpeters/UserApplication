package com.dotcapital.document.repository;

import com.dotcapital.document.entities.DocumentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentJpaRepository extends JpaRepository<DocumentJpaEntity, Long> {
}
