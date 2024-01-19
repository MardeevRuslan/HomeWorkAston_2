package mardeev.homeworkaston_2.repository;

import junit.framework.TestCase;
import mardeev.homeworkaston_2.database.MyDataBase;
import mardeev.homeworkaston_2.database.MyDataBaseImpl;
import mardeev.homeworkaston_2.entity.User;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class UserRepositoryImplTest extends TestCase {
    private static MyDataBase myDataBase = new MyDataBaseImpl();

    private UserRepository userRepository = new UserRepositoryImpl(myDataBase);
    private static String nameYes = "Ivan";
    private static String nameYes2 = "Dima";
    private static String nameNot = "Ivans";
    private static String nameNot2 = "Ivant";

    private static String password = "123";

    @BeforeAll
    public static void initEach() {
        myDataBase.getUserList().add(new User(nameYes, password));
        myDataBase.getUserList().add(new User(nameYes2, password));
    }


    @Test
    public void testFindByName() {
        Assumptions.assumeTrue(userRepository.findByName(nameYes).equals(Optional.of(new User(nameYes, "123"))));
        Assumptions.assumeFalse(userRepository.findByName(nameNot).equals(Optional.of(new User(nameYes, "123"))));
    }

    @Test
    public void testSave() {
        Assumptions.assumeTrue(userRepository.save(new User(nameNot, password)));
        Assumptions.assumeTrue(userRepository.save(new User(nameYes2, password)));
    }

    @Test
    public void testUpdateUser() {
        Assumptions.assumeFalse(userRepository.updateUser(nameNot2, password));
        Assumptions.assumeTrue(userRepository.updateUser(nameYes2, password));
    }

    @Test
    public void testGetUsers() {
        Assumptions.assumeTrue(userRepository.getUsers().equals(myDataBase.getUserList()));
    }
}