package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import web.entities.Person;
import web.entities.Contact;
import web.service.ContactAndPhonesService;

import java.util.List;


@Controller
@RequestMapping("/")
public class ContactBookController {

    private final ContactAndPhonesService contactAndPhonesService;

    @Autowired
    public ContactBookController(ContactAndPhonesService contactAndPhonesService) {
        this.contactAndPhonesService = contactAndPhonesService;
    }

    // главная страничка,
    // показать всех людей, без номеров
    @RequestMapping("")
    public String getAllPersons(Model model){
        model.addAttribute("allPersons", contactAndPhonesService.getPersonsList());
        return "contacts/welcome";
    }



    // создание контакта
    // возвращает страничку с формой
    @GetMapping("/new")
    public String newContact(Model model){
        model.addAttribute("newContact", new Contact());
        return "contacts/newContactForm";
    }

    // создание контакта
    // принимает данные и пишет в базу новый контакт
    @PostMapping("/save")
    public String saveNewContact(@ModelAttribute Contact contact){
        contactAndPhonesService.createСontact(contact);
        return "redirect:/";
    }


    // изменения контакта
    // возвращает страничку с формой
    @GetMapping( "/edit/{id}")
    public String getPersonForEdit(@PathVariable("id") int id,
                                   Model model){
        Person person = contactAndPhonesService.getPersonById(id);
        System.out.println(person);
        System.out.println("Person id = " + person.getPersonId());
        model.addAttribute("foundPerson", person);
        return "contacts/editContactForm";
    }

    // изменения контакта
    // принимает данные и пишет в базу
    @PostMapping(value = "/edit/{id}")
    public String updateUser(@PathVariable("id") int id,
                             @ModelAttribute("person") Person person) {
        Person newPerson =  contactAndPhonesService.getPersonById(id);
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        contactAndPhonesService.updatePerson(newPerson);
        return "redirect:/";
    }

    // добавляет контакту новый номер
    // пишет изменения в бд
    @PostMapping("/addNumber/{id}")
    public String addNumberByPersonId(@PathVariable("id") int personId,
                                      @ModelAttribute("newNumber") Contact contact){
        Contact contact2 = new Contact();
        contact2.setPhoneNumber(contact.getPhoneNumber());
        contact2.setPerson(contactAndPhonesService.getPersonById(personId));
        contactAndPhonesService.createСontact(contact2);
        return "redirect:/";
    }

    // добавляет человеку новый номер
    // страничка возвращает форму

    @GetMapping("/addNumber/{id}")
    public String AddNumberForm(@PathVariable("id") int personId,
            Model model){

        Contact contact = new Contact();
        contact.setPerson(contactAndPhonesService.getPersonById(personId));
        model.addAttribute("newNumberWithOwner", contact);
        return "contacts/newNumberPhone";
    }


    /*@GetMapping("/addNumber/{id}")
    public String AddNumberForm(@PathVariable("id") int personId,
                                Model model){
        Person owner = contactAndPhonesService.getPersonById(personId);
        Contact contact = new Contact(owner);

        // передаю пустой контакт с предзаполненным человеком
        model.addAttribute("newNumberWithContact", contact);
        System.out.println(contact);
        return "contacts/newNumberPhone";
    }*/

    //_______________________________________



    // удаляет контакт по ай ди
    @GetMapping("/delete/{id}")
    public String deleteAllInfoByPersonId(@PathVariable("id") int personId){
        contactAndPhonesService.deleteContactById(personId);
        return "redirect:/";
    }

    // показывает список номеров контакта

    @GetMapping("/person/phones/{id}")
    public String getPhoneListOfPerson(@PathVariable("id") int id, Model model){
        List<Contact> phonesOfPerson = contactAndPhonesService.getListPhonesOfPersonById(id);
        model.addAttribute("personsPhones", phonesOfPerson);
        Person owner = contactAndPhonesService.getPersonById(id);
        model.addAttribute("ownerOfNumber", owner);

        return "contacts/profile";
    }


    // показать все номера, без владельцев
    @RequestMapping("/phones")
    public String getAllContacts(Model model){
        model.addAttribute("allContacts", contactAndPhonesService.getContactsList());
        return "contacts/notImportant/phones";
    }
    // список контактов с номерами телефонов
    @RequestMapping("/book")
    public String getContacts(Model model){
        model.addAttribute("allContacts", contactAndPhonesService.getContactsList());
        return "contacts/notImportant/contactBook";
    }
}
