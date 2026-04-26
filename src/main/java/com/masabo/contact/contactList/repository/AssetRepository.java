package com.masabo.contact.contactList.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masabo.contact.contactList.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    Optional<Asset> findBySerialNumber(String serialNumber);
    List<Asset> findByStatus(String status);
}





