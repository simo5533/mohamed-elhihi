package com.ouss.msa.customerservice;

import com.ouss.msa.customerservice.entities.Customer;
import com.ouss.msa.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

public static void main(String[] args) {
	SpringApplication.run(CustomerServiceApplication.class, args);
}

// Ajouter quelques clients au démarrage
@Bean
CommandLineRunner init(CustomerRepository repository) {
	return args -> {
		repository.save(new Customer(null, "Oussama", "ouss@gmail.com"));
		repository.save(new Customer(null, "Amine", "amine@gmail.com"));
		repository.save(new Customer(null, "Sara", "sara@gmail.com"));
	};
}
}
