package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entities.PhoneNumber;

import java.util.List;

@Repository
public class PhoneNumberDAOImpl implements PhoneNumberDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public PhoneNumberDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PhoneNumber> getAllNumbers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from PhoneNumber", PhoneNumber.class)
                .getResultList();
    }
}
