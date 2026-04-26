package com.masabo.contact.contactList.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.masabo.contact.contactList.model.Asset;
import com.masabo.contact.contactList.model.Assignment;
import com.masabo.contact.contactList.model.User;
import com.masabo.contact.contactList.repository.AssetRepository;
import com.masabo.contact.contactList.repository.AssignmentRepository;
import com.masabo.contact.contactList.repository.UserRepository;

@Controller
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired private AssignmentRepository assignmentRepo;
    @Autowired private AssetRepository assetRepo;
    @Autowired private UserRepository userRepo;

    @GetMapping
    public String listAssignments(Model model) {
        model.addAttribute("assignments", assignmentRepo.findAll());
        model.addAttribute("assets", assetRepo.findAll());
        model.addAttribute("users", userRepo.findAll());
        return "assignments";
    }

    @PostMapping("/add")
    public String addAssignment(@RequestParam Long assetId,
                               @RequestParam Long userId,
                               @RequestParam String assignedBy) {

        Asset asset = assetRepo.findById(assetId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);

        if (asset == null || user == null) {
            return "redirect:/assignments";
        }

        Assignment assignment = new Assignment();
        assignment.setAsset(asset);
        assignment.setUser(user);
        assignment.setAssignedBy(assignedBy);
        assignment.setAssignedDate(LocalDate.now());

        asset.setStatus("Assigned");

        assignmentRepo.save(assignment);
        assetRepo.save(asset);

        return "redirect:/assignments";
    }

    @PostMapping("/return/{id}")
    public String returnAssignment(@PathVariable Long id) {

        Assignment assignment = assignmentRepo.findById(id).orElse(null);

        if (assignment == null) {
            return "redirect:/assignments";
        }

        assignment.setReturnedDate(LocalDate.now());

        Asset asset = assignment.getAsset();
        asset.setStatus("Available");

        assignmentRepo.save(assignment);
        assetRepo.save(asset);

        return "redirect:/assignments";
    }
}