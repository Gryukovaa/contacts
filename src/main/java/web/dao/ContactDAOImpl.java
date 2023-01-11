package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.entities.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ContactDAOImpl implements ContactDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public ContactDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Contact> getAllContacts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Contact", Contact.class).getResultList();
    }



}
