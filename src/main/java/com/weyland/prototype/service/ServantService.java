package com.weyland.prototype.service;

import com.weyland.prototype.enums.ResultEnums;
import com.weyland.prototype.exception.ServantException;
import com.weyland.prototype.repository.ServantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 18:50
 * \* Description:
 */

@Service
public class ServantService {

    @Autowired
    ServantRepository servantRepository;

    public void checkStar(String servantStar) throws Exception{
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        boolean isNum = pattern.matcher(servantStar).matches();
        //正则判断是否为数字
        if(isNum){
            Integer star = Integer.parseInt(servantStar);
            if(star<1){
//                throw new ServantException("zero below","星级必须大于等于一星");
                throw new ServantException(ResultEnums.STAR_BELOW);
            }else if (star>5){
//                throw new ServantException("five over","星级必须小于等于五星");
                throw new ServantException(ResultEnums.STAR_OVER);
            }
        }else {
            throw new Exception("星级不为数字");
        }
    }

}
