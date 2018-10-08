package com.mybookmaker.pl;

import com.mybookmaker.pl.model.externalApi.MatchesExternalApi;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Rest {

    public static void main(String[] args){

            Map<Integer, String> listOfAvailableLeagues = new HashMap<Integer, String>();
            listOfAvailableLeagues.put(2021, "England: Premier League");
            listOfAvailableLeagues.put(2016, "England: Championship");
            listOfAvailableLeagues.put(2015, "France: Ligue 1");
            listOfAvailableLeagues.put(2002, "Germany: Bundesliga");
            listOfAvailableLeagues.put(2019, "Italy: Serie A");
            listOfAvailableLeagues.put(2014, "Spain: Primera Division");
            listOfAvailableLeagues.put(2001, "Europe: UEFA Champions League");

            for(int i : listOfAvailableLeagues.keySet()){
                System.out.println(i);
            }
    }
}