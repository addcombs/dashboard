package com.combs.dashboard.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("/bank-account/{userId}")
    public ResponseEntity<BankAccount> bankAccount(@PathVariable String userId){
        return bankAccountService.getBankAccount(userId);
    }

    @PostMapping("/add-bank-account")
    public ResponseEntity<BankAccount> addBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.addBankAccount(bankAccount);
    }

    @PutMapping("/update-bank-account")
    public ResponseEntity<BankAccount> updateBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.updateBankAccount(bankAccount);
    }

    @DeleteMapping("/remove-bank-account/{userId}")
    public ResponseEntity<HttpStatus> removeBankAccount(@PathVariable("userId") String userId){
        return bankAccountService.removeBankAccount(userId);
    }

}
