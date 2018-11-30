package pl.bookmaker.demo.application.games.facade;

import pl.bookmaker.demo.application.games.dto.GameDto;

import java.util.Set;

public interface GameFacade {

    Set<GameDto> getGamesByCompetitionId(int competitionId);

    Set<GameDto> getGamesFromToday();

    Set<GameDto> getGamesFromDate(String date);

    Set<GameDto> getGamesFromCompetitionAndDate(int competitionId, String date);

    Set<GameDto> getGamesFromTeam(int teamId);

    Set<GameDto> getGamesFromTeamAndDate(int teamId, String date);
}
