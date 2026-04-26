package com.masabo.contact.contactList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.masabo.contact.contactList.model.Asset;
import com.masabo.contact.contactList.repository.AssetRepository;

@Controller
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetRepository assetRepo;

    // LOAD PAGE
    @GetMapping
    public String listAssets(Model model) {
        model.addAttribute("assets", assetRepo.findAll());
        model.addAttribute("asset", new Asset());
        return "assets";
    }

    // ADD / UPDATE (same method)
    @PostMapping("/save")
    public String saveAsset(@ModelAttribute Asset asset) {
        assetRepo.save(asset);
        return "redirect:/assets";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Long id) {
        assetRepo.deleteById(id);
        return "redirect:/assets";
    }

    // EDIT (load selected asset into form)
    @GetMapping("/edit/{id}")
    public String editAsset(@PathVariable Long id, Model model) {
        Asset asset = assetRepo.findById(id).orElseThrow();
        model.addAttribute("asset", asset); // fill form
        model.addAttribute("assets", assetRepo.findAll());
        return "assets";
    }
}