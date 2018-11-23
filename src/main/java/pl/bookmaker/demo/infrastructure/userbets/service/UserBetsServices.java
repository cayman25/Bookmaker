/*
package pl.bookmaker.demo.services;

import pl.bookmaker.demo.converters.DateParser;
import UserBetsDTO;
import UserBets;
import pl.bookmaker.demo.repository.UserBetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBetsServices {
	
	private final UserBetsRepository userBetsRepository;

	@Autowired
	public UserBetsServices(UserBetsRepository userRepo){
		this.userBetsRepository=userRepo;
	}

	public void saveListOfUserBets (List<UserBets> bets) {
		
		bets.forEach(betList -> betList.setDateOfBet(DateParser.getTodayWithTime()));
		bets.forEach(oneBet -> {
				int matchId = oneBet.getMatchID().getMatchID();
				int userId = oneBet.getUserId();
				Integer betId = userBetsRepository.checkIfThisBetIsExist(userId, matchId);
				
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

	public List <UserBetsDTO> getBetsOfUser(int userID){
		return userBetsRepository.getAllUserBets(userID);
	}
}
*/
