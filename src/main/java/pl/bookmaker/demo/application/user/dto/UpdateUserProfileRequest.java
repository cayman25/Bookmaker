package pl.bookmaker.demo.application.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserProfileRequest {

    private String firstName;
    private String lastName;

}
