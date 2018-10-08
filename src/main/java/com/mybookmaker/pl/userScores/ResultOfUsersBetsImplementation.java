package com.mybookmaker.pl.userScores;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

public class ResultOfUsersBetsImplementation implements ResultOfUsersBets{

    @Override
    //@Scheduled(cron = "*/30 * * * * *")
    public void setUsersBetsResult() {
        ResultOfUserBetsService service = new ResultOfUserBetsService();
        service.test();
    }
}
