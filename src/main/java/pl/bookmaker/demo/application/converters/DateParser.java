package pl.bookmaker.demo.application.converters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateParser {

    public static String getToday() {
        return LocalDate.now().toString();
    }

    public static String getCurrentTime() {
        return LocalTime.now().withNano(0).toString();
    }

    public static String getTodayWithTime() {
        LocalDateTime currentTime = LocalDateTime.now().withNano(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");
        return formatter.format(currentTime);
    }

    public static String getTodayWithAddOrSubtractionOfDay(int numberOfDay) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.plusDays(numberOfDay).toString();
    }

}