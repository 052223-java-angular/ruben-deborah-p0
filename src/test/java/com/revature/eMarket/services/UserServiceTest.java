package com.revature.eMarket.services;

import com.revature.eMarket.daos.UserDAO;
import com.revature.eMarket.models.Role;
import com.revature.eMarket.models.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserDAO userDao;
    @Mock
    private RoleService roleService;

    private UserService userService;

    @Before
    public void setUp() {
        // Initialize the Mockito framework
        MockitoAnnotations.openMocks(this);

        // Create a new instance of the UserService class with the mocked dependencies
        userService = new UserService(userDao, roleService);
    }

    @Test
    public void testRegister() {
        // Define the test input values
        String username = "testUser";
        String password = "testPassword";
        Role role = new Role("1", "USER");
        User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), role.getId());

        // Mock the behavior of the roleService and userDao objects
        when(roleService.findByName("USER")).thenReturn(role);
        doNothing().when(userDao).save(any(User.class));

        // Call the register method of the userService object with the test input values
        User result = userService.register(username, password);

        // Verify that the userDao.save method was called once with any User object as
        // an argument
        verify(userDao, times(1)).save(any(User.class));

        // Verify that the result object has the expected username value
        assertEquals(username, result.getUsername());
    }




    @org.junit.jupiter.api.Test
    void register() {
    }

    @org.junit.jupiter.api.Test
    void login() {
    }

    @org.junit.jupiter.api.Test
    void isValidPassword() {
    }

    @org.junit.jupiter.api.Test
    void isSamePassword() {
    }

    @org.junit.jupiter.api.Test
    void isUniqueUsername() {
    }

    @org.junit.jupiter.api.Test
    void isValidUsername() {
    }

    @org.junit.jupiter.api.Test
    void findByUserName() {
    }

    @org.junit.jupiter.api.Test
    void findById() {
    }
}