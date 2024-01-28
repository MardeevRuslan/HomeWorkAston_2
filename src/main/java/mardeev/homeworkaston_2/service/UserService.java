package mardeev.homeworkaston_2.service;

import mardeev.homeworkaston_2.entity.User;
import mardeev.homeworkaston_2.exception.InvalidName;
import mardeev.homeworkaston_2.exception.InvalidPassword;
import mardeev.homeworkaston_2.exception.NameIsBusy;

import java.util.List;

public interface UserService {
    boolean signUp(String name, String password) throws NameIsBusy;

    boolean signIn(String name, String password) throws InvalidName, InvalidPassword;

    boolean updateUser(String name, String passwordOld, String passwordNew);


    List<User> getUsers();
}
