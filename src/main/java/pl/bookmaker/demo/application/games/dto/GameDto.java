package pl.bookmaker.demo.application.games.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GameDto {

	private int id;
	private int competitionID;
	private String homeName;
	private String awayName;
	private String date;
	private String startTime;
	private String status;
	private String score;
}
