package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entities.Contact;


import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ContactDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }




    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Contact ", Contact.class)
                .getResultList();
    }

    @Override
    public List<Contact> getListPhonesOfPersonById(int PersonId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Contact> query = session.createQuery("from Contact c left join fetch c.person p where p.personId=:id"
                , Contact.class);
        query.setParameter("id", PersonId);
        return query.getResultList();

    }

    @Override
    public Contact getContactById(int id) {
        return sessionFactory.getCurrentSession()
                .find(Contact.class, id);
    }

    @Override
    public void saveNewContact(Contact contact) {
         sessionFactory.getCurrentSession()
                .save(contact);
    }

}
