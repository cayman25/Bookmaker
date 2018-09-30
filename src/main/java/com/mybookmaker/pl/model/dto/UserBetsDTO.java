package com.mybookmaker.pl.model.dto;

import com.mybookmaker.pl.model.enums.TypeBet;

public class UserBetsDTO {

	
	private int betID;
	private int gameID;
	private String homeTeam;
	private String awayTeam;
	private TypeBet userBet;
	private String dateOfBet;

	public int getBetID() {
		return betID;
	}

	public void setBetID(int betID) {
		this.betID = betID;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public TypeBet getUserBet() {
		return userBet;
	}

	public void setUserBet(TypeBet userBet) {
		this.userBet = userBet;
	}

	public String getDateOfBet() {
		return dateOfBet;
	}

	public void setDateOfBet(String dateOfBet) {
		this.dateOfBet = dateOfBet;
	}

	public UserBetsDTO(int betID, int gameID, String homeTeam, String awayTeam, TypeBet userBet, String dateOfBet) {
		this.betID = betID;
		this.gameID = gameID;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.userBet = userBet;
		this.dateOfBet = dateOfBet;
	}
}
