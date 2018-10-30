package com.mybookmaker.pl.api;

import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServicesImplementation implements ApiServices{


    private final GameRepository gameRepository;

    @Autowired
    public ApiServicesImplementation(GameRepository gameRepository){
        this.gameRepository=gameRepository;
    }

    @Override
    @Scheduled(cron = "0 */3 * * * *")//getting all information about match from today to next 7 days
    public void updateFinishedGames() {
        System.out.println("Getting only finished");
        ExternalApiFacade facade = new ExternalApiFacade();
        List<Game> list  = facade.getOnlyFinishedGames();
        gameRepository.saveAll(list);
    }

    @Override
    @Scheduled(cron = "0 0 */1 * * *")
    public void insertGames() {
        System.out.println("Insert ALL games");
        ExternalApiFacade facade = new ExternalApiFacade();
        List <Game> games = facade.getOtherGames();
        gameRepository.saveAll(games);
    }

}
