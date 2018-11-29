package pl.bookmaker.demo.infrastructure.bets.factory;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.converters.DateParser;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.bets.UserBets;

@Component
public class UserBetsFactory {

    public UserBets createForRegistration(UserBetsDtoRegister dto) {
        return UserBets.builder().
                user(dto.getUserId()).
                game(dto.getMatchId()).
                userBet(dto.getUserBet()).
                dateOfBet(DateParser.getTodayWithTime()).
                build();
    }
}
