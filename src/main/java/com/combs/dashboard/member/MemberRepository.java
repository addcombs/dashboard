package com.combs.dashboard.member;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MemberRepository extends CassandraRepository<Member, String> {

}
