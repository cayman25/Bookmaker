package pl.bookmaker.demo.application.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private int id;
    private String email;
    private String firstName;
    private String lastName;

}
