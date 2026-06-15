package com.example.demo.repositories;

import com.example.demo.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
    // Checks for duplicates before saving
    boolean existsByName(String name);

    // Fetches only the currently active payment methods for the checkout screen
    List<PaymentMethod> findByIsActiveTrue();
}