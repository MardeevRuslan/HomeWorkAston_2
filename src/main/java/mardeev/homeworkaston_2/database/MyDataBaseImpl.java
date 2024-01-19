package mardeev.homeworkaston_2.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mardeev.homeworkaston_2.entity.User;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class MyDataBaseImpl implements MyDataBase {
    private final List<User> userList = new ArrayList<>();

}
