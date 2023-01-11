package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import web.service.ContactService;


@Controller
@RequestMapping("/")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }



    @RequestMapping("")
    public String getAllContacts(Model model){
        System.out.println("ulalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(contactService.getContactsList());
        model.addAttribute("allContacts", contactService.getContactsList());
        System.out.println(contactService.getContactsList());
        return "contacts/welcome";
    }

}
