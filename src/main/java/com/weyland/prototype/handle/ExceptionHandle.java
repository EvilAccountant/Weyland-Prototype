package com.weyland.prototype.handle;

import com.weyland.prototype.domain.ReturnResult;
import com.weyland.prototype.exception.ServantException;
import com.weyland.prototype.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 19:17
 * \* Description:
 */
//拦截异常并统一处理
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnResult handle(Exception e){
        //验证异常类型是否为ServantException
        if (e instanceof ServantException){
            ServantException servantException=(ServantException) e;
            return ResultUtil.error(servantException.getCode(),servantException.getMessage());
        }else{
            e.printStackTrace();
            return ResultUtil.error("UNKNOWN 998","未知异常");
        }
    }

}
