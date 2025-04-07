package com.dotcapital.user.repository;

import com.dotcapital.user.entities.UserJpaEntity;
import com.dotcapital.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
}
