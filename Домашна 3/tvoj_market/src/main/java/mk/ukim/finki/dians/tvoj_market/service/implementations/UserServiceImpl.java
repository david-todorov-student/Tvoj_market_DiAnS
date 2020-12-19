package mk.ukim.finki.dians.tvoj_market.service.implementations;

import mk.ukim.finki.dians.tvoj_market.model.User;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.dians.tvoj_market.repository.inmemory.InMemoryUserRepository;
import mk.ukim.finki.dians.tvoj_market.repository.jpa.UserRepository;
import mk.ukim.finki.dians.tvoj_market.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (this.userRepository.findByUsername(username).isPresent()) {
            throw new UserAlreadyExistsException(username);
        } else {
            User newUser = new User(username, password, name, surname);
            return this.userRepository.save(newUser);
        }
    }
}
