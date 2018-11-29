package pl.bookmaker.demo.infrastructure.games.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bookmaker.demo.application.games.dto.GameDto;
import pl.bookmaker.demo.application.games.facade.GameFacade;
import pl.bookmaker.demo.domain.model.game.Game;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class GameRest {

    private final GameFacade gameFacade;

    @RequestMapping(value = "/matches", params = {"competition"}, method = RequestMethod.GET)
    public Set<GameDto> getAllMatchesByDate(@RequestParam(value = "competition") int competition) {
        return gameFacade.getGamesByCompetitionId(competition);
    }

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public Set<GameDto> getAllMatchesFromToday() {
        return gameFacade.getGamesFromToday();
    }

    @RequestMapping(value = "/matches", params = {"date"})
    public Set<GameDto> getAllMatchesByDate(@RequestParam(value = "date") String date) {
        return gameFacade.getGamesFromDate(date);
    }

    @RequestMapping(value = "/matches", params = {"competition", "date"}, method = RequestMethod.GET)
    public Set<GameDto> getAllMatchesByCompetitionAndDate(@RequestParam(value = "date") String date, @RequestParam(value = "competition") int competition) {
        return gameFacade.getGamesFromCompetitionAndDate(competition, date);
    }

    @RequestMapping(value = "/matches", params = {"team"}, method = RequestMethod.GET)
    public Set<GameDto> getAllMatchesByTeam(@RequestParam(value = "team") int team) {
        return gameFacade.getGamesFromTeam(team);
    }

    @RequestMapping(value = "/matches", params = {"team", "date"}, method = RequestMethod.GET)
    public Set<GameDto> getAllMatchesByTeamAndDate(@RequestParam(value = "team") int team, @RequestParam(value = "date") String date) {
        return gameFacade.getGamesFromTeamAndDate(team, date);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Game> findAll() {
        return gameFacade.findAll();
    }

}