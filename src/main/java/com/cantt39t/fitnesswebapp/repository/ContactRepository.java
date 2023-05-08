package com.cantt39t.fitnesswebapp.repository;

import com.cantt39t.fitnesswebapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
