package com.weyland.prototype.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/11/15 17:29
 * \* Description:
 * \
 */

//声明注入配置
@Component
//声明该类对应application配置文件中的visitor前缀
@ConfigurationProperties(prefix = "visitor")
public class Visitor {

    private String name;

    private String securityCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
