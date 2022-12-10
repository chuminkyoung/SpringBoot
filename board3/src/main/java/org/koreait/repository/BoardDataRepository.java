package org.koreait.repository;

import java.util.List;

import org.koreait.entity.BoardData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor {
	List<BoardData> findBySubjectContaining(String subject, Pageable pageable);
}
