package com.weyland.prototype.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/12/29 18:48
 * \* Description:
 * \
 */
@Entity
public class UserAuth extends BaseEntity{

    @ManyToOne(targetEntity = UserProfile.class)
    private UserProfile user;

    @Column(name = "IDENTITY_TYPE")
    private String identityType;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "PASS_TOKEN")
    private String passToken;

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassToken() {
        return passToken;
    }

    public void setPassToken(String passToken) {
        this.passToken = passToken;
    }
}
