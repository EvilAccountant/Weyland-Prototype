package com.weyland.prototype.repository;

import com.weyland.prototype.domain.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/1/26 19:57
 * \* Description:
 * \
 */

public interface UserAuthRepository extends JpaRepository<UserAuth,String>{

    public UserAuth findUserByAccount(String account);

}
