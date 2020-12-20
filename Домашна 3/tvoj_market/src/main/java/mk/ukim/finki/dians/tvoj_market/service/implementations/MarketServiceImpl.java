package mk.ukim.finki.dians.tvoj_market.service.implementations;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.MarketIdDoesNotExistException;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.MarketNameDoesNotExistException;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.NoMarketsAreOpenException;
import mk.ukim.finki.dians.tvoj_market.repository.jpa.MarketRepository;
import mk.ukim.finki.dians.tvoj_market.service.MarketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketServiceImpl implements MarketService {
    private final MarketRepository marketRepository;

    public MarketServiceImpl(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public List<Market> findAll() {
        return this.marketRepository.findAll();
    }

    @Override
    public Market findById(Long id) {
        Market market = this.marketRepository.findById(id).orElse(null);
        if (market != null) {
            return market;
        } else throw new MarketIdDoesNotExistException(id);
    }

    @Override
    public List<Market> findByName(String name) {
        List<Market> markets = this.marketRepository.findAllByNameLike(name);

        if (!markets.isEmpty()) {
            return markets;
        } else
            throw new MarketNameDoesNotExistException(name);
    }

    @Override
    public void deleteById(Long id) {
        this.marketRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Market save(Long id, double longitude, double latitude, String name, String address, String openingHours, String webSite, String phoneNumber) {
        if (id != null)
            this.marketRepository.deleteById(id);
        return this.marketRepository.save(new Market(longitude, latitude, name, address, openingHours, webSite, phoneNumber));
    }

    @Override
    public List<Market> findOpened() {
        List<Market> opened = this.marketRepository.findAll().stream()
                .filter(market -> market.getOpeningHours() != null)
                .filter(market -> market.getOpeningHour().isBefore(LocalTime.now())
                        && market.getClosingHour().isAfter(LocalTime.now()))
                .collect(Collectors.toList());
        if (opened.isEmpty()) {
            throw new NoMarketsAreOpenException();
        } else
            return opened;
    }
}