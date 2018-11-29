package pl.bookmaker.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookmaker.demo.domain.model.user.UserBets;

@Repository
public interface UserBetsRepository extends JpaRepository<UserBets, Integer> {

    UserBets findByUserUserIdAndGameMatchID(int userId, int matchId);
}
