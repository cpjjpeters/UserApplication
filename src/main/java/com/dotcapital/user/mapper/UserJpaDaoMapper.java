package com.dotcapital.user.mapper;
import com.dotcapital.user.entities.UserJpaEntity;
import com.dotcapital.user.model.User;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

/**
 * @author tersc
 */
@Qualifier("CityJpaDaoMapper")
@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserJpaDaoMapper {
    UserJpaEntity modelToJpaEntity(com.dotcapital.user.model.User user);
    com.dotcapital.user.model.User jpaEntityToModel(UserJpaEntity userJpaEntity);

}
