package org.koreait.entity;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class BoardData extends BaseEntity {
	// 게시판 제목, 내용, 작성자
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String subject; 	// 게시글 제목
	
	@Lob	// Longtext
	@Column(nullable=false)
	private String contents; 	// 게시글 본문
	
	@Column(length=40, nullable=false)
	private String poster; 		// 작성자명
	
	@ManyToOne(fetch=FetchType.LAZY)	// 여러명의 회원을 가지고 있음
	@JoinColumn(name="memNo")
	private Member member;

	@Override
	public String toString() {
		return "BoardData [id=" + id + ", subject=" + subject + ", contents=" + contents + ", poster=" + poster + "]";
	}
	
	
}
