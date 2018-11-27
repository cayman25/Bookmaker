package pl.bookmaker.demo.application.games.facade;

import pl.bookmaker.demo.application.games.dto.GameDto;
import pl.bookmaker.demo.domain.model.entity.Game;

import java.util.List;
import java.util.Set;

public interface GameFacade {

  Set<GameDto> getGamesByCompetitionId(int competitionId);

  Set<GameDto> getGamesFromToday();

  Set<GameDto> getGamesFromDate(String date);

  Set<GameDto> getGamesFromCompetitionAndDate(int competitionId, String date);

  List<Game> findAll();
}
