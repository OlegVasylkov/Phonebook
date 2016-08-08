package ua.vasylkov.phonebook;

import ua.vasylkov.phonebook.model.Role;

import java.util.Set;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class LoggedUser {
    protected static int id;
    protected Set<Role> roles;

    public static int getId() {
        return id;
    }
}
