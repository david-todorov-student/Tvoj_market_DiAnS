package mk.ukim.finki.dians.tvoj_market.service.implementations;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.OpeningHours;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.MarketIdDoesNotExistException;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.MarketNameDoesNotExistException;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.NoMarketsAreOpenException;
import mk.ukim.finki.dians.tvoj_market.repository.inmemory.InMemoryMarketRepository;
import mk.ukim.finki.dians.tvoj_market.service.MarketService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Market findById(Long id) {
        Market market = this.inMemoryMarketRepository.findById(id).orElse(null);
        if (market != null) {
            return market;
        } else throw new MarketIdDoesNotExistException(id);
    }

    @Override
    public List<Market> findByName(String name) {
        List<Market> markets = this.inMemoryMarketRepository.findByName(name);

        if (!markets.isEmpty()) {
            return markets;
        } else
            throw new MarketNameDoesNotExistException(name);
    }

    @Override
    public void deleteById(Long id) {
        this.inMemoryMarketRepository.deleteById(id);
    }

    @Override
    public Market save(double longitude, double latitude, String name, String address, OpeningHours openingHours, String webSite, String phoneNumber) {
        return this.inMemoryMarketRepository.save(longitude, latitude, name, address, openingHours, webSite, phoneNumber);
    }

    @Override
    public List<Market> findOpened() {
        return this.inMemoryMarketRepository.findOpened().orElseThrow(NoMarketsAreOpenException::new);
    }
}