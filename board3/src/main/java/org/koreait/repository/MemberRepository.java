package org.koreait.repository;

import org.koreait.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor {
	// find엔티티명By
	Member findByMemId(String memId);
}
