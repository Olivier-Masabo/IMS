package com.masabo.contact.contactList.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masabo.contact.contactList.model.Asset;
import com.masabo.contact.contactList.model.MaintenanceLog;
import com.masabo.contact.contactList.repository.AssetRepository;
import com.masabo.contact.contactList.repository.MaintenanceLogRepository;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired private MaintenanceLogRepository maintenanceRepo;
    @Autowired private AssetRepository assetRepo;

    @GetMapping
    public String listMaintenance(Model model) {
        model.addAttribute("maintenanceLogs", maintenanceRepo.findAll());
        model.addAttribute("assets", assetRepo.findAll());
        return "maintenance";
    }

    @PostMapping("/add")
    public String addMaintenance(@RequestParam Long assetId,
                                 @RequestParam String repairNotes) {
        Asset asset = assetRepo.findById(assetId).orElseThrow();

        MaintenanceLog log = new MaintenanceLog();
        log.setAsset(asset);
        log.setRepairNotes(repairNotes);
        log.setLastCheckedDate(LocalDate.now());

        asset.setCondition("Under Repair");
        asset.setStatus("In Repair");

        maintenanceRepo.save(log);
        assetRepo.save(asset);

        return "redirect:/maintenance";
    }
}
