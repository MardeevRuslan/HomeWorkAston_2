package mardeev.homeworkaston_2.service;

import mardeev.homeworkaston_2.entity.User;

import mardeev.homeworkaston_2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public boolean signUp(String name, String password) {
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent()) {
           return false;
        }
        return userRepository.save(user.get());
    }

    @Override
    public boolean signIn(String name, String password) {
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            return true;
        }
        return false;
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
        return  userRepository.getUsers();
    }
}
