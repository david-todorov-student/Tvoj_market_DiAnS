package mk.ukim.finki.dians.tvoj_market.model;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    private double longitude;

    @NonNull
    private double latitude;

    private String name;

    private String address;

    private String openingHours;

    private String webSite;

    private String phoneNumber;

    public Market() {
    }

    public Market(double longitude, double latitude, String name, String address, String openingHours, String webSite, String phoneNumber) {
        this.id = (long) (Math.random() * 1000);
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.openingHours = openingHours;
        this.webSite = webSite;
        this.phoneNumber = phoneNumber;
    }

    public LocalTime getOpeningHour(){
        String[] parts = this.openingHours.split("-");
        return LocalTime.parse(parts[0].trim());
    }

    public LocalTime getClosingHour(){
        String[] parts = this.openingHours.split("-");
        return LocalTime.parse(parts[1].trim());
    }
}
