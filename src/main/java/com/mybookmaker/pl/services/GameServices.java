package com.mybookmaker.pl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybookmaker.pl.api.DateValidation;
import com.mybookmaker.pl.model.dto.GameDto;
import com.mybookmaker.pl.repository.GameRepository;

@Service
public class GameServices {

	@Autowired
	GameRepository gameRepository;
	
	public List<GameDto> getMatchesFromToday(){
		return gameRepository.getMatchesByDate(DateValidation.getToday());
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
