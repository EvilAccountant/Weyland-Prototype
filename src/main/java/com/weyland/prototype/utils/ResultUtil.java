package com.weyland.prototype.utils;

import com.weyland.prototype.domain.ReturnResult;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 18:31
 * \* Description:
 */

public class ResultUtil {

    public static ReturnResult success(Object object){
        ReturnResult result = new ReturnResult();
        result.setResultCode("0");
        result.setResultMessage("操作成功");
        result.setResultData(object);
        return result;
    }

    public static ReturnResult success(){
        return success(null);
    }

    public static ReturnResult error(String code , String msg){
        ReturnResult result = new ReturnResult();
        result.setResultCode(code);
        result.setResultMessage(msg);
        return result;
    }

}
