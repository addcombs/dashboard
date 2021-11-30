package com.combs.dashboard.member;

import jnr.a64asm.Mem;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface MemberRepository extends CassandraRepository<Member, String> {

}
