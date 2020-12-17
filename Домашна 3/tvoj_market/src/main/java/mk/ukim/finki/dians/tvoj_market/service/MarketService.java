package mk.ukim.finki.dians.tvoj_market.service;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.OpeningHours;

import java.util.List;
import java.util.Optional;

public interface MarketService {
    public List<Market> findAll();
    public Optional<Market> findById(Long id);
    public Optional<List<Market>> findByName(String name);
    public void deleteById(Long id);
    public Optional<Market> save(double longitude, double latitude, String name, String address, OpeningHours openingHours, String webSite);
    public Optional<List<Market>> findOpened();

}
