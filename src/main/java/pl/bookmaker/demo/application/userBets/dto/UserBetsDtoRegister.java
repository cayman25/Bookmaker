package pl.bookmaker.demo.application.userBets.dto;

import lombok.Data;
import pl.bookmaker.demo.domain.model.entity.bets.enums.TypeBet;
import pl.bookmaker.demo.domain.model.entity.game.Game;
import pl.bookmaker.demo.domain.model.entity.user.User;

@Data
public class UserBetsDtoRegister {

	private User userId;
	private Game matchId;
	private TypeBet userBet;
	private String dateOfBet;

}
