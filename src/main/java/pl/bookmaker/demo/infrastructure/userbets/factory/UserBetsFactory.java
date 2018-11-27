package pl.bookmaker.demo.infrastructure.userbets.factory;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.entity.UserBets;

@Component
public class UserBetsFactory{

  public UserBets createForRegistration(UserBetsDtoRegister dto){
    return UserBets.builder().
            user(dto.getUserId()).
            game(dto.getMatchId()).
            userBet(dto.getUserBet()).
            dateOfBet(dto.getDateOfBet()).
            build();
  }
}
