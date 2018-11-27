package pl.bookmaker.demo.infrastructure.userbets.factory;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.domain.model.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.entity.UserBets;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsFactory;
import pl.bookmaker.demo.repository.GameRepository;
import pl.bookmaker.demo.repository.UserRepository;

@Component
public class UserBetsFactoryImpl implements UserBetsFactory {

  @Override
  public UserBets createForRegistration(UserBetsDtoRegister dto){
    return UserBets.builder().
            user(dto.getUserId()).
            game(dto.getMatchId()).
            userBet(dto.getUserBet()).
            dateOfBet(dto.getDateOfBet()).
            build();
  }
}
