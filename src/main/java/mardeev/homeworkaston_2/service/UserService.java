package mardeev.homeworkaston_2.service;

import mardeev.homeworkaston_2.entity.User;

import java.util.List;

public interface UserService {
    boolean signUp(String name, String password);

    boolean signIn(String name, String password);

    boolean updateUser(String name, String passwordOld, String passwordNew);


    List<User> getUsers();
}
