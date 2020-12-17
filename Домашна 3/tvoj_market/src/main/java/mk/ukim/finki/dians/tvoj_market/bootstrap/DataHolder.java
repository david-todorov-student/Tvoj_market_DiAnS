package mk.ukim.finki.dians.tvoj_market.bootstrap;


import lombok.Getter;
import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.OpeningHours;
import mk.ukim.finki.dians.tvoj_market.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Market> markets = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {

        users.add(new User("andrej.s", "as", "Andrej", "Skenderski"));
        markets.add(new Market(21.3922837, 42.0048803, "Ramstore", "Љубљанска Skopje",
                new OpeningHours(LocalTime.parse("08:00"), LocalTime.parse("22:00")), "http://ramstore.com.mk"));


    }

}
