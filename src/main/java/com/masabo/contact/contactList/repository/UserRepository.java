package com.masabo.contact.contactList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masabo.contact.contactList.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
