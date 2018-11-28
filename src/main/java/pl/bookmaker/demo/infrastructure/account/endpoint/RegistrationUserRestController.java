package pl.bookmaker.demo.infrastructure.account.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.bookmaker.demo.application.account.dto.RegistrationUsingCredentialsRequest;
import pl.bookmaker.demo.application.account.facade.UserRegistrationFacade;
import pl.bookmaker.demo.application.user.dto.UserResponse;

@AllArgsConstructor
@RestController
@RequestMapping(value = "account/register")
public class RegistrationUserRestController {

    private final UserRegistrationFacade userRegistrationFacade;

    @RequestMapping(path = "/account/register/credentials", method = RequestMethod.POST)
    public UserResponse registerUser(@RequestBody RegistrationUsingCredentialsRequest request) {
        return userRegistrationFacade.registerUserUsingCredentials(request);
    }
}
