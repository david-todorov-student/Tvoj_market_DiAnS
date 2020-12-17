package mk.ukim.finki.dians.tvoj_market.model;


import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class OpeningHours {
    private LocalTime start ;
    private LocalTime end ;

    public OpeningHours(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

}
