package com.dotcapital.document.mapper;


import com.dotcapital.document.entities.DocumentJpaEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

@Qualifier("DocumentJpaDaoMapper")
@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DocumentJpaDaoMapper {
    DocumentJpaEntity modelToJpaEntity(com.dotcapital.document.model.Document document);
    com.dotcapital.document.model.Document jpaEntityToModel(DocumentJpaEntity documentJpaEntity);
}
