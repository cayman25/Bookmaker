package pl.bookmaker.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookmaker.demo.domain.model.game.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
