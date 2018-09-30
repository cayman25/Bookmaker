package com.mybookmaker.pl.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Competition {

	@Id
	private int competitionID;
	private String competitionName;
	
	@OneToMany(mappedBy = "competition",
			   cascade= {CascadeType.MERGE})
	private List <Game> games = new ArrayList<Game>();
	
	
	public Competition() {
	}
	
	public Competition(int competitionId, String competitionName) {
		this.competitionID = competitionId;
		this.competitionName = competitionName;
	}

	public int getCompetitionId() {
		return competitionID;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionID = competitionId;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public List<Game> getGames() {
		return games;
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}

}
