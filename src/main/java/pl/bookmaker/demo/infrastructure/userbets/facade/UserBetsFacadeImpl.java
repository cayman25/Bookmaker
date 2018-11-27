package pl.bookmaker.demo.infrastructure.userbets.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.domain.model.dto.UserBetsDto;
import pl.bookmaker.demo.domain.model.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.entity.UserBets;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsFacade;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsFactory;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsMapper;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsService;
import pl.bookmaker.demo.repository.UserBetsRepository;

@AllArgsConstructor
@Service
public class UserBetsFacadeImpl implements UserBetsFacade {

  private final UserBetsRepository userBetsRepository;
  private final UserBetsService userBetsService;
  private final UserBetsMapper userBetsMapper;
  private final UserBetsFactory userBetsFactory;

  @Override
  public UserBetsDto registerBet(UserBetsDtoRegister bet) {
    UserBets userBets = userBetsFactory.createForRegistration(bet);
    userBetsRepository.save(userBets);
    return userBetsMapper.mapToUserBets(userBets);
  }
}
