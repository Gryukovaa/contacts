
package web.entities;

import javax.persistence.*;

/*
    Эта сущность - owning side
        Описывает номер телефона совместно со связанной сущностью Person.
        Получается полноценный контакт, в котором есть:
        - номер телефона
        - имя с доступом через связанную сущность (contact.person.firstName)
        - фамилия с доступом через связанную сущность (contact.person.lastName)
*/


@Entity
@Table(name = "contact_phones")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int contactId;

    @Column(name = "phone_number")
    private long phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Person person;

    public Contact() {
    }

    public Contact(Person person) {
        this.person = person;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", phoneNumber=" + phoneNumber +
                ", person=" + person +
                '}';
    }
}

