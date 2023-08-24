package com.learn.rest.controller;

import com.learn.rest.exception.ContactNotFoundException;
import com.learn.rest.respository.ContactRepository;
import com.learn.rest.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/info")
    public String getInfo() throws UnknownHostException {
        final String lineSeparator = System.lineSeparator();
        final InetAddress localHost = InetAddress.getLocalHost();
        final String hostName = localHost.getHostName();
        final String hostAddress = localHost.getHostAddress();
        StringBuilder info = new StringBuilder();
        info.append("----------------------------------").append(lineSeparator);
        info.append("Contacts API : ").append("Version ").append("V2").append(lineSeparator);
        info.append("Host : ").append(hostName).append(lineSeparator);
        info.append("IP : ").append(hostAddress).append(lineSeparator);
        info.append("----------------------------------").append(lineSeparator);
        return info.toString();
     }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        Collection<Contact> contacts = contactRepository.getRepository().values();
        return new ArrayList<>(contacts);
    }

    @GetMapping("/contacts/{contactId}")
    public Contact getContactById(@PathVariable Integer contactId) throws ContactNotFoundException {
        Contact contact = contactRepository.getRepository().get(contactId);
        if (contact == null) {
            throw new ContactNotFoundException();
        }
        return contactRepository.getRepository().get(contactId);
    }

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {
        int contactId = Collections.max(contactRepository.getRepository().keySet()) + 1;
        contact.setContactId(contactId);
        contactRepository.getRepository().put(contact.getContactId(), contact);
        return contact;
    }

    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<?> addContact(@PathVariable Integer contactId) throws ContactNotFoundException {
        Contact contact = contactRepository.getRepository().get(contactId);
        if(contact == null){
            throw new ContactNotFoundException();
        }
        contactRepository.getRepository().remove(contactId);
        return ResponseEntity.ok("Contact Deleted : " + contactId);
    }

}
