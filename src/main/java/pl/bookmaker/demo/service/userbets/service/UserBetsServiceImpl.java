package pl.bookmaker.demo.service.userbets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;

import pl.bookmaker.demo.domain.model.entity.bets.UserBets;
import pl.bookmaker.demo.repository.UserBetsRepository;

@Service
@AllArgsConstructor
public class UserBetsServiceImpl implements UserBetsService {
	
	private final UserBetsRepository userBetsRepository;

	@Override
	public UserBets getUserBetsByMatchIdAndUserId(UserBetsDtoRegister bet) {
		return userBetsRepository.findByUserUserIdAndGameMatchID(bet.getUserId().getUserId(),bet.getMatchId().getMatchID());
	}
}
