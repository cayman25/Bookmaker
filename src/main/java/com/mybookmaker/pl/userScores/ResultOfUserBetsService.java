package com.mybookmaker.pl.userScores;

import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.model.entity.UserBets;
import com.mybookmaker.pl.model.enums.TypeScore;
import com.mybookmaker.pl.repository.GameRepository;
import com.mybookmaker.pl.repository.UserBetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultOfUserBetsService {

    @Autowired
    UserBetsRepository userBetsRepository;

    @Autowired
    GameRepository gameRepository;

    @Scheduled(cron = "*/30 * * * * *")
    public void test(){
        System.out.println("test");
        List<Game> notVeryfiedGame = gameRepository.getFinishedAndNotVeryfiedGame();
       System.out.println(notVeryfiedGame.get(0).getMatchID());
        notVeryfiedGame.forEach(game ->{
            System.out.println(game.getMatchID());
            List<UserBets> listOfBets= userBetsRepository.getListOfMatchByMatchID(game.getMatchID());
            List<UserBets> userBets;
                    userBets = listOfBets.stream().filter(bet -> bet.getScore().toString().equals(game.getWinner())).collect(Collectors.toList());
                    userBets.forEach(bets -> bets.setScore(TypeScore.WIN));
                    userBetsRepository.saveAll(userBets);
                    userBets = listOfBets.stream().filter(bet -> bet.getScore().toString().equals(game.getWinner())).collect(Collectors.toList());
                    userBets.forEach(bets -> bets.setScore(TypeScore.LOSE));
                    userBetsRepository.saveAll(userBets);
        });
    }
}
