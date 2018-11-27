package pl.bookmaker.demo.application.userBets.dto;

import lombok.Data;
import pl.bookmaker.demo.domain.model.entity.Game;
import pl.bookmaker.demo.domain.model.entity.User;
import pl.bookmaker.demo.domain.model.enums.TypeBet;

@Data
public class UserBetsDtoRegister {

	private User userId;
	private Game matchId;
	private TypeBet userBet;
	private String dateOfBet;

}
