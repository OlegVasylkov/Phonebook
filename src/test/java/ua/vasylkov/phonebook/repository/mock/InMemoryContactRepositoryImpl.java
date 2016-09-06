package ua.vasylkov.phonebook.repository.mock;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import ua.vasylkov.phonebook.repository.ContactRepository;
import ua.vasylkov.phonebook.unit.ContactUnit;
import ua.vasylkov.phonebook.model.Contact;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ua.vasylkov.phonebook.UserTestData.USER_ID;


/**
 * Created by OlegVasylkov on 05.08.2016.
 */

@Repository
public class InMemoryContactRepositoryImpl implements ContactRepository {

    private Map<Integer, Map<Integer, Contact>> repository = new ConcurrentHashMap<>();
    private final Comparator<Contact> CONTACT_COMPARATOR_BY_FIRST_NAME
            = (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName());

    private AtomicInteger counter = new AtomicInteger(0);
    {
        ContactUnit.CONTACT_LIST.forEach(contact -> save(contact, USER_ID));
    }
    @Override
    public Contact save(Contact contact, int userId) {

        Assert.notNull(contact, "contact must be not null");
        Integer contactId = contact.getId();

        if (contact.isNew()) {
            contactId = counter.incrementAndGet();
            contact.setId(contactId);
        }else if (get(contactId, userId) == null)
            return null;
        Map<Integer, Contact> contacts = repository.computeIfAbsent(userId, ConcurrentHashMap::new);
        contacts.put(contactId, contact);
        return contact;
    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer, Contact> contacts = repository.get(userId);
        return contacts != null && contacts.remove(id) != null;
    }

    @Override
    public Contact get(int id, int userId) {
        Map<Integer, Contact> contacts = repository.get(userId);
        return contacts == null ? null : contacts.get(id);
    }

    @Override
    public Collection<Contact> getAll(int userId) {
        Map<Integer, Contact> contacts = repository.get(userId);
        return contacts == null ?
                Collections.EMPTY_LIST :
                contacts.values().stream()
                        .sorted(CONTACT_COMPARATOR_BY_FIRST_NAME)
                        .collect(Collectors.toList());
    }

    @Override
    public Collection<Contact> getFiltered(String search, int userId) {
        return ContactUnit.getFiltered(getAll(userId), search).stream()
                .sorted(CONTACT_COMPARATOR_BY_FIRST_NAME)
                .collect(Collectors.toList());
    }
}