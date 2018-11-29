package pl.bookmaker.demo.service.games.service;

import pl.bookmaker.demo.domain.model.entity.Game;

import java.util.List;

public interface GameService {

  List<Game> getGamesFromCompetition(int competitionId);

  List<Game> getGamesFromToday();

  List<Game> getGamesFromDate(String date);

  List<Game> getGamesFromCompetitionAndDate(int competitionId, String date);

  List<Game> getGamesFromTeam(int teamId);

  List<Game> getGamesFromTeamAndDate(int teamId, String date);
}
