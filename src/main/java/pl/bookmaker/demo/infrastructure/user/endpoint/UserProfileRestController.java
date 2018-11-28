package pl.bookmaker.demo.infrastructure.user.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.bookmaker.demo.application.user.dto.UserResponse;
import pl.bookmaker.demo.application.user.facade.UserProfileFacade;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class UserProfileRestController {

    private final UserProfileFacade userProfileFacade;

    @RequestMapping(path = "/user/profile", method = RequestMethod.GET)
    public UserResponse getUserProfile() {
        return userProfileFacade.getUserProfile(account.getId());
    }

}
