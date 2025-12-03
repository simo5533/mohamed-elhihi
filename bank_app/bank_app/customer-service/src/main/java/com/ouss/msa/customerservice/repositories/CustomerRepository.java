package com.ouss.msa.customerservice.repositories;

import com.ouss.msa.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
