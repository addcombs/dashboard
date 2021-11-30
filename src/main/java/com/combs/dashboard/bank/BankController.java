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

    @GetMapping("/bank/{memberid}")
    public ResponseEntity<Bank> bankAccount(@PathVariable String memberid){
        return bankService.getBankAccount(memberid);
    }

}
