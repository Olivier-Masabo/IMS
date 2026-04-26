package com.masabo.contact.contactList.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class loginController {

    // SHOW LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // PROCESS LOGIN
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        // ✅ REQUIRED CREDENTIALS FROM YOUR INSTRUCTIONS
        if ("24RP12777".equals(username) && "24RP05014".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/dashboard";
        }

        return "redirect:/login?error=true";
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
