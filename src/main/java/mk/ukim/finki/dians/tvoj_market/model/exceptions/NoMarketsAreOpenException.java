package mk.ukim.finki.dians.tvoj_market.model.exceptions;

public class NoMarketsAreOpenException extends RuntimeException{
    public NoMarketsAreOpenException() {
        super("No markets are open at this time.");
    }
}
