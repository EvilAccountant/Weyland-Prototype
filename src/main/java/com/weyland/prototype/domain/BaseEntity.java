package com.weyland.prototype.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)//存入数据库时间格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//JSON数据下的时间格式
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
        this.createTime = createTime;
    }

    public BaseEntity() {
        createTime = new Date();
    }
}
