package ua.vasylkov.phonebook.service;

import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.unit.exception.NotFoundException;

import java.util.List;


/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public interface UserService {
    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByLogin(String login) throws NotFoundException;

    List<User> getAll();

    void update(User user);
}
