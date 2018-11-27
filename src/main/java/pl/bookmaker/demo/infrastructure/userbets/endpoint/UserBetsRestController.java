package pl.bookmaker.demo.infrastructure.userbets.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDto;
import pl.bookmaker.demo.application.userBets.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.application.userBets.facade.UserBetsFacade;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserBetsRestController {
	
	private final UserBetsFacade userBetsFacade;

	@RequestMapping(value="/matches" , method = RequestMethod.POST)
	public UserBetsDto postOneUserBet(@RequestBody UserBetsDtoRegister bet) {
		return userBetsFacade.registerBet(bet);
	}

	@RequestMapping(value="/matches" , method = RequestMethod.PUT)
	public UserBetsDto putOneUserBet(@RequestBody UserBetsDtoRegister bet) {
		return userBetsFacade.updateBet(bet);
	}

	@RequestMapping(value="/matches" , method = RequestMethod.POST)
	public List<UserBetsDto> postUserBets(@RequestBody List<UserBetsDtoRegister> bets){
		return userBetsFacade.registerBets(bets);
	}

/*
	@RequestMapping(value="/matches" , method = RequestMethod.POST)
	public List<UserBetsDto> putUserBets(@RequestBody List<UserBetsDtoRegister> bets){
		return userBetsFacade.updateBets(bets);
*/


/*	@GetMapping(value="/bets", params= "user")
	public List<UserBetsDto> getUserBets(
								@RequestParam(value="user")int userID){
		return userBetsServices.getBetsOfUser(userID);
	}*/

}

