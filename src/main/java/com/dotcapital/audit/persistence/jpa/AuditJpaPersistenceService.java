package com.dotcapital.audit.persistence.jpa;

import com.dotcapital.audit.domain.model.Audit;
import com.dotcapital.audit.persistence.AuditPersistenceFacade;
import com.dotcapital.audit.persistence.jpa.entity.AuditJpaEntity;
import com.dotcapital.audit.persistence.jpa.mapper.AuditJpaDaoMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuditJpaPersistenceService implements AuditPersistenceFacade {

    private final AuditJpaRepository repository;
    private final AuditJpaDaoMapper mapper;

    public AuditJpaPersistenceService(AuditJpaRepository repository, AuditJpaDaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Audit save(Audit audit) {
        final AuditJpaEntity auditJpaEntity = this.repository.save(this.mapper.modelToJpaEntity(audit));
        return this.mapper.jpaEntityToModel(auditJpaEntity);
    }

    @Override
    public List<Audit> findAll() {
        return this.repository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(this.mapper::jpaEntityToModel)
                .collect(Collectors.toList());
    }




}
