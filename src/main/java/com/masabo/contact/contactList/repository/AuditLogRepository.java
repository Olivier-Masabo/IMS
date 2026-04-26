package com.masabo.contact.contactList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masabo.contact.contactList.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {}