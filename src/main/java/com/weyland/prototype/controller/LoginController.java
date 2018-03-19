package com.weyland.prototype.controller;

import com.weyland.prototype.config.LoginConfig;
import com.weyland.prototype.domain.UserAuth;
import com.weyland.prototype.domain.UserProfile;
import com.weyland.prototype.repository.UserAuthRepository;
import com.weyland.prototype.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/16 16:30
 * \* Description:
 */

@Controller
public class LoginController {
    
    @Autowired
    private UserAuthRepository userAuthRepository;
    
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    
    
    @GetMapping("/gallery")
    public String index(@SessionAttribute(LoginConfig.SESSION_KEY) String account, Model model){
        return "gallery";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/signUpVerify")
    public @ResponseBody Map<String,Object> signUpVerify(String userName, String account , String passToken , HttpSession session){
        Map<String,Object> map = new HashMap<String, Object>();
        UserAuth user = userAuthRepository.findUserByAccount(account);
        if (user!=null){
            map.put("success",false);
            map.put("message","account already existed");
        }else{
            user = new UserAuth();
            UserProfile userProfile = new UserProfile();
            userProfile.setUserName(userName);
            userProfileRepository.save(userProfile);

            user.setUser(userProfile);
//            user.setIdentityType(identityType);
            user.setAccount(account);
            user.setPassToken(passToken);
            userAuthRepository.save(user);
            
            session.setAttribute(LoginConfig.SESSION_KEY , account);
            map.put("success",true);
            map.put("message","welcome , "+userName);
        }
        return map;
    }
    

    @PostMapping("/loginVerify")
    public @ResponseBody Map<String,Object> loginVerify(String account , String passToken , HttpSession session){
        Map<String,Object> map = new HashMap<String, Object>();
        UserAuth user = userAuthRepository.findUserByAccount(account);
        if(user==null){
            map.put("success",false);
            map.put("message","account doesn't exists");
        }else if (!user.getPassToken().equals(passToken)){
            map.put("success",false);
            map.put("message","wrong password");
        }else{
            session.setAttribute(LoginConfig.SESSION_KEY , account);
            map.put("success",true);
            map.put("message","welcome , "+user.getUserProfile().getUserName());
        }
        return map;
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(LoginConfig.SESSION_KEY);
        return "redirect:login";
    }
}
