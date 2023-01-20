package web.dao;

import web.entities.Contact;

import java.util.List;

public interface ContactDAO {

    List<Contact> getAllContacts();
    List<Contact> getListPhonesOfPersonById(int id);
    Contact getContactById(int id);

    void saveNewContact(Contact contact);
}
