package com.ouss.msa.accountservice.web;

import com.ouss.msa.accountservice.entities.BankAccount;
import com.ouss.msa.accountservice.openfeign.CustomerRestClient;
import com.ouss.msa.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

private final BankAccountRepository repository;
private final CustomerRestClient customerRestClient;

public AccountRestController(BankAccountRepository repo, CustomerRestClient client) {
	this.repository = repo;
	this.customerRestClient = client;
}

@GetMapping
public List<BankAccount> all() {
	List<BankAccount> accounts = repository.findAll();
	accounts.forEach(acc -> acc.setCustomer(
			customerRestClient.getCustomerById(acc.getCustomerId())
	));
	return accounts;
}

@GetMapping("/{id}")
public BankAccount findById(@PathVariable Long id) {
	BankAccount account = repository.findById(id)
								  .orElseThrow(() -> new RuntimeException("Account not found"));
	account.setCustomer(customerRestClient.getCustomerById(account.getCustomerId()));
	return account;
}
}
