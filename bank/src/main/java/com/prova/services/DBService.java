package com.prova.services;

import com.prova.domains.enums.PersonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Account;
import com.prova.domains.Bank;
import com.prova.domains.Branch;
import com.prova.domains.Customer;
import com.prova.domains.Transaction;
import com.prova.domains.enums.AccountStatus;
import com.prova.domains.enums.AccountType;
import com.prova.domains.enums.TransactionType;
import com.prova.repositories.AccountRepository;
import com.prova.repositories.BankRepository;
import com.prova.repositories.BranchRepository;
import com.prova.repositories.CustomerRepository;
import com.prova.repositories.TransactionRepository;

@Service
public class DBService {

    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private BranchRepository branchRepo;
    @Autowired 
    private CustomerRepository customerRepo;
    @Autowired
    private TransactionRepository transactionRepo;
    @Autowired
    private BankRepository bankRepo;

    public void initDB(){

        Account account1 = new Account(1, 44.000, AccountType.SAVINGS, AccountStatus.ACTIVE);

        Customer customer1 = new Customer(1, "123", "logan@gmail.com", "123-456-789-12", "mint", "logan", account1);

        Branch branch1 = new Branch(1, "Agencia 01", account1, "1111.3133.0001.12");

        Bank bank1 = new Bank(1, "Cropss", customer1, "1333.3133.0001.12", branch1);

        Transaction transaction1 = new Transaction(null, 4.000, TransactionType.DEPOSIT);

        accountRepo.save(account1);
        customerRepo.save(customer1);
        branchRepo.save(branch1);
        transactionRepo.save(transaction1);
        bankRepo.save(bank1);
    }


}
