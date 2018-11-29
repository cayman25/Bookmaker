package pl.bookmaker.demo.infrastructure.user.mapper;


import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.user.dto.UpdateUserProfileRequest;
import pl.bookmaker.demo.application.user.dto.UserResponse;
import pl.bookmaker.demo.domain.model.user.User;
import pl.bookmaker.demo.infrastructure.user.interfaces.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse mapToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getUserId() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setFirstName( user.getFirstName() );
        userResponse.setLastName( user.getLastName() );

        return userResponse;
    }

    @Override
    public void updateUserProfile(UpdateUserProfileRequest request, User user) {
        if ( request == null ) {
            return;
        }

        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
    }
}