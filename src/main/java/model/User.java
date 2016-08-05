package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private String fullName;
    private List<Contact> contacts = new ArrayList<Contact>();

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
