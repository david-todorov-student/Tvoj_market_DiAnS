package mk.ukim.finki.dians.tvoj_market.model;


import lombok.Data;
import lombok.NonNull;
import org.aspectj.apache.bcel.classfile.Module;

import java.time.ZonedDateTime;

@Data
public class Market {
    @NonNull private Long id;
    @NonNull private double longitude;
    @NonNull private double latitude;
    private String name;
    private String address;
    private OpeningHours openingHours;
    private String webSite;
    private String phoneNumber;

    public Market() {
    }

    public Market(double longitude, double latitude, String name, String address, OpeningHours openingHours, String webSite, String phoneNumber) {
        this.id = (long) (Math.random() * 1000);
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.openingHours = openingHours;
        this.webSite = webSite;
        this.phoneNumber = phoneNumber;
    }

}
