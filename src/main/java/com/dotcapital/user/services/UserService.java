package com.dotcapital.user.services;

import com.dotcapital.audit.domain.AuditService;
import com.dotcapital.audit.domain.model.Audit;
import com.dotcapital.audit.domain.model.AuditType;
import com.dotcapital.exception.BusinessException;
import com.dotcapital.exception.RecordNotFoundException;
import com.dotcapital.user.model.User;
import com.dotcapital.exception.ErrorSeverity;
import com.dotcapital.user.persistence.UserPersistenceFacade;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.user.services */
@Slf4j
@Service
public class UserService {
     private final UserPersistenceFacade userPersistenceFacade;
     private final AuditService auditService;

     public UserService(UserPersistenceFacade userPersistenceFacade, AuditService auditService) {
         this.userPersistenceFacade = userPersistenceFacade;
         this.auditService = auditService;
     }

     public User updateUser(User user) {
            log.debug("update user {}", user);

                return this.userPersistenceFacade.save(user);

     }

    public User save(User user, boolean isExistingUser) {
        log.debug("save user {}, {}", user, isExistingUser);

        if (StringUtils.isEmpty(user.getActorId())) {
            throw BusinessException.builder()
                    .title("ActorId is mandatory")
                    .returnCode("USER_ACTOR_ID_MANDATORY")
                    .subReturnCode("USER_ACTOR_ID_MANDATORY")
                    .severity(ErrorSeverity.E) // Ensure ErrorSeverity is properly imported or defined
                    .build();
        }

        if (isExistingUser) {
            // If the user already exists, update the status to ACTIVE
            return this.userPersistenceFacade.adapt(user);
        } else {
            try {
                User savedUser = this.userPersistenceFacade.save(user);
                auditService.createAudit(
                        Audit.builder()
                                .userId("SYSTEM")
                                .auditType(AuditType.SYSTEM_TYPE)
                                .moduleActivity("UserService")
                                .logText("User " + user.getUserIdentifier() + " created")
                                .build()
                );
                return savedUser;
            } catch (Exception e) {
                auditService.createAudit(
                        Audit.builder()
                                .userId("SYSTEM")
                                .auditType(AuditType.SYSTEM_TYPE)
                                .moduleActivity("UserService")
                                .logText("Error creating user " + user.getUserIdentifier())
                                .build()
                );
                throw new RuntimeException(e);
            }
        }
    }

    public List<User> findAll() {
        return this.userPersistenceFacade.findAll();
    }

    public User findById(@Min(value = 1, message = "Id must be greater than 0") Long id) {
         return this.userPersistenceFacade.findById(id)
                 .orElseThrow(() -> new RecordNotFoundException(String.format("User with id '%d' not found",id)));
    }


    public void deleteById(@Min(value = 1, message = "Id must be greater than 0") Long id) {
        log.debug("deleteById {}", id);
        User user = this.userPersistenceFacade.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("User with id '%d' not found",id)));
        auditService.createAudit(
                Audit.builder()
                        .userId("SYSTEM")
                        .moduleActivity("UserService")
                        .auditType(AuditType.SYSTEM_TYPE)
                        .logText("User " + user.getUserIdentifier() + " de-activated")
                        .build()
        );
         this.userPersistenceFacade.deleteById(id);
    }

    public List<User> findByActorId(String actorId) {
        log.debug("findByActorId {}", actorId);
        return this.userPersistenceFacade.findByActorId(actorId);
    }
}
