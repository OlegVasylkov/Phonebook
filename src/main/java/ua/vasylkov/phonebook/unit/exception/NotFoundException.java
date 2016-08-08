package ua.vasylkov.phonebook.unit.exception;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
