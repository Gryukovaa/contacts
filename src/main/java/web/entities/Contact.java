
package web.entities;


import javax.persistence.*;
import javax.validation.constraints.*;

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
    @Column(name = "id")
    private int id;

    @NotNull(message = "this field is required")
    //@Size(min = 11, max = 11, message = "use format 374xxXXXXX, length must be equals 11 symbols")
    @Column(name = "phone_number")
    private long phoneNumber;

    /*@ElementCollection(targetClass = Label.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "phones_labels", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "labels")
    @JsonIgnore
    private Set<Label> labels;*/

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private Person person;


    /*public void addLabelToNumber(Label label){
        if (labels == null){
            labels = new HashSet<>();
        }
        labels.add(label);
    }*/

    public Contact() {
    }

    public Contact(Person person) {
        this.person = person;
    }


    public int getId() {
        return id;
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

    /*public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }*/

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + id +
                ", phoneNumber=" + phoneNumber +
                ", person=" + person +
                '}';
    }
}

