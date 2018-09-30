package com.mybookmaker.pl.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybookmaker.pl.model.entity.Competition;
import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.model.entity.Team;
import com.mybookmaker.pl.model.externalApi.Matches;
import com.mybookmaker.pl.model.externalApi.MatchesExternApi;
import org.springframework.web.client.RestTemplate;

@Service 
@PropertySource(value = {"classpath:application.properties"})
public class ParseJsonToPojo {
	
	@Autowired
	DateValidation dateValidation;
	
	@Value("${api.X-Auth-Token}")
	private String apiAuthToken;
	
	protected String createUrlToGetJson(int leagueId, int dateTo) {
		String url = "http://api.football-data.org/v2/competitions/" + leagueId + "/matches?" + 
						"dateFrom="	+ DateValidation.getTodayWithAddOrSubstract(0) + //0 means days to today
						"&dateTo=" + DateValidation.getTodayWithAddOrSubstract(dateTo);
		return url;
	}
	
	/*protected String getJsonFromUrl(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Auth-Token", apiAuthToken);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code : " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		}
		return null;
		
		*//*Rest restTemplate = new Rest();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.add("X-Auth-Token", apiAuthToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters",header);
		
		String json = restTemplate.exchange(url,HttpMethod.GET, entity, String.class); 
		
		return json.toS;*//*
	}
	
	//MatchesExternal is main class from Json
	protected MatchesExternApi createMatchesExternalApi(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		MatchesExternApi matchesExternApi = mapper.readValue(json, MatchesExternApi.class);
			return matchesExternApi;
	}*/

	protected MatchesExternApi createMatchesExternalApi(String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token","bf5c0f84e2214a43978af5da8e98d878");
		HttpEntity<String> entity = new HttpEntity<>("paramters",headers);

		RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);

		ResponseEntity<MatchesExternApi> list = restTemplate.exchange(
				url,
				HttpMethod.GET,
				entity,
				MatchesExternApi.class);

		return list.getBody();
	}
	protected List<Game> getGameFromMatchesExternalApi(MatchesExternApi matchesExternApi){
		List <Matches> matches = matchesExternApi.getMatches();
		Competition competition = new Competition(matchesExternApi.getCompetition().getId(),
											matchesExternApi.getCompetition().getName());
		List<Game> games = matches.stream()
			.map(p-> 
				new Game(
					p.getId(),
					competition,
					DateValidation.getDateFromJson(p.getUtcDate()),
					DateValidation.getTimeFromJson(p.getUtcDate()),
					p.getStatus(),
					new Team(p.getHomeTeam().getId(), p.getHomeTeam().getName()),
					new Team(p.getAwayTeam().getId(), p.getAwayTeam().getName()),
					p.getScore().getWinner()))
					.collect(Collectors.toList());
			return games;
	}
	
	protected List<Game> getScoreValueMatchesFromMatchesExternApi(MatchesExternApi matchesExternApi){
		List <Matches> matches = matchesExternApi.getMatches();
		List<Game> games = new ArrayList<>();
	
			matches.forEach(match -> {
				Game game=new Game();
				game.setMatchId(match.getId());
				game.setStatusMatch(match.getStatus());
				game.setWinner(match.getScore().getWinner());
				games.add(game);
			});
			return games;
	}
	
}
