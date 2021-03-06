package ua.vasylkov.phonebook.web.user;

import org.springframework.stereotype.Controller;
import ua.vasylkov.phonebook.AuthorizedUser;
import ua.vasylkov.phonebook.model.User;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */

@Controller
public class ProfileRestController extends AbstractUserController {
    public User get() {
        return super.get(AuthorizedUser.getId());
    }

    public void update(User user) {
        super.update(user, AuthorizedUser.getId());
    }

    public void delete() {
        super.delete(AuthorizedUser.getId());
    }
}
