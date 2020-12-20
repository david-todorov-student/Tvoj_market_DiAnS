package mk.ukim.finki.dians.tvoj_market.service;

//import org.springframework.security.core.userdetails.UserDetailsService;

import mk.ukim.finki.dians.tvoj_market.model.User;
import mk.ukim.finki.dians.tvoj_market.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadUserByUsername(String s);

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}

