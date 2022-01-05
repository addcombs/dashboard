package com.combs.dashboard.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public ResponseEntity<Bank> getBankAccount(String userId) {
        try{
            Optional<Bank> bankOptional = bankRepository.findBankByUserId(userId);

            if(bankOptional.isPresent()) {
                return new ResponseEntity<>(bankOptional.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
