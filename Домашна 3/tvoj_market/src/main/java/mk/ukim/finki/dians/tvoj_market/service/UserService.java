package mk.ukim.finki.dians.tvoj_market.service;

//import org.springframework.security.core.userdetails.UserDetailsService;

import mk.ukim.finki.dians.tvoj_market.model.User;

public interface UserService {

    User register(String username, String password, String repeatPassword, String name, String surname);
}

