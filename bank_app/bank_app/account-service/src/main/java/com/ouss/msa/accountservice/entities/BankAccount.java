package com.ouss.msa.accountservice.entities;

import com.ouss.msa.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Double balance;

private Long customerId;

@Transient
private Customer customer; // venant du customer-service
}
