package com.mybookmaker.pl.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.model.externalApi.MatchesExternApi;
import com.mybookmaker.pl.repository.GameRepository;

@Service
public class GetJsonFromWebsiteService {
	
	@Autowired
	ParseJsonToPojo parseJsonToPojo;

	@Autowired
	GameRepository gameRepository;

	private Map<Integer,String> createLeagueObjects() {
		Map<Integer,String> listOfAvailableLeagues = new HashMap <Integer,String>();
		listOfAvailableLeagues.put(2021, "England: Premier League");
		listOfAvailableLeagues.put(2016, "England: Championship");
		listOfAvailableLeagues.put(2015, "France: Ligue 1");
		listOfAvailableLeagues.put(2002, "Germany: Bundesliga");
		listOfAvailableLeagues.put(2019, "Italy: Serie A");
		listOfAvailableLeagues.put(2014, "Spain: Primera Division");
		listOfAvailableLeagues.put(2001, "Europe: UEFA Champions League");
		return listOfAvailableLeagues;
	}

	private List<MatchesExternApi> createPojoMatchesExternApiFromOneLeague () throws Exception {
		Map<Integer, String> leagues = createLeagueObjects();
		List<MatchesExternApi> listOfMatchesExternalApi = new ArrayList<>();
			for(Integer leagueId: leagues.keySet()) {
				/*String json = parseJsonToPojo.getJsonFromUrl(parseJsonToPojo.createUrlToGetJson(leagueId,5));
				MatchesExternApi matchesExternApi = parseJsonToPojo.createMatchesExternalApi(json);	*/

				MatchesExternApi matchesExternApi = parseJsonToPojo.createMatchesExternalApi(parseJsonToPojo.createUrlToGetJson(leagueId,5));
				listOfMatchesExternalApi.add(matchesExternApi);
			}
				return listOfMatchesExternalApi;
	}

	
//	@Scheduled(cron = "0 */2 * * * *") //getting all information about match from today to next 7 days
	private void saveGameDetailsToDatabaseOnePerDay() throws Exception {
		List<MatchesExternApi> listExternApi = createPojoMatchesExternApiFromOneLeague();
		listExternApi.forEach( externMatch ->{
			List<Game> listOfGameRepository = parseJsonToPojo.getGameFromMatchesExternalApi(externMatch);
			gameRepository.saveAll(listOfGameRepository);
			System.out.println("Getting ALL information about match TIME: " + Calendar.getInstance().getTime());
		});
	}

	@Scheduled(cron = "0 */3 * * * *") //getting only matchId, status, winner from today
	private void saveGameToDatabaseEveryHalfAnHour() throws Exception {
		List<MatchesExternApi> listExternApi = createPojoMatchesExternApiFromOneLeague();	
		listExternApi.forEach( externMatch ->{
			List<Game> listOfGameRepository = parseJsonToPojo.getScoreValueMatchesFromMatchesExternApi(externMatch);
			gameRepository.saveAll(listOfGameRepository);
			System.out.println("Getting SCORE AND ID about match TIME: " + Calendar.getInstance().getTime());
		});
	}

}
