package com.masabo.contact.contactList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.masabo.contact.contactList.model.User;
import com.masabo.contact.contactList.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    // LOAD PAGE
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("user", new User());
        return "users";
    }

    // SAVE (ADD OR UPDATE)
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userRepo.save(user); // works for both add & update
        return "redirect:/users";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "redirect:/users";
    }

    // EDIT (LOAD USER INTO FORM)
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userRepo.findById(id).orElseThrow();

        model.addAttribute("user", user); // pre-fill form
        model.addAttribute("users", userRepo.findAll());

        return "users";
    }
}