package com.dotcapital.user.controller;

import com.dotcapital.user.model.User;
import com.dotcapital.user.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        User user = new User();
        user.setActorId("actor123");
        when(userService.save(any(User.class), anyBoolean())).thenReturn(user);

        ResponseEntity<User> response = userController.create(user);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("actor123", response.getBody().getActorId());
        verify(userService, times(1)).save(any(User.class), anyBoolean());
    }

    @Test
    void getAll() {
        User user = new User();
        when(userService.findAll()).thenReturn(Collections.singletonList(user));

        ResponseEntity<List<User>> response = userController.getAll();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        verify(userService, times(1)).findAll();
    }

    @Test
    void findById() {
        User user = new User();
        user.setActorId("actor123");
        when(userService.findById(1L)).thenReturn(user);

        ResponseEntity<User> response = userController.findById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("actor123", response.getBody().getActorId());
        verify(userService, times(1)).findById(1L);
    }

    @Test
    void deleteById() {
        doNothing().when(userService).deleteById(1L);

        ResponseEntity<Void> response = userController.deleteById(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(userService, times(1)).deleteById(1L);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setActorId("actor123");
        when(userService.findById(1L)).thenReturn(user);
        when(userService.updateUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.updateUser(1L, user);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("actor123", response.getBody().getActorId());
        verify(userService, times(1)).findById(1L);
        verify(userService, times(1)).updateUser(any(User.class));
    }

    @Test
    void partiallyUpdateUser() {
        User existingUser = new User();
        existingUser.setActorId("actor123");
        User updatedUser = new User();
        updatedUser.setUserEmail("test@example.com");

        when(userService.findById(1L)).thenReturn(existingUser);
        when(userService.updateUser(any(User.class))).thenReturn(existingUser);

        ResponseEntity<User> response = userController.partiallyUpdateUser(1L, updatedUser);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("actor123", response.getBody().getActorId());
        assertEquals("test@example.com", response.getBody().getUserEmail());
        verify(userService, times(1)).findById(1L);
        verify(userService, times(1)).updateUser(any(User.class));
    }
}