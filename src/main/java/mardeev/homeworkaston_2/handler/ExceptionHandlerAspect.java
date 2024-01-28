package mardeev.homeworkaston_2.handler;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.controller.UserController;
import mardeev.homeworkaston_2.exception.InvalidName;
import mardeev.homeworkaston_2.exception.InvalidPassword;
import mardeev.homeworkaston_2.exception.NameIsBusy;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Aspect
@Component
@AllArgsConstructor
@RestController
public class ExceptionHandlerAspect {
    private  final UserController userController;

    @AfterThrowing(pointcut = "execution(* mardeev.homeworkaston_2..(..))", throwing = "exception")
    public void handleSpecificException(NameIsBusy exception) {
        userController.getInvalidStatus(exception);
    }

    @AfterThrowing(pointcut = "execution(* mardeev.homeworkaston_2..(..))", throwing = "exception")
    public void handleSpecificException(InvalidName exception) {
        userController.getInvalidStatus(exception);
    }

    @AfterThrowing(pointcut = "execution(* mardeev.homeworkaston_2..(..))", throwing = "exception")
    public void handleSpecificException(InvalidPassword exception) {
        userController.getInvalidStatus(exception);
    }

}
