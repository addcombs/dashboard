package com.combs.dashboard.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/bank/{userId}")
    public ResponseEntity<Bank> bankAccount(@PathVariable String userId){
        return bankService.getBankAccount(userId);
    }

}
