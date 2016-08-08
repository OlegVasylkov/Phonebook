package ua.vasylkov.phonebook.model;

import java.util.EnumSet;
import java.util.Set;

public class User extends NamedEntity {
    private String login;
    protected String password;
    protected Set<Role> roles;

    public User(){}

    public User(Integer id, String fullName, String login, String password, Role role, Role ... roles) {
        super(id, fullName);
        this.login = login;
        this.password = password;
        this.roles = EnumSet.of(role, roles);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
