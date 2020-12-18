package mk.ukim.finki.dians.tvoj_market.model;


import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Data
@Entity
public class OpeningHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opening")
    private LocalTime start;

    @Column(name = "closing")
    private LocalTime end;

    public OpeningHours() {
    }

    public OpeningHours(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d - %02d:%02d", start.getHour(), start.getMinute(), end.getHour(), end.getMinute());
    }
}
