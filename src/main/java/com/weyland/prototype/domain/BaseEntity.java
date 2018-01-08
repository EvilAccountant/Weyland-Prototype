package com.weyland.prototype.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/12/29 10:48
 * \* Description:
 * \
 */

@MappedSuperclass
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="UUIDGen", strategy="uuid") //生成32位UUID
    @GeneratedValue(generator="UUIDGen")
    @Column(name = "ID")
    private String id;

    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = LocalDateTime.now();
    }
}
