package ua.vasylkov.phonebook;

import ua.vasylkov.phonebook.matcher.ModelMatcher;
import ua.vasylkov.phonebook.model.Contact;

import java.util.Arrays;
import java.util.List;

import static ua.vasylkov.phonebook.model.BaseEntity.START_SEQ;

/**
 * Created by OlegVasylkov on 23.08.2016.
 */
public class ContactTestData {
    public static final ModelMatcher<Contact, String> CONTACT_MATCHER = new ModelMatcher<>(Contact::toString);
    public static final int CONTACT_ID = START_SEQ + 2;
    public static final int ADMIN_CONTACT_ID = START_SEQ + 4;

    public static final Contact CONTACT1 = new Contact(CONTACT_ID, "Stivenson", "Bob", "Y","+380987654321","","","");
    public static final Contact CONTACT2 = new Contact(CONTACT_ID+1,"Bond", "Mikle", "L","+380999999223","","","");
    public static final Contact ADMIN_CONTACT = new Contact(ADMIN_CONTACT_ID,"Maas", "Ryan", "Z","+380931234567","","","");
    public static final Contact ADMIN_CONTACT2 = new Contact(ADMIN_CONTACT_ID+1,"Klim", "Igor", "V","+380931299567","","","");

    public static final List<Contact> USER_CONTACTS = Arrays.asList(CONTACT2, CONTACT1);

    public static Contact getCreated(){
        return new Contact(null, "qwer", "qwer", "qwer", "", "", "", "");
    }

    public static Contact getUpdate(){
        return new Contact(CONTACT_ID, "обновленный asdf", CONTACT1.getFirstName(), CONTACT1.getFirstName(), CONTACT1.getMobilePhone(), CONTACT1.getHomePhone(), CONTACT1.getAddress(), CONTACT1.getEmail());
    }
}
