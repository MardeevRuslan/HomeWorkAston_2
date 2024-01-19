package mardeev.homeworkaston_2.entity;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    String name;

    String password;
}

