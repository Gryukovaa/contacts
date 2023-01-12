package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import web.service.ContactAndPhonesService;


@Controller
@RequestMapping("/")
public class ContactController {

    private final ContactAndPhonesService contactAndPhonesService;

    @Autowired
    public ContactController(ContactAndPhonesService contactService) {
        this.contactAndPhonesService = contactService;
    }



    @RequestMapping("")
    public String getAllContacts(Model model){
        model.addAttribute("allContacts", contactAndPhonesService.getContactsList());
        return "contacts/welcome";
    }

    @RequestMapping("/book")
    public String getContactsWithNumbers(Model model){
        model.addAttribute("allContacts", contactAndPhonesService.getContactsWithPhones());
        model.addAttribute("allPhones", contactAndPhonesService.getNumbersList());
        return "contacts/contactBook";
    }

    @RequestMapping("/phones")
    public String getAllNumbers(Model model){
        model.addAttribute("allPhones", contactAndPhonesService.getNumbersList());
        return "contacts/phones";
    }


}
