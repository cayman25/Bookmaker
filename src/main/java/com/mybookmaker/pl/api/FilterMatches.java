package com.mybookmaker.pl.api;

import com.mybookmaker.pl.model.entity.Competition;
import com.mybookmaker.pl.model.entity.Game;
import com.mybookmaker.pl.model.entity.Team;
import com.mybookmaker.pl.model.externalApi.Matches;
import com.mybookmaker.pl.model.externalApi.MatchesExternalApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMatches {

    public List<Game> getOnlyFinishedMatches(MatchesExternalApi matchesExternalApi){
        List<Matches> matches = matchesExternalApi.getMatches();
        List<Matches> matchesFiltered = matches.stream().filter(match -> match.getStatus().equals("FINISHED")).collect(Collectors.toList());
        Competition competition = new Competition(
                matchesExternalApi.getCompetition().getId(),
                matchesExternalApi.getCompetition().getName());
        List<Game> games = createGameEntity(matchesFiltered, competition);
        games.forEach(game -> game.setVerifiedStatus(true));
        return games;
    }

    public List<Game> getScheduledAndOtherMatches(MatchesExternalApi matchesExternalApi){
        List<Matches> matches = matchesExternalApi.getMatches();
        List<Matches> matchesFiltered = matches.stream().filter(match -> !match.getStatus().equals("FINISHED")).collect(Collectors.toList());
        Competition competition = new Competition(
                matchesExternalApi.getCompetition().getId(),
                matchesExternalApi.getCompetition().getName());
        List<Game> games = createGameEntity(matchesFiltered, competition);
        return games;
    }

    private List<Game> createGameEntity(List<Matches> matchesFiltered, Competition competition) {
        return matchesFiltered.stream()
                .map(p->
                        new Game(
                                p.getId(),
                                competition,
                                DateValidation.getDateFromJson(p.getUtcDate()),
                                DateValidation.getTimeFromJson(p.getUtcDate()),
                                p.getStatus(),
                                new Team(p.getHomeTeam().getId(), p.getHomeTeam().getName()),
                                new Team(p.getAwayTeam().getId(), p.getAwayTeam().getName()),
                                p.getScore().getWinner()))
                .collect(Collectors.toList());
    }
}
