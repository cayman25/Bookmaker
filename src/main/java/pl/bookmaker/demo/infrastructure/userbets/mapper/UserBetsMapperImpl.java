package pl.bookmaker.demo.infrastructure.userbets.mapper;

import org.springframework.stereotype.Component;
import pl.bookmaker.demo.application.converters.DateParser;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDto;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.entity.UserBets;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsMapper;

@Component
public class UserBetsMapperImpl implements UserBetsMapper {

    @Override
    public UserBetsDto mapToUserBets(UserBets bet) {
        if (bet == null)
            return null;

        return new UserBetsDto(
                bet.getUser().getUserId(),
                bet.getGame().getMatchID(),
                bet.getUserBet().toString(),
                DateParser.getTodayWithTime()
        );
    }

    @Override
    public void updateUserBets(UserBetsDtoRegister bet, UserBets userBets) {
        if (bet != null) {
            userBets.setDateOfBet(DateParser.getTodayWithTime());
            userBets.setUserBet(bet.getUserBet());
        }
    }
}
