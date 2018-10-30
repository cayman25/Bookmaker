package com.mybookmaker.pl.api;

import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.model.externalApi.MatchesExternalApi;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExternalApiFacade {

    private FilterMatches filter = new FilterMatches();

    private Map<Integer, String> createLeagueObjects() {
        Map<Integer, String> listOfAvailableLeagues = new HashMap<Integer, String>();
        listOfAvailableLeagues.put(2021, "England: Premier League");
       /* listOfAvailableLeagues.put(2016, "England: Championship");
        listOfAvailableLeagues.put(2015, "France: Ligue 1");
        listOfAvailableLeagues.put(2002, "Germany: Bundesliga");
        listOfAvailableLeagues.put(2019, "Italy: Serie A");
        listOfAvailableLeagues.put(2014, "Spain: Primera Division");
        listOfAvailableLeagues.put(2001, "Europe: UEFA Champions League");*/
        return listOfAvailableLeagues;
    }


    public List<Game> getOnlyFinishedGames() {
        Map<Integer, String> listOfLeagues = createLeagueObjects();
        List<Game> listOfFinishedGames = new ArrayList<>();

       for (int key : listOfLeagues.keySet()) {
           GettingObjectsFromApi gettingObjectsFromApi = new GettingObjectsFromApi();
           MatchesExternalApi matches = gettingObjectsFromApi.createMatchesExternalApi(key);
           listOfFinishedGames.addAll(filter.getOnlyFinishedMatches(matches));
           System.out.println("Get Finished Game from competition ID: " + key);
       }
            return listOfFinishedGames;
    }

        public List<Game> getOtherGames() {
            Map<Integer, String> listOfLeagues = createLeagueObjects();
            List<Game> listOfAllGames = new ArrayList<>();

            for (int key : listOfLeagues.keySet()) {
                GettingObjectsFromApi gettingObjectsFromApi = new GettingObjectsFromApi();
                MatchesExternalApi matches = gettingObjectsFromApi.createMatchesExternalApi(key);
                listOfAllGames.addAll(filter.getScheduledAndOtherMatches(matches));
                System.out.println("Get ALL Game from competition ID: " + key);
            }
            return listOfAllGames;
        }
    }



