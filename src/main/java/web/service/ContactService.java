package web.service;

import web.entities.Contact;

import java.util.List;


public interface ContactService {

    void createСontact();
    Contact getContactById();
    List<Contact> getContactsList();


    void updateContactById();
    void deleteContactByList();

}
