package dao;


import entities.Contact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContactDAO {

    List<Contact> getAllContacts();

}
