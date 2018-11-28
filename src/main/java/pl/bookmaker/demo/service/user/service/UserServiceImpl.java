package pl.bookmaker.demo.service.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.domain.model.entity.User;
import pl.bookmaker.demo.infrastructure.games.ex.NotFoundException;
import pl.bookmaker.demo.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("user with id '%s' not found", userId)));
    }


}
