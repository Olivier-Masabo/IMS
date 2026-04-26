package com.masabo.contact.contactList.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masabo.contact.contactList.model.AuditLog;
import com.masabo.contact.contactList.repository.AuditLogRepository;

@Controller
@RequestMapping("/audits")
public class AuditController {
    @Autowired private AuditLogRepository auditRepo;

    @GetMapping
    public String listAudits(Model model) {
        model.addAttribute("audits", auditRepo.findAll());
        return "audits";
    }

    @PostMapping("/add")
    public String addAudit(@ModelAttribute AuditLog auditLog) {
        auditLog.setTimestamp(LocalDateTime.now());
        auditRepo.save(auditLog);
        return "redirect:/audits";
    }
}
