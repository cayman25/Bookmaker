package pl.bookmaker.demo.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table
@Getter
@Setter
public class Team {
	
	@Id
	private int teamId;
	private String teamName;

	@OneToMany(mappedBy = "awayTeam")
	private List<Game> gamesLikeAway;

	@OneToMany(mappedBy = "homeTeam")
	private List<Game> gamesLikeHome;
}
