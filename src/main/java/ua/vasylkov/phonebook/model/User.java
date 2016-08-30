package ua.vasylkov.phonebook.model;

import java.util.EnumSet;
import java.util.Set;

public class User extends NamedEntity {
    protected String login;
    protected String password;
    protected Set<Role> roles;

    public User(){}

    public User(User u){
        this(u.getId(), u.getName(), u.getLogin(), u.getPassword(), u.getRoles());
    }

    public User(Integer id, String fullName, String login, String password, Role role, Role ... roles) {
        this(id, fullName, login, password, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String login, String password, Set<Role> roles) {
        super(id, name);
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", login=" + login +
                ", password=" + password +
                ", roles=" + roles +
                '}';
    }
}