package pl.bookmaker.demo.infrastructure.user.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.application.user.dto.UpdateUserProfileRequest;
import pl.bookmaker.demo.application.user.dto.UserResponse;
import pl.bookmaker.demo.application.user.facade.UserProfileFacade;
import pl.bookmaker.demo.domain.model.entity.User;
import pl.bookmaker.demo.infrastructure.user.interfaces.UserMapper;
import pl.bookmaker.demo.repository.UserRepository;
import pl.bookmaker.demo.service.user.service.UserService;

@AllArgsConstructor
@Service
public class UserProfileFacadeImpl implements UserProfileFacade {

    private final UserRepository userRepository;
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUserProfile(int userId) {
        User user = userService.getUserById(userId);
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUserProfile(int userId, UpdateUserProfileRequest request) {
        User user = userService.getUserById(userId);
        userMapper.updateUserProfile(request, user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }
}
