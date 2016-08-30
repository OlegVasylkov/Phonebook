package ua.vasylkov.phonebook;

import ua.vasylkov.phonebook.model.BaseEntity;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class LoggedUser {
    protected static int id = BaseEntity.START_SEQ;;

    public static void setId(int id) {
        LoggedUser.id = id;
    }

    public static int getId() {
        return id;
    }
}
