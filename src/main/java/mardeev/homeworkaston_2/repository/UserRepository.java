package mardeev.homeworkaston_2.repository;

import mardeev.homeworkaston_2.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository  {

    Optional<User> findByName(String name);

    boolean save(User user);


    boolean updateUser(String name, String passwordNew);

    List<User> getUsers();
}
