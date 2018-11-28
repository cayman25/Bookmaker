package pl.bookmaker.demo.infrastructure.account.factory;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.account.dto.RegistrationUsingCredentialsRequest;
import pl.bookmaker.demo.domain.model.entity.user.User;

@Component
public class UserFactory {

    public User createForRegistration(RegistrationUsingCredentialsRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
}
