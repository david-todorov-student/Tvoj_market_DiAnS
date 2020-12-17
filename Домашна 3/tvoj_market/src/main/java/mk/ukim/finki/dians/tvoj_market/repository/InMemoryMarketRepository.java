package mk.ukim.finki.dians.tvoj_market.repository;


import mk.ukim.finki.dians.tvoj_market.bootstrap.DataHolder;
import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.OpeningHours;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryMarketRepository {
    public List<Market> findAll() {
        return DataHolder.markets;
    }

    public Optional<Market> findById(Long id) {
        return DataHolder.markets.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public List<Market> findByName(String name) {
        return DataHolder.markets.stream()
                .filter(market -> market.getName().equals(name))
                .collect(Collectors.toList());
    }


    public void deleteById(Long id) {
        DataHolder.markets.removeIf(i -> i.getId().equals(id));
    }


    public Market save(double longitude, double latitude, String name, String address, OpeningHours openingHours, String webSite, String phoneNumber) {
        DataHolder.markets.removeIf(market -> market.getLongitude() == longitude && market.getLatitude() == latitude);
        Market market = new Market(longitude, latitude, name, address, openingHours, webSite, phoneNumber);
        DataHolder.markets.add(market);
        return market;
    }

    public Optional<List<Market>> findOpened() {
        return Optional.of(DataHolder.markets.stream()
                .filter(market -> market.getOpeningHours().getStart().isBefore(LocalTime.now())
                        && market.getOpeningHours().getEnd().isAfter(LocalTime.now()))
                .collect(Collectors.toList()));
    }


}
