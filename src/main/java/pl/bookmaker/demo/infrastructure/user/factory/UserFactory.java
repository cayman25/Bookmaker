package pl.bookmaker.demo.infrastructure.user.factory;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.account.dto.RegisterUsingCredentials;
import pl.bookmaker.demo.domain.model.user.User;

@Component
public class UserFactory {

    public User createForRegistration(RegisterUsingCredentials request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
}
