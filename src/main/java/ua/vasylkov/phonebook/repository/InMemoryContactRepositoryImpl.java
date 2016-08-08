package ua.vasylkov.phonebook.repository;

import ua.vasylkov.phonebook.unit.ContactUnit;
import ua.vasylkov.phonebook.model.Contact;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by OlegVasylkov on 05.08.2016.
 */
public class InMemoryContactRepositoryImpl implements ContactRepository {
    private Map<Integer, Contact> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    {
        ContactUnit.CONTACT_LIST.forEach(this::save);
    }
    @Override
    public Contact save(Contact contact) {
        if (contact.isNew())
            contact.setId(counter.incrementAndGet());
        repository.put(contact.getId(), contact);
        return contact;
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Contact get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Contact> getAll() {
        return repository.values();
    }
}