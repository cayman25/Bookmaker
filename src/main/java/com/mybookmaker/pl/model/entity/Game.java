package com.mybookmaker.pl.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Proxy;

@Entity
@Table
@Proxy(lazy = true)
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

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
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
