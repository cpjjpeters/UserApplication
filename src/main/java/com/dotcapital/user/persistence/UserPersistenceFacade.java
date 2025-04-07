package com.dotcapital.user.persistence;

import com.dotcapital.user.model.User;

import java.util.List;

public interface UserPersistenceFacade {
    User save(User user);

    List<User> findAll();

    User findById(Long id);

    void delete(User user);

    void deleteById(Long id);

    User update(User user);
}
