package com.revature.eMarket.services;

import com.revature.eMarket.daos.UserDAO;
import com.revature.eMarket.models.Role;
import com.revature.eMarket.models.User;
import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserDAO userDAO;
    @Mock
    private RoleService roleService;
    private UserService userService;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDAO, roleService);
    }

    //This test asserts that a user debut123 is created with a role of user
    @Test
    public void testRegister() {
        // Define the test input values
        String username = "debut1234";
        String password = "gutter123";
        Role role = new Role("ad2a5623-16d0-4c36-a6b7-2f25792af676", "USER");
        User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), role.getId());

        // Mock the behavior of the roleService and userDao objects
        when(roleService.findByName("USER")).thenReturn(role);
        doNothing().when(userDAO).save(any(User.class));

        // Call the register method of the userService object with the test input values
        User result = userService.register(username, password);

        // Verify that the userDao.save method was called once with any User object as
        // an argument
        verify(userDAO, times(1)).save(any(User.class));

        // Verify that the result object has the expected username value
        assertEquals(username, result.getUsername());
    }

    @Test
    public void testLogin() {
        testRegister();
        String validUsername = "debut1234";
        String validPassword = "guter123";

        String inValidUsername = "debut1234";
        String inValidPassword = "guter123";

        Role role = new Role("ad2a5623-16d0-4c36-a6b7-2f25792af676", "USER");
        User user = new User(validUsername, BCrypt.hashpw(validPassword, BCrypt.gensalt()), role.getId());

        when(userDAO.findByUsername(validUsername)).thenReturn(Optional.of(user));
        assertTrue(userService.login(validUsername, validPassword).isPresent());

        when(userDAO.findByUsername(inValidUsername)).thenReturn(Optional.of(user));
        assertFalse(userService.login(inValidUsername, inValidPassword).isEmpty());
    }

    //This test asserts that the method will return true/false if password is/not between 8-20 characters with a letter and number
    @Test
    public void testIsValidPassword() {
        String validPassword = "Valid123";
        String invalidPassword = "invalid";

        assertTrue(userService.isValidPassword(validPassword));
        assertFalse(userService.isValidPassword(invalidPassword));
    }

    @Test
    public void testIsSamePassword() {
        String password = "password123";
        String confirmPassword = "password123";
        String differentPassword = "differentPassword123";

        assertTrue(userService.isSamePassword(password, confirmPassword));
        assertFalse(userService.isSamePassword(password, differentPassword));
    }

    //This test asserts that the method will return true/false if a username already exists in database
    @Test
    public void testIsUniqueUsername() {
        String existingUsername = "debut123";
        String newUsername = "newUser";

        when(userDAO.findByUsername(existingUsername)).thenReturn(Optional.of(new User()));
        when(userDAO.findByUsername(newUsername)).thenReturn(Optional.empty());

        assertFalse(userService.isUniqueUsername(existingUsername));
        assertTrue(userService.isUniqueUsername(newUsername));
    }

    //This test asserts that the method will return false if username is not between 8-20 characters
    @Test
    public void testIsValidUsername() {
        String validUsername = "debut123";
        String invalidUsername = "";

        assertTrue(userService.isValidUsername(validUsername));
        assertFalse(userService.isValidUsername(invalidUsername));

    }

    @Test
    public void testFindById() {
    }
}