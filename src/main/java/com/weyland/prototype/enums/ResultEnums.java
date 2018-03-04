package com.weyland.prototype.enums;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 22:37
 * \* Description:
 */
public enum ResultEnums {
    UNKNOWN_ERROR("ZERO-101","未知错误"),
    SUCCESS("ZERO-0","操作成功"),
    STAR_BELOW("STAR BELOW","星级小于一星"),
    STAR_OVER("STAR OVER","星级大于五星"),
    ;

    private String code;

    private String message;

    ResultEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
