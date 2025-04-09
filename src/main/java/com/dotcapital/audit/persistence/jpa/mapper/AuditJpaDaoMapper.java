package com.dotcapital.audit.persistence.jpa.mapper;

import com.dotcapital.audit.domain.model.Audit;
import com.dotcapital.audit.persistence.jpa.entity.AuditJpaEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuditJpaDaoMapper {

    AuditJpaEntity modelToJpaEntity(Audit audit);

    Audit jpaEntityToModel(AuditJpaEntity auditJpaEntity);
}
