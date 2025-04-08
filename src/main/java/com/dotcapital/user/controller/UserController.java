package com.dotcapital.user.controller;

import com.dotcapital.user.entities.UserJpaEntity;
import com.dotcapital.user.mapper.UserJpaDaoMapper;
import com.dotcapital.user.model.User;
import com.dotcapital.user.repository.UserJpaRepository;
import com.dotcapital.user.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.user.controller */
@Transactional
@RestController
@RequestMapping(value="/users")
@Validated
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserJpaDaoMapper userJpaDaoMapper;

    public UserController(UserService userService, UserJpaDaoMapper userJpaDaoMapper) {
        this.userService = userService;
        this.userJpaDaoMapper = userJpaDaoMapper;
    }

    @PostMapping(value="/create")
    public ResponseEntity<User> create(@Validated @RequestBody User user) {
        log.debug("create user or re-activate user  {}", user);
        User savedUser = userService.save(user);
        log.debug("saved user {}", savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getAll() {
        log.debug("get all users");
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findById(   @PathVariable @Min(value = 1, message = "Id must be greater than 0") Long id) {
        log.debug("findById {}", id);
            return ResponseEntity.ok(this.userService.findById(id));
        }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Min(value = 1, message = "Id must be greater than 0") Long id) {
        log.debug("deleteById {}", id);
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
//    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        log.debug("Updating user with id {}: {}", id, user);
        user.setEntityId(id);
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<User> partiallyUpdateUser(@PathVariable("id") Long id, @RequestBody User user) {
        log.debug("Partially updating user with id {}: {}", id, user);
        User existingUser = userService.findById(id);

        // Update only non-null fields
        if (user.getUserStatus() != null) {
            existingUser.setUserStatus(user.getUserStatus());
        }
        if (user.getUserEmail() != null) {
            existingUser.setUserEmail(user.getUserEmail());
        }
        if(user.getUserFirstName() != null) {
            existingUser.setUserFirstName(user.getUserFirstName());
        }
        if(user.getUserLastName() != null) {
            existingUser.setUserLastName(user.getUserLastName());
        }
        if(user.getUserStatus() != null) {
            existingUser.setUserStatus(user.getUserStatus());
        }
        // Add more fields as needed...

        User updatedUser = userService.save(existingUser);
        return ResponseEntity.ok(updatedUser);
    }



}
