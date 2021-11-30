package com.combs.dashboard.bank;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Bank {

    @PrimaryKey private String memberid;
    private Float balance;

    public Bank() {
    }

    public Bank(String memberid, Float balance) {
        this.memberid = memberid;
        this.balance = balance;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
