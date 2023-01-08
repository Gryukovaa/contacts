package entities;


import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(appliesTo = "contact_phones")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int id;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "label")
    @Enumerated(EnumType.STRING)
    private Label label;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public PhoneNumber() {
    }

    public PhoneNumber(long phone_number, Label label, Contact contact) {
        this.phoneNumber = phone_number;
        this.label = label;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phone_number) {
        this.phoneNumber = phone_number;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContacts(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return phoneNumber == that.phoneNumber && label == that.label && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, label, contact);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber=" + phoneNumber +
                ", label=" + label +
                ", contact=" + contact +
                '}';
    }
}
