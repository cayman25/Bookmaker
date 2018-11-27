package pl.bookmaker.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bookmaker.demo.domain.model.entity.Game;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

	@Query("Select g from Game g " +
					"join fetch g.competition " +
					"join fetch g.awayTeam " +
					"join fetch g.homeTeam " +
					"where competition=:competition")
	List<Game> findByCompetitionCompetitionID(@Param("competition") int competition);

	@Query("Select g from Game g " +
					"join fetch g.competition " +
					"join fetch g.awayTeam " +
					"join fetch g.homeTeam " +
					"where g.dateMatch=:date")
	List<Game> findByDateMatch(@Param("date") String date);

	@Query("Select g from Game g " +
					"join fetch g.competition " +
					"join fetch g.awayTeam " +
					"join fetch g.homeTeam " +
					"where competition=:competition " +
					"and g.dateMatch=:date")
	List<Game> findByCompetitionCompetitionIDAndDateMatch(@Param("competition") int competition, @Param("date") String date);

	@Query("Select g from Game g " +
			"join fetch g.competition " +
			"join fetch g.awayTeam " +
			"join fetch g.homeTeam " +
			"where g.awayTeam=:teamId or g.homeTeam=:teamId")
    List<Game> findByAwayTeamTeamIdOrHomeTeamTeamId (int teamId);

	@Query("Select g from Game g " +
			"join fetch g.competition " +
			"join fetch g.awayTeam " +
			"join fetch g.homeTeam " +
			"where g.awayTeam=:teamId or g.homeTeam=:teamId and g.dateMatch=:date")
    List<Game> findByAwayTeamTeamIdOrHomeTeamTeamIdAndDateMatch (int teamId, String date);
}
