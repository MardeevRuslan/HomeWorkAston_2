package mardeev.homeworkaston_2.controller;

import mardeev.homeworkaston_2.dto.UserRequestDto;
import mardeev.homeworkaston_2.dto.UserResponseDto;
import mardeev.homeworkaston_2.exception.InvalidName;
import mardeev.homeworkaston_2.exception.InvalidPassword;
import mardeev.homeworkaston_2.exception.NameIsBusy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public interface UserController {
    @RequestMapping("/signUp")
    ResponseEntity<UserResponseDto> signUp(UserRequestDto message) throws NameIsBusy;
    ResponseEntity<Object> getInvalidStatus(Exception e);

    @RequestMapping("/signIn")
    ResponseEntity<UserResponseDto> signIn(UserRequestDto message) throws InvalidName, InvalidPassword;
    @RequestMapping("/update")
    ResponseEntity<UserResponseDto> update(UserRequestDto messageOld, UserRequestDto messageNew);

    @RequestMapping("/getAll")
    void getAll();
}
