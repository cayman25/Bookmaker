package pl.bookmaker.demo.infrastructure.bets.interfaces;

import pl.bookmaker.demo.application.userBets.dto.UserBetsDto;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.bets.UserBets;

public interface UserBetsMapper {

    public UserBetsDto mapToUserBets(UserBets bet);

    public void updateUserBets(UserBetsDtoRegister bet, UserBets userBets);
}
