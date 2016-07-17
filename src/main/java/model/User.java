package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by filipenko_n on 14.07.2016.
 */
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

}
