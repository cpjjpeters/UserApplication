package com.dotcapital.user.repository;

import com.dotcapital.user.entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
    UserJpaEntity findByActorId(Long id);
}
