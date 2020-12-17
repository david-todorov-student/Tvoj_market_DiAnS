package mk.ukim.finki.dians.tvoj_market.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String name;
    private String surname;

    public User() {
    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
