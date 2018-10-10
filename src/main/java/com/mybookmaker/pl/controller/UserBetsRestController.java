package com.mybookmaker.pl.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.mybookmaker.pl.api.DateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mybookmaker.pl.model.entity.UserBets;
import com.mybookmaker.pl.model.dto.UserBetsDTO;
import com.mybookmaker.pl.services.UserBetsServices;

@RestController
@RequestMapping("/api/user")
public class UserBetsRestController {
	
	@Autowired 
	UserBetsServices userBetsServices;
	
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
