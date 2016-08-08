package ua.vasylkov.phonebook.web.user;

import ua.vasylkov.phonebook.model.User;

import java.util.List;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class AdminRestController extends AbstractUserController {
    public List<User> getAll(){
        return super.getAll();
    }

    public User get(int id){return super.get(id);}

    public User create(User user){return super.create(user);}

    public void update(User user, int id){super.update(user, id);}

    public void delete(int id){super.delete(id);}

    public User getByLogin(String login){return super.getByLogin(login);}
}
