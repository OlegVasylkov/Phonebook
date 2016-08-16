package ua.vasylkov.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vasylkov.phonebook.model.Contact;
import ua.vasylkov.phonebook.repository.ContactRepository;
import ua.vasylkov.phonebook.unit.exception.ExceptionUtil;
import ua.vasylkov.phonebook.unit.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact get(int id, int userId) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(contactRepository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(contactRepository.delete(id, userId), id);
    }

    @Override
    public Contact update(Contact contact, int userId) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(contactRepository.save(contact, userId), contact.getId());
    }

    @Override
    public Contact save(Contact contact, int userId) {
        return contactRepository.save(contact, userId);
    }

    @Override
    public Collection<Contact> getAll(int userId) {
        return contactRepository.getAll(userId);
    }

    @Override
    public Collection<Contact> getFiltered(String search, int userId){
        return contactRepository.getFiltered(search, userId);
    }
}