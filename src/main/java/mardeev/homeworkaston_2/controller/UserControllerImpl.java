package mardeev.homeworkaston_2.controller;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.dto.AddUserRequestDto;
import mardeev.homeworkaston_2.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private UserService userService;

    @RequestMapping("/signUp")
    public void signUp(AddUserRequestDto message) {
        userService.signUp(message.getName(), message.getPassword());
    }

    @RequestMapping("/signIn")
    public void signIn(AddUserRequestDto message) {
        userService.signIn(message.getName(), message.getPassword());
    }

    @RequestMapping("/update")
    public void update(AddUserRequestDto messageOld, AddUserRequestDto messageNew) {
        userService.updateUser(messageOld.getName(), messageOld.getPassword(), messageNew.getPassword());
    }

    @RequestMapping("/getAll")
    public void getAll() {
        userService.getUsers();
    }
}
