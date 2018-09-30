package com.mybookmaker.pl.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table
public class Game {

	@Id
	private int matchID;

	@JoinColumn(name = "Competition")
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade=CascadeType.MERGE,
				fetch = FetchType.LAZY)
	private Competition competition;
	private String dateMatch;
	private String startTime;
	private String statusMatch;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade=CascadeType.MERGE,
				fetch = FetchType.LAZY)
	private Team homeTeam;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade=CascadeType.MERGE,
				fetch = FetchType.LAZY)
	private Team awayTeam;
	private String winner;
	@OneToMany(cascade=CascadeType.MERGE,
				mappedBy = "matchID")	
	private List<UserBets> listBets = new ArrayList<UserBets>();
	
	public Game() {
	}

	public int getMatchId() {
		return matchID;
	}

	public void setMatchId(int matchId) {
		this.matchID = matchId;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public String getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(String dateMatch) {
		this.dateMatch = dateMatch;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getStatusMatch() {
		return statusMatch;
	}

	public void setStatusMatch(String statusMatch) {
		this.statusMatch = statusMatch;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Game(int matchId, Competition competition, String dateMatch, String startTime, String statusMatch,
			Team homeTeam, Team awayTeam, String winner) {
		this.matchID = matchId;
		this.competition = competition;
		this.dateMatch = dateMatch;
		this.startTime = startTime;
		this.statusMatch = statusMatch;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.winner = winner;
	}
}
