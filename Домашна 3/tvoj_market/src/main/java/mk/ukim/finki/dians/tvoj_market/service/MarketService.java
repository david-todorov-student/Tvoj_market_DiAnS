package mk.ukim.finki.dians.tvoj_market.service;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.OpeningHours;

import java.util.List;

public interface MarketService {
    public List<Market> findAll();
    public Market findById(Long id);
    public List<Market> findByName(String name);
    public void deleteById(Long id);
    public Market save(double longitude, double latitude, String name, String address, OpeningHours openingHours, String webSite, String phoneNumber);
    public List<Market> findOpened();

}
