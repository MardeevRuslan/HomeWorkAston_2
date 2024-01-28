package mardeev.homeworkaston_2.service;

import mardeev.homeworkaston_2.entity.User;
import mardeev.homeworkaston_2.exception.NameIsBusy;
import mardeev.homeworkaston_2.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testSignUpWhenUserExists() {
        String name = "testUser";
        String password = "password";
        when(userRepository.findByName(name)).thenReturn(Optional.of(new User(name, password)));

        assertThrows(NameIsBusy.class, () -> userService.signUp(name, password));
    }

    @Test
    public void testSignUpWhenUserDoesNotExist() throws NameIsBusy {
        String name = "newUser";
        String password = "password";
        when(userRepository.findByName(name)).thenReturn(Optional.empty());
        when(userRepository.save(new User(name, password))).thenReturn(true);

        assertTrue(userService.signUp(name, password));
    }
}