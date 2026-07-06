package com.example.demo.services;

import com.example.demo.models.PaymentMethod;
import com.example.demo.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    // For the Admin Dashboard: view all methods, even disabled ones
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    // For the Cashier Checkout: view only active methods
    public List<PaymentMethod> getActivePaymentMethods() {
        return paymentMethodRepository.findByIsActiveTrue();
    }

    public PaymentMethod addPaymentMethod(PaymentMethod method) {
        if (paymentMethodRepository.existsByName(method.getName())) {
            throw new IllegalArgumentException("This payment method is already registered.");
        }
        method.setIsActive(true); // Always default new methods to active
        return paymentMethodRepository.save(method);
    }

    // Allows Admin to disable a method instead of deleting it (preserves receipt history)
    public PaymentMethod toggleActiveStatus(Integer id, boolean status) {
        PaymentMethod method = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment method not found."));
        method.setIsActive(status);
        return paymentMethodRepository.save(method);
    }
}