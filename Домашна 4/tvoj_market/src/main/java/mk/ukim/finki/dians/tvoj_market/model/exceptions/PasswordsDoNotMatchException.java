package mk.ukim.finki.dians.tvoj_market.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords do not match.");
    }
}
