package ua.vasylkov.phonebook;

import ua.vasylkov.phonebook.matcher.ModelMatcher;
import ua.vasylkov.phonebook.model.Contact;

/**
 * Created by OlegVasylkov on 23.08.2016.
 */
public class ContactTestData {
    public static final ModelMatcher<Contact, String> MATCHER = new ModelMatcher<>(Contact::toString);
}
