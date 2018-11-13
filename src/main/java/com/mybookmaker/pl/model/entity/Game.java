package com.mybookmaker.pl.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Game {

	@Id
	private int matchID;

	@JoinColumn(name = "Competition")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Competition competition;
	private String dateMatch;
	private String startTime;
	private String statusMatch;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Team homeTeam;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Team awayTeam;
	private String winner;
	@OneToMany(mappedBy = "matchID")
	private Set<UserBets> listBets;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean verifiedStatus;
	
	public Game() {
	}

	public Game(int matchID, Competition competition, String dateMatch, String startTime, String statusMatch, Team homeTeam, Team awayTeam, String winner, Set<UserBets> listBets, boolean verifiedStatus) {
		this.matchID = matchID;
		this.competition = competition;
		this.dateMatch = dateMatch;
		this.startTime = startTime;
		this.statusMatch = statusMatch;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.winner = winner;
		this.listBets = listBets;
		this.verifiedStatus = verifiedStatus;
	}

	public Game(int matchID, Competition competition, String dateMatch, String startTime, String statusMatch, Team homeTeam, Team awayTeam, String winner) {
		this.matchID = matchID;
		this.competition = competition;
		this.dateMatch = dateMatch;
		this.startTime = startTime;
		this.statusMatch = statusMatch;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.winner = winner;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
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

	public Set<UserBets> getListBets() {
		return listBets;
	}

	public void setListBets(Set<UserBets> listBets) {
		this.listBets = listBets;
	}

	public boolean isVerifiedStatus() {
		return verifiedStatus;
	}

	public void setVerifiedStatus(boolean verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}
}
