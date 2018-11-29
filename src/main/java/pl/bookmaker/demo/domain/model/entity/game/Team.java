package pl.bookmaker.demo.domain.model.entity.game;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table
public class Team {
	
	@Id
	private int teamId;
	private String teamName;

	@OneToMany(mappedBy = "awayTeam")
	private List<Game> gamesLikeAway;

	@OneToMany(mappedBy = "homeTeam")
	private List<Game> gamesLikeHome;
}
