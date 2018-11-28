package pl.bookmaker.demo.infrastructure.user.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bookmaker.demo.application.user.dto.UpdateUserProfileRequest;
import pl.bookmaker.demo.application.user.dto.UserResponse;
import pl.bookmaker.demo.application.user.facade.UserProfileFacade;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class UserProfileRestController {

    private final UserProfileFacade userProfileFacade;

    @RequestMapping(path = "/user/profile", method = RequestMethod.GET)
    public UserResponse getUserProfile(@RequestParam(value="userId") int userId) {
        return userProfileFacade.getUserProfile(userId);
    }

    @RequestMapping(path = "/user/profile", method = RequestMethod.PUT)
    public UserResponse updateUserProfile(@RequestParam(value="userId") int userId, @RequestBody UpdateUserProfileRequest request) {
        return userProfileFacade.updateUserProfile(userId, request);
    }
}
