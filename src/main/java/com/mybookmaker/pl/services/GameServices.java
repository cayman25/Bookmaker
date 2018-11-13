package com.mybookmaker.pl.services;

import com.mybookmaker.pl.converters.DateParser;
import com.mybookmaker.pl.model.dto.GameDto;
import com.mybookmaker.pl.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServices {

	private final GameRepository gameRepository;

	@Autowired
	public GameServices(GameRepository gameRepo){
		this.gameRepository = gameRepo;
	}
	
	public List<GameDto> getMatchesFromToday(){
		return gameRepository.getMatchesByDate(DateParser.getToday());
	}
	
	public List<GameDto> getAllMatchesFromDate(String date){
			return gameRepository.getMatchesByDate(date);
	}
	
	public List<GameDto> getAllMatchesFromDateAndCompetitionID(String date, int competition){
		return gameRepository.getMatchesByDateAndCompetition(date, competition);
	}
	
	public List<GameDto> getAllMatchesFromCompetitionID(int competition){
		return gameRepository.getMatchesByCompetition(competition);
	}
	
}
