package pl.bookmaker.demo.application.userBets.facade;

import pl.bookmaker.demo.application.userBets.dto.UserBetsDto;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;

import java.util.List;

public interface UserBetsFacade {

    UserBetsDto registerBet(UserBetsDtoRegister bet);

    UserBetsDto updateBet(UserBetsDtoRegister bet);

    List<UserBetsDto> registerBets(List<UserBetsDtoRegister> bets);
}
