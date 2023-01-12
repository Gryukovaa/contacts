package web.service;

import web.entities.Contact;
import web.entities.PhoneNumber;

import java.util.List;


public interface ContactAndPhonesService {

    void createСontact();
    Contact getContactById();
    List<Contact> getContactsList();
    List<Contact> getContactsWithPhones();

    List<PhoneNumber> getNumbersList();

    void updateContactById();
    void deleteContactByList();

}
