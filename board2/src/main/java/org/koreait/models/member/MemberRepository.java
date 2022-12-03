package org.koreait.models.member;

import java.time.LocalDateTime;
import java.util.List;

import org.koreait.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
	// memId 조회
	Member findMemberByMemId(String memId);
	
	// 가입일자 기간
	List<Member> findByRegDtBetweenOrderByRegDtDesc(LocalDateTime sDate, LocalDateTime eDate);
	
	List<Member> findByMemNmContaining(String key);
	
	@Query("SELECT m FROM Member m WHERE m.memId LIKE %:keyword% OR m.memNm LIKE %:keyword%")	// * = m
	List<Member> findByKeyword(@Param("keyword") String keyword);
}
