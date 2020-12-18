package mk.ukim.finki.dians.tvoj_market.model.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String username) {
        super("User with username: "+username+" already exists.");
    }
}
