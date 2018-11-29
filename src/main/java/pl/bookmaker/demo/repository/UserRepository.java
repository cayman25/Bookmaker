package pl.bookmaker.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookmaker.demo.domain.model.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
