package pl.bookmaker.demo.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
