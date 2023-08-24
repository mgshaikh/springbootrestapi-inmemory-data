package com.learn.rest.respository;

import com.learn.rest.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ContactRepository {

    public static Map<Integer, Contact> repository = new HashMap<>();

    static{
        repository.put(101, new Contact(101, "Mohammed","Ghouse", "9999911111","mg@mg.com", "official"));
        repository.put(102, new Contact(102, "Jaya","Prasad", "9999922222","jp@mg.com", "official"));
        repository.put(103, new Contact(103, "Sunil","Nagaraj", "9999933333","sunil@mg.com", "friends"));
        repository.put(104, new Contact(104, "Manzoor","khan", "9999944444","manz@mg.com", "friends"));
    }

    public Map<Integer, Contact> getRepository(){
        return repository;
    }

}