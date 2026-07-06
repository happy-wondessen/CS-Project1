package com.example.demo.repositories;

import com.example.demo.models.Company;
import com.example.demo.models.CompanyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyPaymentRepository extends JpaRepository<CompanyPayment, Integer> {
    List<CompanyPayment> findByCompany(Company company);
}