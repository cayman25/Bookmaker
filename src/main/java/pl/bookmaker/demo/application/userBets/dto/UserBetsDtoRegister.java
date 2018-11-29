package pl.bookmaker.demo.application.userBets.dto;

import lombok.Data;
import pl.bookmaker.demo.domain.model.game.Game;
import pl.bookmaker.demo.domain.model.user.User;
import pl.bookmaker.demo.domain.model.user.enums.TypeBet;

@Data
public class UserBetsDtoRegister {

    private User userId;
    private Game matchId;
    private TypeBet userBet;
    private String dateOfBet;

}
