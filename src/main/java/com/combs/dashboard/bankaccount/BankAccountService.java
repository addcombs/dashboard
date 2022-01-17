package com.combs.dashboard.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    public ResponseEntity<BankAccount> getBankAccount(String userId) {
        try{
            Optional<BankAccount> bankAccountOptional = bankAccountRepository.findBankAccountByUserId(userId);

            if(bankAccountOptional.isPresent()) {
                return new ResponseEntity<>(bankAccountOptional.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<BankAccount> addBankAccount(BankAccount bankAccount) {
        try {
            return new ResponseEntity<>(bankAccountRepository.save(bankAccount), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<BankAccount> updateBankAccount(BankAccount bankAccount) {
        
        Optional<BankAccount> currentBankAccount = bankAccountRepository.findById(bankAccount.getUserId());
        
        if(currentBankAccount.isPresent()){
            try {
                BankAccount newBankAccount = currentBankAccount.get();
                newBankAccount.setBalance(bankAccount.getBalance());
                return new ResponseEntity<>(bankAccountRepository.save(newBankAccount), HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> removeBankAccount(String userId) {
        try {
            bankAccountRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
