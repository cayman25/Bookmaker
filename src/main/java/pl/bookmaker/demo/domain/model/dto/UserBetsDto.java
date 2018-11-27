package pl.bookmaker.demo.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.bookmaker.demo.domain.model.entity.Game;
import pl.bookmaker.demo.domain.model.entity.User;
import pl.bookmaker.demo.domain.model.enums.TypeBet;

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
