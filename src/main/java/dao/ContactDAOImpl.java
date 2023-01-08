package dao;

import entities.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public ContactDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Contact> getAllContacts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Contact c", Contact.class).getResultList();
    }

}
