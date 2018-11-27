package pl.bookmaker.demo.service.userbets.service;

import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.entity.UserBets;

public interface UserBetsService {
    public UserBets getUserBetsByMatchIdAndUserId(UserBetsDtoRegister bet);
}
