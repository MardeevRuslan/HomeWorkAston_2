package mardeev.homeworkaston_2.application;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.controller.UserController;

import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class ApplicationImpl implements Application {
    private UserController userController;
    @Override
    public void run() {
        System.out.println("aaaaa");
    }
}
