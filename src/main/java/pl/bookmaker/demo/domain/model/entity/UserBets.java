package pl.bookmaker.demo.domain.model.entity;

import lombok.*;
import pl.bookmaker.demo.domain.model.enums.TypeBet;
import pl.bookmaker.demo.domain.model.enums.TypeScore;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
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