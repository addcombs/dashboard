package com.combs.dashboard.bank;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface BankRepository extends CassandraRepository<Bank, String> {

    Optional<Bank> findBankByUserId(String userId);

}
