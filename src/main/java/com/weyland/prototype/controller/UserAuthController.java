package com.weyland.prototype.controller;

import com.weyland.prototype.domain.UserAuth;
import com.weyland.prototype.domain.UserProfile;
import com.weyland.prototype.repository.UserAuthRepository;
import com.weyland.prototype.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/1/26 19:53
 * \* Description:
 * \
 */
@RestController
public class UserAuthController {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    /**
     * 添加用户
     * @param identityType
     * @param account
     * @param passToken
     * @return
     */
    @PostMapping(value = "/addUser1")
    public UserAuth addUser1(@RequestParam("identityType") String identityType,
                          @RequestParam("account") String account,
                          @RequestParam("passToken") String passToken) {

        UserAuth user = new UserAuth();
        UserProfile userProfile = new UserProfile();
        userProfileRepository.save(userProfile);

        user.setUser(userProfile);
        user.setIdentityType(identityType);
        user.setAccount(account);
        user.setPassToken(passToken);
        userAuthRepository.save(user);

        return user;
    }

    @PostMapping(value = "/addUser2")
    public UserAuth addUser2(UserAuth user) {
        UserProfile userProfile = new UserProfile();
        userProfileRepository.save(userProfile);

        user.setUser(userProfile);
        userAuthRepository.save(user);

        return user;
    }

    /**
     * 修改密码
     * @param account
     * @param passToken
     * @return
     */
    @PostMapping(value = "/updateUser")
    public UserAuth updateUser(@RequestParam("account") String account,
                               @RequestParam("passToken") String passToken) {

        UserAuth user = userAuthRepository.findUserByAccount(account);
        System.out.println(user.getCreateTime());
        user.setPassToken(passToken);
        userAuthRepository.save(user);

        return user;
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "/allUser")
    public List<UserAuth> userList(){
        System.out.println("< === function executed === >");
        return userAuthRepository.findAll();
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping(value = "deleteUser/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userAuthRepository.delete(id);
    }

}
