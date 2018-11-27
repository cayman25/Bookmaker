package pl.bookmaker.demo.infrastructure.userbets.interfaces;

import pl.bookmaker.demo.domain.model.dto.UserBetsDto;
import pl.bookmaker.demo.domain.model.dto.UserBetsDtoRegister;

public interface UserBetsFacade {

  public UserBetsDto registerBet(UserBetsDtoRegister bet);
}
