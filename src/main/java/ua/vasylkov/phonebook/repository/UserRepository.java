package ua.vasylkov.phonebook.repository;

import ua.vasylkov.phonebook.model.User;

import java.util.List;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByLogin(String login);

    List getAll();
}
