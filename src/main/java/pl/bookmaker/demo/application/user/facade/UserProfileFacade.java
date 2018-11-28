package pl.bookmaker.demo.application.user.facade;

import pl.bookmaker.demo.application.user.dto.UpdateUserProfileRequest;
import pl.bookmaker.demo.application.user.dto.UserResponse;

public interface UserProfileFacade {

    UserResponse getUserProfile(int userId);

    UserResponse updateUserProfile(int userId, UpdateUserProfileRequest request);

}
