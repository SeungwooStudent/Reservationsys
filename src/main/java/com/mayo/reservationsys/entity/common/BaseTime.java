package com.mayo.reservationsys.entity.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTime {
    @CreatedDate
    @Column(name = "ins_dtm", nullable = false, updatable = false)
    private LocalDateTime createDateTIme;

    @LastModifiedDate
    @Column(name="upd_dtm", nullable = false)
    private LocalDateTime updateDateTime;
}
