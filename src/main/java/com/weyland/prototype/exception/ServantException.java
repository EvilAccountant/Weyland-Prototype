package com.weyland.prototype.exception;

import com.weyland.prototype.enums.ResultEnums;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 19:26
 * \* Description:
 */
public class ServantException extends RuntimeException{

    private String code;

    public ServantException(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }

//    public ServantException(String code ,String msg){
//        super(msg);
//        this.code = code;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
