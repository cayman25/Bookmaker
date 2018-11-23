package pl.bookmaker.demo.infrastructure.games.interfaces;

import pl.bookmaker.demo.domain.model.dto.GameDto;
import pl.bookmaker.demo.domain.model.entity.Game;

import java.util.List;
import java.util.Set;

public interface GameMapper {

  Set<GameDto> mapToGameDto(List<Game> games);

}
