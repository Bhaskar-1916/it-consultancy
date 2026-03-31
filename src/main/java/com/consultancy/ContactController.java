package com.consultancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Mana HTML frontend nunchi allow cheyadaniki
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    // Form nunchi data save cheyadaniki
    @PostMapping("/save")
    public Contact saveMessage(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    // Admin page lo data chupinchadaniki
    @GetMapping("/all")
    public List<Contact> getAllMessages() {
        return contactRepository.findAll();
    }
}