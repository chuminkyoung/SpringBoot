package org.koreait.entity;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Member extends BaseEntity {
	
	@Id @GeneratedValue
	private Long memNo;
	
	@Column(length=40, unique=true, nullable=false)
	private String memId;
	
	@Column(length=65, unique=true)
	private String memPw;
	
	@Column(length=40, unique=true)
	private String memNm;
	
	private String email;
	
	@Column(length=11)
	private String mobile;
	
	@OneToMany(mappedBy="member", fetch=FetchType.LAZY) 	// 한명의 회원이 여러개의 게시글
	private List<BoardData> boardData;
	
	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + ", email="
				+ email + ", mobile=" + mobile + "]";
	}
}
