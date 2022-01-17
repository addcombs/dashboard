package com.combs.dashboard.bankaccount;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface BankAccountRepository extends CassandraRepository<BankAccount, String> {

    Optional<BankAccount> findBankAccountByUserId(String userId);

}
