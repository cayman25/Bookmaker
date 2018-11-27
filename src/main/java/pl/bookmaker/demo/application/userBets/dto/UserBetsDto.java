package pl.bookmaker.demo.application.userBets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
/*
@Getter
@Setter
*/
@Data
public class UserBetsDto {

  private int userId;
  private int matchId;
  private String userBet;
  private String dateOfBet;

}
