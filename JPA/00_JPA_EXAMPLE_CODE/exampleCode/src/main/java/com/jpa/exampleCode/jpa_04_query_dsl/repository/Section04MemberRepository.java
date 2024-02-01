package com.jpa.exampleCode.jpa_04_query_dsl.repository;

import com.jpa.exampleCode.jpa_04_query_dsl.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface Section04MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom, QuerydslPredicateExecutor {

    //select m from Member m where m.username = ?
    List<Member> findByUsername(String username);
}
