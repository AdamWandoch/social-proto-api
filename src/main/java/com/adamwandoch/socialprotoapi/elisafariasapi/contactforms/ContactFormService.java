package com.adamwandoch.socialprotoapi.elisafariasapi.contactforms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContactFormService {

    @Autowired
    private ContactFormRepository contactFormRepository;

    public ContactFormService(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    public void addContactForm(ContactFormEntity contactForm) {
        contactFormRepository.save(contactForm);
    }

    public ArrayList<ContactFormEntity> getAllContactForms() {
        ArrayList<ContactFormEntity> forms = new ArrayList<>();
            contactFormRepository.findAll().forEach(forms::add);
            return forms;
    }

}
