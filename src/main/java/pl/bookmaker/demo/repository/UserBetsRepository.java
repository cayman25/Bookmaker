
package pl.bookmaker.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookmaker.demo.domain.model.entity.UserBets;

@Repository
public interface UserBetsRepository extends JpaRepository<UserBets, Integer>{

    public UserBets findByUserUserIdAndGame_MatchID(int userId, int matchId);
}
