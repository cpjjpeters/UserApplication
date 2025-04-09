package com.dotcapital.audit.persistence.jpa;

import com.dotcapital.audit.persistence.jpa.entity.AuditJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;


public interface AuditJpaRepository extends JpaRepository<AuditJpaEntity, Long> {


}
