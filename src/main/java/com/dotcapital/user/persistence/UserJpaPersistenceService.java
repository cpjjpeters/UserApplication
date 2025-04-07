package com.dotcapital.user.persistence;

import com.dotcapital.user.entities.UserJpaEntity;
import com.dotcapital.user.mapper.UserJpaDaoMapper;
import com.dotcapital.user.model.User;
import com.dotcapital.user.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.user.persistence */
@Slf4j
@Service
public class UserJpaPersistenceService implements  UserPersistenceFacade{
    private final UserJpaRepository userJpaRepository;
    private final UserJpaDaoMapper userJpaDaoMapper;

    public UserJpaPersistenceService(UserJpaRepository userJpaRepository, UserJpaDaoMapper userJpaDaoMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userJpaDaoMapper = userJpaDaoMapper;
    }


    @Override
    public User save(User user) {

        final UserJpaEntity saved = userJpaRepository.save(userJpaDaoMapper.modelToJpaEntity(user));
        log.debug("User JPA = {}", saved.toString());
        return userJpaDaoMapper.jpaEntityToModel(saved);
    }

    @Override
    public List<User> findAll() {
        log.debug("get all users");
        return userJpaRepository.findAll()
                .stream()
                .map(userJpaDaoMapper::jpaEntityToModel)
                .toList();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User update(User user) {
        return null;
    }
}
