package mardeev.homeworkaston_2.repository;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.database.MyDataBase;
import mardeev.homeworkaston_2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private MyDataBase dataBase;


    @Override
    public Optional<User> findByName(String name) {
        dataBase.hashCode();
        return Optional.empty();
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean updateUser(String name, String passwordNew) {
        return false;
    }


    @Override
    public List<User> getUsers() {
        return null;
    }
}
