package pl.bookmaker.demo.infrastructure.games.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.converters.DateParser;
import pl.bookmaker.demo.infrastructure.games.interfaces.GameService;
import pl.bookmaker.demo.domain.model.entity.Game;
import pl.bookmaker.demo.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

	private final GameRepository gameRepository;

	@Override
	public List<Game> getGamesFromCompetition(int competitionId){
		return gameRepository.findByCompetitionCompetitionID(competitionId);
	}

	@Override
	public List<Game> getGamesFromToday() {
		return gameRepository.findByDateMatch(DateParser.getToday());
	}

	@Override
	public List<Game> getGamesFromDate(String date) {
		return gameRepository.findByDateMatch(date);
	}

	@Override
	public List<Game> getGamesFromCompetitionAndDate(int competitionId, String date) {
		return gameRepository.findByCompetitionCompetitionIDAndDateMatch(competitionId,date);
	}

}
