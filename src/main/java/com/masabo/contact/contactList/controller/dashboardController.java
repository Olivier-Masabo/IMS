package com.masabo.contact.contactList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.masabo.contact.contactList.repository.AssetRepository;
import com.masabo.contact.contactList.repository.UserRepository;
import com.masabo.contact.contactList.repository.AssignmentRepository;

@Controller
public class dashboardController {

    @Autowired
    private AssetRepository assetRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AssignmentRepository assignmentRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalAssets", assetRepo.count());
        model.addAttribute("assignedAssets", assetRepo.findByStatus("Assigned").size());
        model.addAttribute("availableAssets", assetRepo.findByStatus("Available").size());

        model.addAttribute("totalUsers", userRepo.count());
        model.addAttribute("totalAssignments", assignmentRepo.count());

        return "dashboard";
    }
}