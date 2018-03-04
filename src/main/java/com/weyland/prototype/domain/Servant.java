package com.weyland.prototype.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 15:44
 * \* Description:
 */

@Entity
public class Servant extends BaseEntity{

    @NotEmpty(message = "从者必须要有职阶")
    @Column(name = "servant_class")
    private String servantClass;//从者职阶

    @Column(name = "servant_star")
    private String servantStar;//从者星级

    @Column(name = "servant_name")
    private String servantName;//从者名

    @Column(name = "servant_level")
    private String servantLevel;//从者等级

    @Column(name = "noble_phantasm")
    private String noblePhantasm;//宝具

    public String getServantClass() {
        return servantClass;
    }

    public void setServantClass(String servantClass) {
        this.servantClass = servantClass;
    }

    public String getServantStar() {
        return servantStar;
    }

    public void setServantStar(String servantStar) {
        this.servantStar = servantStar;
    }

    public String getServantName() {
        return servantName;
    }

    public void setServantName(String servantName) {
        this.servantName = servantName;
    }

    public String getServantLevel() {
        return servantLevel;
    }

    public void setServantLevel(String servantLevel) {
        this.servantLevel = servantLevel;
    }

    public String getNoblePhantasm() {
        return noblePhantasm;
    }

    public void setNoblePhantasm(String noblePhantasm) {
        this.noblePhantasm = noblePhantasm;
    }
}
