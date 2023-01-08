package service;

import entities.Contact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContactService {

    void createСontact();
    Contact getContactById();
    List<Contact> getContactsList();


    void updateContactById();
    void deleteContactByList();

}
