package mardeev.homeworkaston_2.controller;

import mardeev.homeworkaston_2.dto.AddUserRequestDto;
import org.springframework.web.bind.annotation.RequestMapping;

public interface UserController {
    @RequestMapping("/signUp")
    void signUp(AddUserRequestDto message);

    @RequestMapping("/signIn")
    void signIn(AddUserRequestDto message);
    @RequestMapping("/update")
    void update(AddUserRequestDto messageOld, AddUserRequestDto messageNew);

    @RequestMapping("/getAll")
    void getAll();
}
