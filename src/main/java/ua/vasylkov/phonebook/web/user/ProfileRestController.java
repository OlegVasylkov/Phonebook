package ua.vasylkov.phonebook.web.user;

import ua.vasylkov.phonebook.LoggedUser;
import ua.vasylkov.phonebook.model.User;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class ProfileRestController extends AbstractUserController {
    public User get() {
        return super.get(LoggedUser.getId());
    }

    public void update(User user) {
        super.update(user, LoggedUser.getId());
    }

    public void delete() {
        super.delete(LoggedUser.getId());
    }
}
