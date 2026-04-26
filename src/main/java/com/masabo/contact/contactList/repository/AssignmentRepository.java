package com.masabo.contact.contactList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masabo.contact.contactList.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {}