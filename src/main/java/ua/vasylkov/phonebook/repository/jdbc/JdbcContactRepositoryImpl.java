package ua.vasylkov.phonebook.repository.jdbc;

import ua.vasylkov.phonebook.model.Contact;
import ua.vasylkov.phonebook.repository.ContactRepository;

import java.util.Collection;

/**
 * Created by OlegVasylkov on 23.08.2016.
 */
public class JdbcContactRepositoryImpl implements ContactRepository {
    //TODO
    @Override
    public Contact save(Contact contact, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Contact get(int id, int userId) {
        return null;
    }

    @Override
    public Collection<Contact> getAll(int userId) {
        return null;
    }

    @Override
    public Collection<Contact> getFiltered(String name, int userId) {
        return null;
    }
}