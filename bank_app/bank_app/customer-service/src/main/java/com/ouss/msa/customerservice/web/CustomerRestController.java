package com.ouss.msa.customerservice.web;

import com.ouss.msa.customerservice.entities.Customer;
import com.ouss.msa.customerservice.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

private final CustomerRepository customerRepository;

public CustomerRestController(CustomerRepository customerRepository) {
	this.customerRepository = customerRepository;
}

@GetMapping
public List<Customer> all() {
	return customerRepository.findAll();
}

@GetMapping("/{id}")
public Customer getById(@PathVariable Long id) {
	return customerRepository.findById(id)
				   .orElseThrow(() -> new RuntimeException("Customer not found"));
}

@PostMapping
public Customer save(@RequestBody Customer customer) {
	return customerRepository.save(customer);
}
}
