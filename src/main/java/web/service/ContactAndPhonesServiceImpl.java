package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.dao.ContactDAO;
import web.dao.PhoneNumberDAO;
import web.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.entities.PhoneNumber;

import java.util.List;

@Service
@Transactional
public class ContactAndPhonesServiceImpl implements ContactAndPhonesService {

    private ContactDAO contactDAO;
    private PhoneNumberDAO phoneNumberDAO;

    @Autowired
    public ContactAndPhonesServiceImpl(ContactDAO contactDAO, PhoneNumberDAO phoneNumberDAO) {
        this.contactDAO = contactDAO;
        this.phoneNumberDAO = phoneNumberDAO;
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
    public List<Contact> getContactsWithPhones(){
        return null;
    }

    @Override
    public List<PhoneNumber> getNumbersList() {
        return phoneNumberDAO.getAllNumbers();
    }

    @Override
    public void updateContactById() {

    }

    @Override
    public void deleteContactByList() {

    }
}
