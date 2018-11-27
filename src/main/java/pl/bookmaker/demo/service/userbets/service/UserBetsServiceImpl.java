package pl.bookmaker.demo.service.userbets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.domain.model.entity.UserBets;
import pl.bookmaker.demo.repository.UserBetsRepository;

@Service
@AllArgsConstructor
public class UserBetsServiceImpl implements UserBetsService {
	
	private final UserBetsRepository userBetsRepository;

	@Override
	public UserBets getUserBetsByMatchIdAndUserId(UserBetsDtoRegister bet) {
		return userBetsRepository.findByUserUserIdAndGame_MatchID(bet.getUserId().getUserId(),bet.getMatchId().getMatchID());
	}

	/*
	public void saveListOfUserBets (List<UserBets> bets) {
		
		bets.forEach(betList -> betList.setDateOfBet(DateParser.getTodayWithTime()));
		bets.forEach(oneBet -> {
				int game = oneBet.getMatchID().getMatchID();
				int user = oneBet.getUser();
				Integer betId = userBetsRepository.checkIfThisBetIsExist(user, game);
				
				if(betId==null) {
					userBetsRepository.save(oneBet);
					System.out.println("Succesfull insert");
				}
				else {
					oneBet.setBetId(betId);
					userBetsRepository.save(oneBet);
					System.out.println("Succesfull update");
				}
		});	
	}

	public List <UserBetsDto> getBetsOfUser(int userID){
		return userBetsRepository.getAllUserBets(userID);
	}*/
}
