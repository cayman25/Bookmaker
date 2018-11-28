package pl.bookmaker.demo.infrastructure.userbets.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDto;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.application.userBets.facade.UserBetsFacade;
import pl.bookmaker.demo.domain.model.entity.UserBets;
import pl.bookmaker.demo.infrastructure.userbets.factory.UserBetsFactory;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsMapper;
import pl.bookmaker.demo.repository.UserBetsRepository;
import pl.bookmaker.demo.service.userbets.service.UserBetsService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public UserBetsDto updateBet(UserBetsDtoRegister bet) {
        UserBets userBets = userBetsService.getUserBetsByMatchIdAndUserId(bet);
        userBetsMapper.updateUserBets(bet, userBets);
        userBetsRepository.save(userBets);
        return userBetsMapper.mapToUserBets(userBets);
    }

    @Override
    public List<UserBetsDto> registerBets(List<UserBetsDtoRegister> bets) {
        List<UserBets> userBets = bets.stream().map(bet -> userBetsFactory.createForRegistration(bet)).collect(Collectors.toList());
        userBetsRepository.saveAll(userBets);
        return userBets.stream().map(bet -> userBetsMapper.mapToUserBets(bet)).collect(Collectors.toList());
    }
}
