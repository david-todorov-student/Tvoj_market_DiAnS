package mk.ukim.finki.dians.tvoj_market.service;

import mk.ukim.finki.dians.tvoj_market.model.User;

public interface AuthService {
    User login(String username, String password);
}
