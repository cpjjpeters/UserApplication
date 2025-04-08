package com.dotcapital.user.persistence;

import com.dotcapital.user.entities.UserJpaEntity;
import com.dotcapital.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserPersistenceFacade {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

//    Optional<User> findByActorId(Long id);

    void delete(User user);

    void deleteById(Long id);

    User update(User user);
}
