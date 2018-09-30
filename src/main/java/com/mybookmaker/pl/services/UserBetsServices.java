package com.mybookmaker.pl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mybookmaker.pl.api.DateValidation;
import com.mybookmaker.pl.model.entity.UserBets;
import com.mybookmaker.pl.model.dto.UserBetsDTO;
import com.mybookmaker.pl.repository.UserBetsRepository;
import org.springframework.stereotype.Service;

@Service
public class UserBetsServices {
	
	@Autowired
	UserBetsRepository userBetsRepository;
	
	public void saveListOfUserBets (List<UserBets> bets) {
		
		bets.forEach(betList -> betList.setDateOfBet(DateValidation.getTodayWithTime()));
		bets.forEach(oneBet -> {
				int matchId = oneBet.getMatchID().getMatchId();
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
