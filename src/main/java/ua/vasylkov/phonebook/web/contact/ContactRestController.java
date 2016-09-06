package ua.vasylkov.phonebook.web.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.vasylkov.phonebook.AuthorizedUser;
import ua.vasylkov.phonebook.model.Contact;
import ua.vasylkov.phonebook.service.ContactService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */

@Controller
public class ContactRestController {
    private static final Logger LOG = LoggerFactory.getLogger(ContactRestController.class);

    @Autowired
    private ContactService contactService;

    public Contact get(int id){
        int userId = AuthorizedUser.getId();
        LOG.info("get contact {} for user {}", id, userId);
        return contactService.get(id, userId);
    }

    public void delete(int id){
        int userId = AuthorizedUser.getId();
        LOG.info("delete contact {} for user {}", id, userId);
        contactService.delete(id, userId);
    }

    public List<Contact> getAll(){
        int userId = AuthorizedUser.getId();
        LOG.info("get all contacts for {}", userId);
        return contactService.getAll(userId).stream().collect(Collectors.toList());
    }

    public Contact create(Contact contact){
        contact.setId(null);
        int userId = AuthorizedUser.getId();
        LOG.info("create {] for user {}", contact, userId);
        return contactService.save(contact, userId);
    }

    public void update(Contact contact, int id){
        contact.setId(id);
        int userId = AuthorizedUser.getId();
        LOG.info("update {} for user {}", contact, userId);
        contactService.update(contact, userId);
    }

    public List<Contact> getFiltered(String search){
        int userId = AuthorizedUser.getId();
        LOG.info("filter contacts by {} for user {}", search, userId);
        return contactService.getFiltered(search, userId).stream().collect(Collectors.toList());
    }
}