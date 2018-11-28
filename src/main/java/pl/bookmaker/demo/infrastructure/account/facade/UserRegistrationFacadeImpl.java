package pl.bookmaker.demo.infrastructure.account.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.application.account.dto.RegistrationUsingCredentialsRequest;
import pl.bookmaker.demo.application.account.facade.UserRegistrationFacade;
import pl.bookmaker.demo.application.user.dto.UserResponse;
import pl.bookmaker.demo.domain.model.entity.user.User;
import pl.bookmaker.demo.infrastructure.account.factory.UserFactory;
import pl.bookmaker.demo.infrastructure.user.interfaces.UserMapper;
import pl.bookmaker.demo.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserRegistrationFacadeImpl implements UserRegistrationFacade {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Override
    public UserResponse registerUserUsingCredentials(RegistrationUsingCredentialsRequest request) {
        User user = userFactory.createForRegistration(request);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }


}
