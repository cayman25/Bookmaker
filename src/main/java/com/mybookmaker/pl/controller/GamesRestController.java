package com.mybookmaker.pl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybookmaker.pl.model.dto.GameDto;
import com.mybookmaker.pl.services.GameServices;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GamesRestController {

	@Autowired
	GameServices gameServices; 
	
	@GetMapping(value="/matches")
	public List<GameDto> getAllMatchesToday(){
		
		return gameServices.getMatchesFromToday();
	}
	
	@GetMapping(value="/matches" , params={"date"})
	public List<GameDto> getAllMatchesByDate(
								@RequestParam(value="date") String date){
		return gameServices.getAllMatchesFromDate(date);
	}
	
	@GetMapping(value="/matches" , params={"date","competition"})
	public List<GameDto> getAllMatchesByDate(
								@RequestParam(value="date")String date,
								@RequestParam(value="competition")int competition) {
		return gameServices.getAllMatchesFromDateAndCompetitionID(date, competition);
	}
	
	@GetMapping(value="/matches" , params={"competition"})
	public List<GameDto> getAllMatchesByDate(
								@RequestParam(value="competition")int competition) {
		return gameServices.getAllMatchesFromCompetitionID(competition);
	}
	
}