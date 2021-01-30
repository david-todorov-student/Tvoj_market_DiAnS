package mk.ukim.finki.dians.tvoj_market.repository.jpa;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findAllByNameLike(String name);
    void deleteByLongitudeAndLatitude(Double longitude, Double latitude);
}
