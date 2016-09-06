package ua.vasylkov.phonebook.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by OlegVasylkov on 09.08.2016.
 */

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    private static final Comparator<User> USER_COMPARATOR = Comparator.comparing(User::getName);

    @PostConstruct
    public void postConstruct(){
        LOG.info("++ test post construct");
    }

    @PreDestroy
    public void preDestroy() {
        LOG.info("++ test pre destroy");
    }

    @Override
    public User save(User user) {
        Assert.notNull(user, "user must be not null");
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
        }
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByLogin(String login) {
        Assert.notNull(login, "login must be not null");
        return repository.values().stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .get();
    }

    @Override
    public List<User> getAll() {
        return repository.values().stream()
                .sorted(USER_COMPARATOR)
                .collect(Collectors.toList());
    }
}