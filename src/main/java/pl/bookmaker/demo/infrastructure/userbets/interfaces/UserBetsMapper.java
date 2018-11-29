package pl.bookmaker.demo.infrastructure.userbets.interfaces;

import pl.bookmaker.demo.application.userBets.dto.UserBetsDto;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.user.UserBets;

public interface UserBetsMapper {

    public UserBetsDto mapToUserBets(UserBets bet);

    public void updateUserBets(UserBetsDtoRegister bet, UserBets userBets);
}
