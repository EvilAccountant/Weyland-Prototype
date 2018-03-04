package com.weyland.prototype.controller;

import com.weyland.prototype.domain.ReturnResult;
import com.weyland.prototype.domain.Servant;
import com.weyland.prototype.repository.ServantRepository;
import com.weyland.prototype.service.ServantService;
import com.weyland.prototype.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 15:44
 * \* Description:
 */

@RestController
public class ServantController {

    @Autowired
    private ServantRepository servantRepository;

    @Autowired
    private ServantService servantService;

    @PostMapping(value = "/addServant")
    public ReturnResult<Servant> addServant(@Valid Servant servant , BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            String msg=bindingResult.getFieldError().getDefaultMessage();//内容与从者的职阶@注解的message相同
            return ResultUtil.error("Zero 101",msg);
        }
        servantService.checkStar(servant.getServantStar());
        servantRepository.save(servant);
        return ResultUtil.success(servant);
    }



    @GetMapping(value = "/allServant")
    public List<Servant> getAllServant(){
        return servantRepository.findAll();
    }

    @GetMapping(value = "/checkServantStar/{id}")
    public void checkServantStar(@PathVariable("id") String servantId)throws Exception{
        servantService.checkStar(servantId);
    }

}
