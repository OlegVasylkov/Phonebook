package ua.vasylkov.phonebook.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.repository.UserRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by OlegVasylkov on 09.08.2016.
 */

@Repository
public class MockUserRepositoryImpl implements UserRepository{
    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepositoryImpl.class);

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return true;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return null;
    }

    @Override
    public User getByLogin(String login) {
        LOG.info("get by login " + login);
        return null;
    }

    @Override
    public List<User> getAll() {
        LOG.info("get all");
        return Collections.EMPTY_LIST;
    }
}