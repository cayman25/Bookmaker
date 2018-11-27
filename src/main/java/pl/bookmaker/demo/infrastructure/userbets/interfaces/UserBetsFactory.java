package pl.bookmaker.demo.infrastructure.userbets.interfaces;

import pl.bookmaker.demo.domain.model.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.entity.UserBets;

public interface UserBetsFactory {

  public UserBets createForRegistration(UserBetsDtoRegister dto);
}
