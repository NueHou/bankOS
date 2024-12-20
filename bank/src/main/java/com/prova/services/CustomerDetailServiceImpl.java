package com.prova.services;

import com.prova.domains.Person;
import com.prova.repositories.PersonRepository;
import com.prova.security.CustomerSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailServiceImpl implements UserDetailsService {

    private final PersonRepository personRepository;

    public CustomerDetailServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> customer = personRepository.findByEmail(username);
        if (customer.isEmpty()){
            throw new UsernameNotFoundException("Customer not found!"+ username);
        }
        return new CustomerSS(customer.orElse(null));
    }
}
