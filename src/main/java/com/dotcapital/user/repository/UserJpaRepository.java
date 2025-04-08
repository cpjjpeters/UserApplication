package com.dotcapital.user.repository;

import com.dotcapital.user.entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
    Optional<UserJpaEntity> findByActorId(String  actorId);
}
