package mk.ukim.finki.dians.tvoj_market.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException() {
        super("Invalid user credentials.");
    }
}
