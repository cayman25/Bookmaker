package com.mybookmaker.pl.userScores;

import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.model.entity.UserBets;
import com.mybookmaker.pl.model.enums.TypeScore;
import com.mybookmaker.pl.repository.GameRepository;
import com.mybookmaker.pl.repository.UserBetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ResultOfUsersBetsImplementation implements ResultOfUsersBets{
    @Autowired
    UserBetsRepository userBetsRepository;

    @Autowired
    GameRepository gameRepository;

    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public void setUsersBetsResult() {
        List<Game> notVerifiedGames = gameRepository.getFinishedAndNotVeryfiedGame();
        notVerifiedGames.forEach(game -> {
            Set<UserBets> listOfBets = userBetsRepository.findByMatchID_MatchID(game.getMatchID());
            listOfBets.forEach(bet -> {
                if (bet.getUserBet().toString().equals(game.getWinner()))
                    bet.setScore(TypeScore.WIN);
                else
                    bet.setScore(TypeScore.LOSE);
            });
            userBetsRepository.saveAll(listOfBets);
            game.setVerifiedStatus(true);
            gameRepository.saveAll(notVerifiedGames);
        });
    }
}
