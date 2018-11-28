package pl.bookmaker.demo.domain.model.entity.bets;

import lombok.*;
import pl.bookmaker.demo.domain.model.entity.bets.enums.TypeBet;
import pl.bookmaker.demo.domain.model.entity.bets.enums.TypeScore;
import pl.bookmaker.demo.domain.model.entity.game.Game;
import pl.bookmaker.demo.domain.model.entity.user.User;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table
@Builder
public class UserBets {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int betId;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@JoinColumn(name="matchID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Game game;
	@Enumerated(EnumType.STRING)
	@Column(length=9)
	private TypeBet userBet;
	private String dateOfBet;
	@Enumerated(EnumType.STRING)
	private TypeScore scoreBet;
}