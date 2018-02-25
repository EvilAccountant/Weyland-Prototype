package com.weyland.prototype.controller;

import com.weyland.prototype.domain.UserAuth;
import com.weyland.prototype.domain.UserProfile;
import com.weyland.prototype.repository.UserAuthDao;
import com.weyland.prototype.repository.UserProfileDao;
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
    private UserAuthDao userAuthDao;

    @Autowired
    private UserProfileDao userProfileDao;

    /**
     * 添加用户
     * @param identityType
     * @param account
     * @param passToken
     * @return
     */
    @PostMapping(value = "/addUser")
    public UserAuth addUser(@RequestParam("identityType") String identityType,
                          @RequestParam("account") String account,
                          @RequestParam("passToken") String passToken) {

        UserAuth user = new UserAuth();
        UserProfile userProfile = new UserProfile();
        userProfileDao.save(userProfile);

        user.setUser(userProfile);
        user.setIdentityType(identityType);
        user.setAccount(account);
        user.setPassToken(passToken);
        userAuthDao.save(user);

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

        UserAuth user = userAuthDao.findByAccount(account);
        user.setPassToken(passToken);
        userAuthDao.save(user);

        return user;
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "/allUser")
    public List<UserAuth> userList(){
        return userAuthDao.findAll();
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping(value = "deleteUser/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userAuthDao.delete(id);
    }

}
