package com.mybookmaker.pl.model.entity;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.mybookmaker.pl.model.enums.TypeScore;
import com.mybookmaker.pl.model.enums.TypeBet;

@Entity
@Table
public class UserBets {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int betID;
	private int userID;
	//@Fetch(FetchMode.JOIN)
	@JoinColumn(name="matchID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Game matchID;
	@Enumerated(EnumType.STRING)
	@Column(length=9)
	private TypeBet userBet;
	private String dateOfBet;
	@Enumerated(EnumType.STRING)
	private TypeScore scoreBet;

	public UserBets() {
	}
	public int getBetId() {
		return betID;
	}
	public void setBetId(int betId) {
		this.betID = betId;
	}
	public int getUserId() {
		return userID;
	}
	public void setUserId(int userId) {
		this.userID = userId;
	}
	public Game getMatchID() {
		return matchID;
	}
	public void setMatchID(Game matchID) {
		this.matchID = matchID;
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
	public TypeScore getScore() {
		return scoreBet;
	}
	public void setScore(TypeScore score) {
		this.scoreBet = score;
	}

	public UserBets(int betId, int userId, Game matchID, TypeBet userBet, String dateOfBet, TypeScore score) {
		this.betID = betId;
		this.userID = userId;
		this.matchID = matchID;
		this.userBet = userBet;
		this.dateOfBet = dateOfBet;
		this.scoreBet = score;
	}
	
	
}