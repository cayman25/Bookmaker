package com.mybookmaker.pl.services;

import com.mybookmaker.pl.converters.DateParser;
import com.mybookmaker.pl.model.dto.UserBetsDTO;
import com.mybookmaker.pl.model.entity.UserBets;
import com.mybookmaker.pl.repository.UserBetsRepository;
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
