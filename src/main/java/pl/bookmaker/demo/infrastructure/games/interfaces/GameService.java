package pl.bookmaker.demo.infrastructure.games.interfaces;

import pl.bookmaker.demo.domain.model.entity.Game;

import java.util.List;

public interface GameService {

  List<Game> getGamesFromCompetition(int competitionId);

  List<Game> getGamesFromToday();

  List<Game> getGamesFromDate(String date);

  List<Game> getGamesFromCompetitionAndDate(int competitionId, String date);
}
