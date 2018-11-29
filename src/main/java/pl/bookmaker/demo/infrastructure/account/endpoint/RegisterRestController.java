package pl.bookmaker.demo.infrastructure.account.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.bookmaker.demo.application.account.dto.RegisterUsingCredentials;
import pl.bookmaker.demo.application.account.facade.UserRegisterFacade;
import pl.bookmaker.demo.application.user.dto.UserResponse;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class RegisterRestController {

    private final UserRegisterFacade userRegisterFacade;

    @RequestMapping(path = "/account/register" , method = RequestMethod.POST)
    public UserResponse registerUser(@RequestBody RegisterUsingCredentials request){
        return userRegisterFacade.registerUserUsingCredentials(request);
    }
}
