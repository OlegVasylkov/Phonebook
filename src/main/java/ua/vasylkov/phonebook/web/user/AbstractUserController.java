package ua.vasylkov.phonebook.web.user;

import ua.vasylkov.phonebook.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.vasylkov.phonebook.service.UserService;

import java.util.List;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public abstract class AbstractUserController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractUserController.class);

    private UserService userService;

    public List<User> getAll(){
        LOG.info("Get all users");
        return userService.getAll();
    }

    public User get(int id){
        LOG.info("Get by id: " + id);
        return userService.get(id);
    }

    public void delete(int id){
        LOG.info("Delete by id: " + id);
        userService.delete(id);
    }

    public void update(User user, int id){
        user.setId(id);
        LOG.info("Update: " + user);
        userService.update(user);
    }

    public User create(User user) {
        user.setId(null);
        LOG.info("create " + user);
        return userService.save(user);
    }

    public User getByLogin(String login){
        LOG.info("Get by login: " + login);
        return userService.getByLogin(login);
    }
}
