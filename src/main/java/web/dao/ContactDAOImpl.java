package web.dao;

import web.entities.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public ContactDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Contact", Contact.class)
                .getResultList();
    }

}

