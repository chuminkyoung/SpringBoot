package org.koreait.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public abstract class BaseEntity {
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDt;	// 가입일
	
	@LastModifiedDate
	@Column(insertable=false)		// 수정할때만 추가
	private LocalDateTime modDt;	// 수정일
}
