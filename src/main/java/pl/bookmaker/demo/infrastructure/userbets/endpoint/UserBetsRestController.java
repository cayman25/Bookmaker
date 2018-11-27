package pl.bookmaker.demo.infrastructure.userbets.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bookmaker.demo.domain.model.dto.UserBetsDto;
import pl.bookmaker.demo.domain.model.dto.UserBetsDtoRegister;
import pl.bookmaker.demo.infrastructure.userbets.interfaces.UserBetsFacade;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserBetsRestController {
	
	private final UserBetsFacade userBetsFacade;

	@RequestMapping(value="/matches" , method = RequestMethod.PUT)
	public UserBetsDto saveOneUserBet(@RequestBody UserBetsDtoRegister bet) {
		return userBetsFacade.registerBet(bet);
	}

	@RequestMapping(value="/matches" , method = RequestMethod.POST)
	public UserBetsDto postOneUserBet(@RequestBody UserBetsDtoRegister bet) {
		return userBetsFacade.registerBet(bet);
	}

/*	@GetMapping(value="/bets", params= "user")
	public List<UserBetsDto> getUserBets(
								@RequestParam(value="user")int userID){
		return userBetsServices.getBetsOfUser(userID);
	}*/

}

