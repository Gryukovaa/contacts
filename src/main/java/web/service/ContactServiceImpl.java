package web.service;

import web.dao.ContactDAO;
import web.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactDAO contactDAO;

    @Autowired
    public ContactServiceImpl(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Override
    public void createСontact() {

    }

    @Override
    public Contact getContactById() {
        return null;
    }

    @Override
    public List<Contact> getContactsList() {
        return contactDAO.getAllContacts();
    }


    @Override
    public void updateContactById() {

    }

    @Override
    public void deleteContactByList() {

    }
}
