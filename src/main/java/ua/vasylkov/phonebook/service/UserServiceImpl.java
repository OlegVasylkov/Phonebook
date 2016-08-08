package ua.vasylkov.phonebook.service;

import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.repository.UserRepository;
import ua.vasylkov.phonebook.unit.exception.ExceptionUtil;

import java.util.List;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public User getByLogin(String login) {
        return ExceptionUtil.checkNotFound(repository.getByLogin(login), "e-mail: " + login);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }
}
