package pl.bookmaker.demo.service.userbets.service;

import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.bets.UserBets;

public interface UserBetsService {
    UserBets getUserBetsByMatchIdAndUserId(UserBetsDtoRegister bet);
}
