package mardeev.homeworkaston_2.controller;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.dto.UserRequestDto;
import mardeev.homeworkaston_2.dto.UserResponseDto;
import mardeev.homeworkaston_2.exception.InvalidName;
import mardeev.homeworkaston_2.exception.InvalidPassword;
import mardeev.homeworkaston_2.exception.NameIsBusy;
import mardeev.homeworkaston_2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private UserService userService;

    @RequestMapping("/signUp")
    public ResponseEntity<UserResponseDto> signUp(UserRequestDto message) throws NameIsBusy {
        userService.signUp(message.getName(), message.getPassword());
        return ResponseEntity.ok(new UserResponseDto(message.getName()));
    }

    @Override
    public ResponseEntity<Object> getInvalidStatus(Exception e) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(e.getMessage());
    }

    @RequestMapping("/signIn")
    public ResponseEntity<UserResponseDto> signIn(UserRequestDto message) throws InvalidName, InvalidPassword {
        userService.signIn(message.getName(), message.getPassword());
        return ResponseEntity.ok(new UserResponseDto(message.getName()));
    }

    @RequestMapping("/update")
    public ResponseEntity<UserResponseDto> update(UserRequestDto messageOld, UserRequestDto messageNew) {
        userService.updateUser(messageOld.getName(), messageOld.getPassword(), messageNew.getPassword());
        return ResponseEntity.ok(new UserResponseDto(messageOld.getName()));
    }

    @RequestMapping("/getAll")
    public void getAll() {
        userService.getUsers();
    }

}
