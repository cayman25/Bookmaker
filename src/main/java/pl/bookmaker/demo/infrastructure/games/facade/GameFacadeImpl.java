package pl.bookmaker.demo.infrastructure.games.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.infrastructure.games.interfaces.GameFacade;
import pl.bookmaker.demo.infrastructure.games.interfaces.GameMapper;
import pl.bookmaker.demo.infrastructure.games.interfaces.GameService;
import pl.bookmaker.demo.domain.model.dto.GameDto;
import pl.bookmaker.demo.domain.model.entity.Game;
import pl.bookmaker.demo.repository.GameRepository;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class GameFacadeImpl implements GameFacade {

  private final GameRepository gameRepository;
  private final GameService gameService;
  private final GameMapper gameMapper;

  @Override
  public Set<GameDto> getGamesByCompetitionId(int competitionId){
    List<Game> games = gameService.getGamesFromCompetition(competitionId);
    return  gameMapper.mapToGameDto(games);
  }

  @Override
  public Set<GameDto> getGamesFromToday() {
    List<Game> games = gameService.getGamesFromToday();
    return gameMapper.mapToGameDto(games);
  }

  @Override
  public Set<GameDto> getGamesFromDate(String date) {
    List<Game> games = gameService.getGamesFromDate(date);
    return gameMapper.mapToGameDto(games);
  }

  @Override
  public Set<GameDto> getGamesFromCompetitionAndDate(int competitionId, String date) {
    List<Game> games = gameService.getGamesFromCompetitionAndDate(competitionId,date);
    return gameMapper.mapToGameDto(games);
  }

  @Override
  public List<Game> findAll(){
    return gameRepository.findAll();
  }
}
