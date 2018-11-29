package pl.bookmaker.demo.application.account.facade;

import pl.bookmaker.demo.application.account.dto.RegisterUsingCredentials;
import pl.bookmaker.demo.application.user.dto.UserResponse;

public interface UserRegisterFacade {
    UserResponse registerUserUsingCredentials(RegisterUsingCredentials request);
}
