package ua.vasylkov.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vasylkov.phonebook.repository.ContactRepository;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
}
