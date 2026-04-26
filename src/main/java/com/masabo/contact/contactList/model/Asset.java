package com.masabo.contact.contactList.model;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    private String type;
    private String model;
    private String processor;
    private String ram;
    private String storage;
    private String operatingSystem;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // ✅ FIX (IMPORTANT)
    private LocalDate purchaseDate;

    private Double purchaseCost;
    private String status;

    @Column(name = "asset_condition") // ✅ already correct
    private String condition;

    // ===== Getters & Setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    public String getStorage() { return storage; }
    public void setStorage(String storage) { this.storage = storage; }

    public String getOperatingSystem() { return operatingSystem; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public Double getPurchaseCost() { return purchaseCost; }
    public void setPurchaseCost(Double purchaseCost) { this.purchaseCost = purchaseCost; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}