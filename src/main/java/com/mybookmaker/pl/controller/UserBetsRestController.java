package com.mybookmaker.pl.controller;

import com.mybookmaker.pl.model.dto.UserBetsDTO;
import com.mybookmaker.pl.model.entity.UserBets;
import com.mybookmaker.pl.services.UserBetsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserBetsRestController {
	
	private final UserBetsServices userBetsServices;

	@Autowired
	public UserBetsRestController (UserBetsServices userBetsServices){
		this.userBetsServices=userBetsServices;
	}

	@PostMapping(value="/matches")
	public void saveOneUserBet(
								@RequestBody List<UserBets> bets) {
/*			bets.forEach(bet ->{
				if(bet.getMatchID().getDateMatch().equals(DateValidation.getToday()) & bet.getMatchID().getStartTime()){


				}
			});*/
		userBetsServices.saveListOfUserBets(bets);
	}
	
	@GetMapping(value="/bets", params= "user")
	public List <UserBetsDTO> getUserBets(
								@RequestParam(value="user")int userID){
		return userBetsServices.getBetsOfUser(userID);
	}
}
