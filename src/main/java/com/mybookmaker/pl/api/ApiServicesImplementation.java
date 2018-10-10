package com.mybookmaker.pl.api;

import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServicesImplementation implements ApiServices{

    @Autowired
    private GameRepository gameRepository;

    @Override
  // @Scheduled(cron = "* */4 * * * *") //getting all information about match from today to next 7 days
    public void updateFinishedGames() {
        System.out.println("wszystkie mecze");
        ExternalApiFacade facade = new ExternalApiFacade();
        List<Game> list  = facade.getOnlyFinishedGames();
        gameRepository.saveAll(list);
    }

    @Override
   // @Scheduled(cron = "0 */3 * * * *")
    public void insertGames() {
        System.out.println("insert All");
        ExternalApiFacade facade = new ExternalApiFacade();
        List <Game> games = facade.getOtherGames();
        gameRepository.saveAll(games);
    }


}
