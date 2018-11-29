package pl.bookmaker.demo.infrastructure.games.interfaces;

import pl.bookmaker.demo.application.games.dto.GameDto;
import pl.bookmaker.demo.domain.model.game.Game;

import java.util.List;
import java.util.Set;

public interface GameMapper {

    Set<GameDto> mapToGameDto(List<Game> games);

}
