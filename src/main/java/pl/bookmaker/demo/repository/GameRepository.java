package pl.bookmaker.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookmaker.demo.domain.model.entity.Game;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

	List<Game> findByCompetitionCompetitionID(int competitionId);

	List<Game> findByDateMatch(String today);

	List<Game> findByCompetitionCompetitionIDAndDateMatch(int competitionId, String date);

	@Override
	Page<Game> findAll(Pageable pageable);
}
