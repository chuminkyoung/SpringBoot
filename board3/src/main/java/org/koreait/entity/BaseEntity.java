package org.koreait.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

@MappedSuperclass
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDt;
	
	@LastModifiedDate
	@Column(insertable=false)
	private LocalDateTime modDt;
}
