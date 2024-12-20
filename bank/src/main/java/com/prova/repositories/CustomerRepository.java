package com.prova.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{


    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);

}
