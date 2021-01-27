package mk.ukim.finki.dians.tvoj_market.model.exceptions;

import java.util.function.Supplier;

public class MarketIdDoesNotExistException extends RuntimeException {
    public MarketIdDoesNotExistException(Long id) {
        super("Market with id: "+id+" does not exist.");
    }
}
