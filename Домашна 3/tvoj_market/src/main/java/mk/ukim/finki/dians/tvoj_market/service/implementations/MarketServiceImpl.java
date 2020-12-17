package mk.ukim.finki.dians.tvoj_market.service.implementations;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.OpeningHours;
import mk.ukim.finki.dians.tvoj_market.repository.InMemoryMarketRepository;
import mk.ukim.finki.dians.tvoj_market.service.MarketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketServiceImpl implements MarketService {
    private final InMemoryMarketRepository inMemoryMarketRepository;

    public MarketServiceImpl(InMemoryMarketRepository inMemoryMarketRepository) {
        this.inMemoryMarketRepository = inMemoryMarketRepository;
    }

    @Override
    public List<Market> findAll() {
        return this.inMemoryMarketRepository.findAll();
    }

    @Override
    public Optional<Market> findById(Long id) {
        return this.inMemoryMarketRepository.findById(id);
    }

    @Override
    public Optional<List<Market>> findByName(String name) {
        return this.inMemoryMarketRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        this.inMemoryMarketRepository.deleteById(id);
    }

    @Override
    public Optional<Market> save(double longitude, double latitude, String name, String address, OpeningHours openingHours, String webSite) {
        return this.inMemoryMarketRepository.save(longitude,latitude,name,address,openingHours,webSite);
    }

    @Override
    public Optional<List<Market>> findOpened() {
        return this.inMemoryMarketRepository.findOpened();
    }
}