package com.mayo.reservationsys.entity.common;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value="예약한시간", dataType = "LocalDateTime", required = true, example = "2022-07-31 09:00:00")
    private LocalDateTime createDateTIme;

    @LastModifiedDate
    @Column(name="upd_dtm", nullable = false)
    @ApiModelProperty(value="예약수정시간", dataType = "LocalDateTime", required = true, example = "2022-07-31 21:32:00")
    private LocalDateTime updateDateTime;
}
