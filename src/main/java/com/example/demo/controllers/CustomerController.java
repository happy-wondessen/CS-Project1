package com.example.demo.controllers;


import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}