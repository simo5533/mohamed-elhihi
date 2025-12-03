package com.ouss.msa.accountservice;

import com.ouss.msa.accountservice.entities.BankAccount;
import com.ouss.msa.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients

public class AccountServiceApplication {

public static void main(String[] args) {
	SpringApplication.run(AccountServiceApplication.class, args);
}
@Bean
CommandLineRunner start(BankAccountRepository repo) {
	return args -> {
		repo.save(new BankAccount(null, 12000.0, 1L, null));
		repo.save(new BankAccount(null, 3400.0, 2L, null));
		repo.save(new BankAccount(null, 9800.0, 3L, null));
	};
}

}
