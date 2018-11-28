package pl.bookmaker.demo.application.account.facade;

import pl.bookmaker.demo.application.account.dto.RegistrationUsingCredentialsRequest;
import pl.bookmaker.demo.application.user.dto.UserResponse;

public interface UserRegistrationFacade {

    UserResponse registerUserUsingCredentials(RegistrationUsingCredentialsRequest request);

}
