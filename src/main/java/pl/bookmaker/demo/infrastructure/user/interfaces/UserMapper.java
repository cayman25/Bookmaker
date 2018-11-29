package pl.bookmaker.demo.infrastructure.user.interfaces;

import pl.bookmaker.demo.application.user.dto.UpdateUserProfileRequest;
import pl.bookmaker.demo.application.user.dto.UserResponse;
import pl.bookmaker.demo.domain.model.entity.user.User;

public interface UserMapper {

    UserResponse mapToUserResponse(User user);

    void updateUserProfile(UpdateUserProfileRequest request, User user);
}
