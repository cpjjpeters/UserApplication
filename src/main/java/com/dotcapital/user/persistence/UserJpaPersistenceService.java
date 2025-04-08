package com.dotcapital.user.persistence;

import com.dotcapital.user.entities.UserJpaEntity;
import com.dotcapital.user.mapper.UserJpaDaoMapper;
import com.dotcapital.user.model.User;
import com.dotcapital.user.repository.UserJpaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public User save(User user) {
        log.debug("Saving user: {}", user);

        UserJpaEntity savedEntity;

        if (user.getActorId() != null) {
            // Check if the user exists by actorId
            Optional<UserJpaEntity> existingUserOpt = userJpaRepository.findByActorId(user.getActorId());

            if (existingUserOpt.isPresent()) {
                // Update existing user
                UserJpaEntity existingUser = existingUserOpt.get();
                log.debug("User found: {}", existingUser);
                existingUser.setUserStatus("ACTIVE");
                savedEntity = userJpaRepository.save(existingUser);
            } else {
                // Create new user
                log.debug("User not found, creating new user: {}", user);
                savedEntity = userJpaRepository.save(userJpaDaoMapper.modelToJpaEntity(user));
            }
        } else {
            // Create new user if actorId is null
            log.debug("ActorId is null, creating new user: {}", user);
            savedEntity = userJpaRepository.save(userJpaDaoMapper.modelToJpaEntity(user));
        }

        log.debug("Saved User JPA Entity: {}", savedEntity);
        return userJpaDaoMapper.jpaEntityToModel(savedEntity);
    }

//    public User save(User user) {
//        UserJpaEntity saved = null;
//
//        if(user.getActorId() != null) {
//            log.debug("update user {}", user);
//            Optional<UserJpaEntity> found = userJpaRepository.findByActorId(user.getActorId());
//                    if(found.isPresent()) {
//                        UserJpaEntity beSaved = found.get();
//                        log.debug("user found {}", beSaved);
//                       beSaved.setUserStatus("ACTIVE");
//                        saved = userJpaRepository.save(beSaved);
//                    }else {
//                        log.debug("user not found, create new user {}", user);
//                        saved = userJpaRepository.save(userJpaDaoMapper.modelToJpaEntity(user));
//                    }
//
//        } else {
//            log.debug("create user {}", user);
//            saved = userJpaRepository.save(userJpaDaoMapper.modelToJpaEntity(user));
//        }
//        log.debug("User JPA = {}", saved.toString());
//        return userJpaDaoMapper.jpaEntityToModel(saved);
//    }

    @Override
    public List<User> findAll() {
        log.debug("get all users");
        return userJpaRepository.findAll()
                .stream()
                .map(userJpaDaoMapper::jpaEntityToModel)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        log.debug("findById: {}", id);

        return this.userJpaRepository.findById(id)
                .map(userJpaEntity -> this.userJpaDaoMapper.jpaEntityToModel(userJpaEntity));
    }

    public Optional<UserJpaEntity> findByActorId(String actorId) {
        log.debug("findByActorId: {}", actorId);

        return this.userJpaRepository.findByActorId(actorId);
    }

    @Override
    public void delete(User user) {
        log.debug("delete: {}", user.toString());

    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById: {}", id);
        UserJpaEntity found = userJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found for this id ::" + id));
        found.setUserStatus("DISABLED");
        userJpaRepository.save(found);

    }

    @Override
    public User update(User user) {
        log.debug("update: {}", user.toString());
        return null;
    }
}
