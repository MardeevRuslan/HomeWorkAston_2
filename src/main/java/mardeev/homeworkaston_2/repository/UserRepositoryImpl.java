package mardeev.homeworkaston_2.repository;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.database.MyDataBase;
import mardeev.homeworkaston_2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private MyDataBase dataBase;


    @Override
    public Optional<User> findByName(String name) {
        for (User user : dataBase.getUserList()) {
            if (user.getName().equals(name)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean save(User user) {
        return dataBase.getUserList().add(user);
    }

    @Override
    public boolean updateUser(String name, String passwordNew) {
        Optional<User> optionalUser = findByName(name);
        if (optionalUser.isPresent() && dataBase.getUserList().remove(optionalUser.get())) {
            return dataBase.getUserList().add(new User(name, passwordNew));
        }
        return false;
    }


    @Override
    public List<User> getUsers() {
        return dataBase.getUserList();
    }
}
