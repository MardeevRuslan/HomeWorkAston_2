package mardeev.homeworkaston_2.repository;

import mardeev.homeworkaston_2.config.SessionFactoryConfig;
import mardeev.homeworkaston_2.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserRepositoryImplTest {
    private UserRepository userRepository;

    @Mock
    private SessionFactoryConfig sessionFactoryConfig;

    @Mock
    private Session session;

    @Mock
    private Query<User> query;

    @Mock
    private UserRepository userRepositoryOld;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userRepository = new UserRepositoryImpl(sessionFactoryConfig);
    }

    @Test
    public void testFindByNameWhenUserExists() {
        String name = "testUser";
        User user = new User(name, "password");
        when(sessionFactoryConfig.getSession()).thenReturn(session);
        when(session.get(User.class, name)).thenReturn(user);

        Optional<User> result = userRepository.findByName(name);
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    public void testFindByNameWhenUserDoesNotExist() {
        String name = "nonExistentUser";
        when(sessionFactoryConfig.getSession()).thenReturn(session);
        when(session.get(User.class, name)).thenReturn(null);

        Optional<User> result = userRepository.findByName(name);
        assertFalse(result.isPresent());
    }

    @Test
    public void testSaveUser() {
        User user = new User("newUser", "password");
        when(sessionFactoryConfig.getSession()).thenReturn(session);
        assertTrue(userRepository.save(user));
    }

    @Test
    public void testUpdateUserWhenUserExists() {
        String name = "testUser";
        User user = new User(name, "password");
        when(sessionFactoryConfig.getSession()).thenReturn(session);
        when(userRepositoryOld.findByName(name)).thenReturn(Optional.ofNullable(user));

        assertFalse(userRepository.updateUser(name, "newPassword"));
    }


    @Test
    public void testGetUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("user1", "password1"));
        userList.add(new User("user2", "password2"));

        when(sessionFactoryConfig.getSession()).thenReturn(session);
        org.hibernate.query.Query<User> query = Mockito.mock(org.hibernate.query.Query.class);
        when(session.createQuery("from User", User.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(userList);

        List<User> result = userRepository.getUsers();
        assertEquals(userList, result);
    }
}