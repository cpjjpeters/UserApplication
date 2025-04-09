package com.dotcapital.user.services;

import com.dotcapital.exception.RecordNotFoundException;
import com.dotcapital.user.model.User;
import com.dotcapital.user.persistence.UserPersistenceFacade;
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

     public UserService(UserPersistenceFacade userPersistenceFacade) {
         this.userPersistenceFacade = userPersistenceFacade;
     }

     public User save(User user, boolean isExistingUser) {
            log.debug("save user {}, {}", user, isExistingUser);
            if (isExistingUser) {
                // If the user already exists, update the status to ACTIVE
                return this.userPersistenceFacade.adapt(user);

            } else {
                // If the user does not exist, set the status to INACTIVE
                return this.userPersistenceFacade.save(user);
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
         this.userPersistenceFacade.deleteById(id);
    }

    public Optional<User> findByActorId(String actorId) {
        log.debug("findByActorId {}", actorId);
        return this.userPersistenceFacade.findByActorId(actorId);
    }
}
