package com.example.demo.repositories;

import com.example.demo.models.Customer;
import com.example.demo.models.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Integer> {
    List<CustomerPayment> findByCustomer(Customer customer);
}