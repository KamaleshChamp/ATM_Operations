package com.example.money.service;



import com.example.money.model.BankAccount;

public interface BankAccountService {
    BankAccount withdraw(String accountNumber, double amount);
    BankAccount checkBalance(String accountNumber);
}