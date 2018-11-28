package pl.bookmaker.demo.domain.model.entity.game;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table
public class Competition {

	@Id
	private int competitionID;
	private String competitionName;
	@OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
	private Set<Game> games = new HashSet<>();
}
