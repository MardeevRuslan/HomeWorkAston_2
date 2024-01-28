package mardeev.homeworkaston_2.service;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.entity.User;
import mardeev.homeworkaston_2.exception.InvalidName;
import mardeev.homeworkaston_2.exception.InvalidPassword;
import mardeev.homeworkaston_2.exception.NameIsBusy;
import mardeev.homeworkaston_2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public boolean signUp(String name, String password) throws NameIsBusy {
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent()) {
            throw new NameIsBusy("Name " + name + "is busy");
        }
        return userRepository.save(new User(name, password));
    }

    @Override
    public boolean signIn(String name, String password) throws InvalidName, InvalidPassword {
        Optional<User> user = userRepository.findByName(name);
        if (!user.isPresent()) {
            throw  new InvalidName("Name " + name + "not");
        }
        if (!password.equals(user.get().getPassword())) {
            throw  new InvalidPassword("Name " + name + "invalid password");
        }
        return true;
    }

    @Override
    public boolean updateUser(String name, String passwordOld, String passwordNew) {
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent() && passwordOld.equals(user.get().getPassword())) {
            return userRepository.updateUser(name, passwordNew);
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
