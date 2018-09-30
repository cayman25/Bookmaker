package com.mybookmaker.pl;

import org.springframework.expression.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybookmaker.pl.model.externalApi.MatchesExternApi;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Rest {

    public static void main(String[] args) throws ParseException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token","bf5c0f84e2214a43978af5da8e98d878");
        HttpEntity<String> entity = new HttpEntity<>("paramters",headers);

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        restTemplate.getMessageConverters().add(converter);

        ResponseEntity<MatchesExternApi> list = restTemplate.exchange(
                "http://api.football-data.org/v2/competitions/2016/matches?dateFrom=2018-09-02&dateTo=2018-09-15",
                HttpMethod.GET,
                entity,
                MatchesExternApi.class);

        System.out.println(list.toString());
        System.out.println(list.getBody().getMatches().get(0).getAwayTeam().getName());



    }
}