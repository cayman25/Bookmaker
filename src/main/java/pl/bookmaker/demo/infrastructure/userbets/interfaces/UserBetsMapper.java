package pl.bookmaker.demo.infrastructure.userbets.interfaces;

import pl.bookmaker.demo.domain.model.dto.UserBetsDto;
import pl.bookmaker.demo.domain.model.entity.UserBets;

public interface UserBetsMapper {
  UserBetsDto mapToUserBets(UserBets bet);
}
