package com.example.money.controller;

import com.example.money.model.BankAccount;
import com.example.money.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PutMapping("/withdraw/{accountNumber}")
    public BankAccount withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        return bankAccountService.withdraw(accountNumber, amount);
    }

    @GetMapping("/balance/{accountNumber}")
    public BankAccount checkBalance(@PathVariable String accountNumber) {
        return bankAccountService.checkBalance(accountNumber);
    }
}