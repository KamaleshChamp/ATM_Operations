package com.example.money.service;

import com.example.money.model.BankAccount;
import com.example.money.service.BankAccountService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private Map<String, BankAccount> accounts = new HashMap<>();

    public BankAccountServiceImpl() {
        BankAccount account1 = new BankAccount("001", 1000.0);
        BankAccount account2 = new BankAccount("002", 500.0);
        accounts.put("001", account1);
        accounts.put("002", account2);
    }

    @Override
    public BankAccount withdraw(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        accounts.put(accountNumber, account);
        return account;
    }

    @Override
    public BankAccount checkBalance(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        return account;
    }
}