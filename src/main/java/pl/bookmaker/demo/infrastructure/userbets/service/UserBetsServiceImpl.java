package pl.bookmaker.demo.infrastructure.userbets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsService;
import pl.bookmaker.demo.repository.UserBetsRepository;

@Service
@AllArgsConstructor
public class UserBetsServiceImpl implements UserBetsService {
	
	private final UserBetsRepository userBetsRepository;


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
