package com.dotcapital.user.services;

import com.dotcapital.user.model.User;
import com.dotcapital.user.persistence.UserPersistenceFacade;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.user.services */
@Slf4j
@Service
public class UserService {
     private final UserPersistenceFacade userPersistenceFacade;

     public UserService(UserPersistenceFacade userPersistenceFacade) {
         this.userPersistenceFacade = userPersistenceFacade;
     }

     public User save(User user) {
         return this.userPersistenceFacade.save(user);
     }

    public List<User> findAll() {
        return this.userPersistenceFacade.findAll();
    }

    public User findById(@Min(value = 1, message = "Id must be greater than 0") Long id) {
         return this.userPersistenceFacade.findById(id);
    }
}
