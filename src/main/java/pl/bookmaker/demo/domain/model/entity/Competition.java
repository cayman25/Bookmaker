package pl.bookmaker.demo.domain.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Competition {

	@Id
	private int competitionID;
	private String competitionName;
	
	@OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
	private Set<Game> games = new HashSet<>();
	
	
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

	public Set<Game> getGames() {
		return games;
	}
	
	public void setGames(Set<Game> games) {
		this.games = games;
	}

}
