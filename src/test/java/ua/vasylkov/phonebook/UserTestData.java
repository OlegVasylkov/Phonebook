package ua.vasylkov.phonebook;

import ua.vasylkov.phonebook.model.Role;
import ua.vasylkov.phonebook.model.User;

/**
 * Created by OlegVasylkov on 17.08.2016.
 */
public class UserTestData {
    public static final int ADMIN_ID = 1;
    public static final int USER_ID = 2;

    public static final User ADMIN = new User(ADMIN_ID, "Admin name", "admin", "root", Role.ROLE_ADMIN);
    public static final User USER = new User(USER_ID, "User name", "user", "password", Role.ROLE_USER);
}
