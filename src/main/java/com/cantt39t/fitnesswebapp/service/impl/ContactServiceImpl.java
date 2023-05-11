package com.cantt39t.fitnesswebapp.service.impl;

import com.cantt39t.fitnesswebapp.model.Contact;
import com.cantt39t.fitnesswebapp.repository.ContactRepository;
import com.cantt39t.fitnesswebapp.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }
}
