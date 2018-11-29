package pl.bookmaker.demo.infrastructure.account.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.account.dto.RegisterUsingCredentials;
import pl.bookmaker.demo.application.account.facade.UserRegisterFacade;
import pl.bookmaker.demo.application.user.dto.UserResponse;
import pl.bookmaker.demo.domain.model.user.User;
import pl.bookmaker.demo.infrastructure.user.factory.UserFactory;
import pl.bookmaker.demo.infrastructure.user.interfaces.UserMapper;
import pl.bookmaker.demo.repository.UserRepository;

@Component
@AllArgsConstructor
public class UserRegisterFacadeImpl implements UserRegisterFacade {

    private final UserFactory userFactory;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUserUsingCredentials(RegisterUsingCredentials request) {
        User user = userFactory.createForRegistration(request);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }


}
