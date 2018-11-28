package pl.bookmaker.demo.application.account.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
public class RegistrationUsingCredentialsRequest {

    @Email
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
