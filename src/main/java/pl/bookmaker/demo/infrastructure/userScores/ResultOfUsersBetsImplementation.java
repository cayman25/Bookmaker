//package pl.bookmaker.demo.infrastructure.userScores;
//
//import Game;
//import UserBets;
//import TypeScore;
//import pl.bookmaker.demo.repository.GameRepository;
//import pl.bookmaker.demo.repository.UserBetsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class ResultOfUsersBetsImplementation implements ResultOfUsersBets{
//
//    private final UserBetsRepository userBetsRepository;
//    private final GameRepository gameRepository;
//
//    @Autowired
//    public ResultOfUsersBetsImplementation(GameRepository gameRepo, UserBetsRepository userRepo){
//        this.gameRepository=gameRepo;
//        this.userBetsRepository=userRepo;
//    }
//
//    @Override
//   // @Scheduled(cron = "*/30 * * * * *")
//    public void setUsersBetsResult() {
//        List<Game> notVerifiedGames = gameRepository.getFinishedAndNotVeryfiedGame();
//        notVerifiedGames.forEach(game -> {
//            Set<UserBets> listOfBets = userBetsRepository.findByMatchID_MatchID(game.getMatchID());
//            listOfBets.forEach(bet -> {
//                if (bet.getUserBet().toString().equals(game.getWinner()))
//                    bet.setScore(TypeScore.WIN);
//                else
//                    bet.setScore(TypeScore.LOSE);
//            });
//            userBetsRepository.saveAll(listOfBets);
//            game.setVerifiedStatus(true);
//            gameRepository.saveAll(notVerifiedGames);
//        });
//    }
//}
