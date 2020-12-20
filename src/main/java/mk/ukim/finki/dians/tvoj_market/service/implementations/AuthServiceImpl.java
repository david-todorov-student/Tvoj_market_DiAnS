package mk.ukim.finki.dians.tvoj_market.service.implementations;

import mk.ukim.finki.dians.tvoj_market.model.User;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.dians.tvoj_market.repository.inmemory.InMemoryUserRepository;
import mk.ukim.finki.dians.tvoj_market.repository.jpa.UserRepository;
import mk.ukim.finki.dians.tvoj_market.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);

    }
}
