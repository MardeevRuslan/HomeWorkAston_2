package mardeev.homeworkaston_2.service;

import junit.framework.TestCase;
import mardeev.homeworkaston_2.database.MyDataBase;
import mardeev.homeworkaston_2.database.MyDataBaseImpl;
import mardeev.homeworkaston_2.entity.User;
import mardeev.homeworkaston_2.repository.UserRepository;
import mardeev.homeworkaston_2.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserServiceImplTest extends TestCase {
    private static MyDataBase myDataBase = new MyDataBaseImpl();

    private UserRepository userRepository = new UserRepositoryImpl(myDataBase);

    private UserService userService = new UserServiceImpl(userRepository);
    private static String nameYes = "Ivan";
    private static String nameYes2 = "Dima";
    private static String nameNot = "Ivans";
    private static String nameNot2 = "Ivant";

    private static String password = "123";
    private static String passwordNo = "1234";

    @BeforeAll
    public static void initEach() {
        myDataBase.getUserList().add(new User(nameYes, password));
        myDataBase.getUserList().add(new User(nameYes2, password));
    }

    @Test
    public void testSignUp() {
        Assumptions.assumeFalse(userService.signUp(nameYes, password));
        Assumptions.assumeTrue(userService.signUp(nameNot, password));
    }

    @Test
    public void testSignIn() {
        Assumptions.assumeTrue(userService.signIn(nameYes, password));
        Assumptions.assumeFalse(userService.signIn(nameNot2, password));
        Assumptions.assumeFalse(userService.signIn(nameYes, passwordNo));
    }

    @Test
    public void testUpdateUser() {
        Assumptions.assumeTrue(userService.updateUser(nameYes, password, passwordNo));
        Assumptions.assumeFalse(userService.updateUser(nameNot2, password, passwordNo));
    }

    @Test
    public void testGetUsers() {
        Assumptions.assumeTrue(userService.getUsers().equals(myDataBase.getUserList()));
    }
}