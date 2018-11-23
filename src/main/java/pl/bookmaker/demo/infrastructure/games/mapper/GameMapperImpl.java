package pl.bookmaker.demo.infrastructure.games.mapper;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.infrastructure.games.interfaces.GameMapper;
import pl.bookmaker.demo.domain.model.dto.GameDto;
import pl.bookmaker.demo.domain.model.entity.Game;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GameMapperImpl implements GameMapper {

  public Set<GameDto> mapToGameDto(List<Game> games) {
    if (games == null)
      return null;

    return games.stream().map(game ->(
            new GameDto(
                    game.getMatchID(),
                    game.getCompetition().getCompetitionId(),
                    game.getHomeTeam().getTeamName(),
                    game.getAwayTeam().getTeamName(),
                    game.getDateMatch(),
                    game.getStartTime(),
                    game.getStatusMatch(),
                    game.getWinner()))).
            collect(Collectors.toSet());
  }
}
