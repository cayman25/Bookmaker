package pl.bookmaker.demo.infrastructure.account.factory;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.account.dto.RegistrationUsingCredentialsRequest;
import pl.bookmaker.demo.domain.model.entity.user.User;
import pl.bookmaker.demo.domain.model.entity.user.UserPermission;
import pl.bookmaker.demo.domain.model.entity.user.enums.Permission;

import java.util.Arrays;
import java.util.Set;

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
