package controllers;

import entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ContactService;


@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }



    @GetMapping("")
    public String getAllContacts(Model model){
        System.out.println("ulalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        model.addAttribute("allContacts", contactService.getContactsList());
        return "contacts/welcome";
    }

}
