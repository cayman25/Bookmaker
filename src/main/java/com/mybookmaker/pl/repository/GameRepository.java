package com.mybookmaker.pl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.model.dto.GameDto;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game, Integer>{
	
	@Query("Select new com.mybookmaker.pl.model.dto.GameDto"
			+ "(g.matchID, g.competition.competitionID, g.homeTeam.teamName,g.awayTeam.teamName, g.dateMatch, g.startTime, g.statusMatch, g.winner)"
			+ " from Game g "
			+ "where g.dateMatch = :date "
			+ "order by g.dateMatch, g.startTime")
	List<GameDto> getMatchesByDate(@Param("date") String date);
	
	@Query("Select new com.mybookmaker.pl.model.dto.GameDto"
			+ "(g.matchID, g.competition.competitionID, g.homeTeam.teamName, g.awayTeam.teamName, g.dateMatch, g.startTime, g.statusMatch, g.winner)"
			+ "from Game g "
			+ "where g.dateMatch = :date AND "
			+ "g.competition.competitionID = :competition "
			+ "order by g.dateMatch, g.startTime")
	List<GameDto> getMatchesByDateAndCompetition(@Param("date") String date, @Param("competition") int competition);
	
	@Query("Select new com.mybookmaker.pl.model.dto.GameDto"
			+ "(g.matchID, g.competition.competitionID, g.homeTeam.teamName, g.awayTeam.teamName, g.dateMatch, g.startTime, g.statusMatch, g.winner)"
			+ "from Game g "
			+ "where g.competition.competitionID = :competition "
			+ "order by g.dateMatch, g.startTime")
	List<GameDto> getMatchesByCompetition(@Param("competition") int competition);

}
