package mk.ukim.finki.dians.tvoj_market.model.exceptions;

public class MarketNameDoesNotExistException extends RuntimeException{
    public MarketNameDoesNotExistException(String name) {
        super("Market with name: "+name+" does not exist.");
    }
}
