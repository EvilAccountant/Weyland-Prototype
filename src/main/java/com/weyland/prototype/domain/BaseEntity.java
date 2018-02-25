package com.weyland.prototype.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = new Date();
    }
}
