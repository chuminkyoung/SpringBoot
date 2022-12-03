package org.koreait.models.board;

import java.util.List;

import org.koreait.entity.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
	
	@Query("SELECT b, m FROM BoardData b LEFT JOIN FETCH b.member m")
	List<BoardData> findDataAll();
}
