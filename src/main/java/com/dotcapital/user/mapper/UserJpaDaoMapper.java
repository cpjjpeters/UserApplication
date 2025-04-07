package com.dotcapital.user.mapper;
import com.dotcapital.user.entities.UserJpaEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author tersc
 */
@Qualifier("CityJpaDaoMapper")
@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserJpaDaoMapper {
    UserJpaEntity modelToJpaEntity(com.dotcapital.user.model.User user);
    com.dotcapital.user.model.User jpaEntityToModel(UserJpaEntity userJpaEntity);
}
