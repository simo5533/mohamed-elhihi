package com.ouss.msa.accountservice.openfeign;

import com.ouss.msa.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

@GetMapping("/customers/{id}")
@CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
Customer getCustomerById(@PathVariable Long id);

default Customer getDefaultCustomer(Long id, Exception exception) {
	return new Customer(id, "UNKNOWN", "UNKNOWN");
}
}
