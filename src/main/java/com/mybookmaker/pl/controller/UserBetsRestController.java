package com.mybookmaker.pl.controller;

import java.util.List;

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
		userBetsServices.saveListOfUserBets(bets);
	}
	
	@GetMapping(value="/bets", params= "user")
	public List <UserBetsDTO> getUserBets(
								@RequestParam(value="user")int userID){
		return userBetsServices.getBetsOfUser(userID);
	}
}
