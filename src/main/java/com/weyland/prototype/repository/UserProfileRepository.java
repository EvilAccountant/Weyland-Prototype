package com.weyland.prototype.repository;

import com.weyland.prototype.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/1/26 19:58
 * \* Description:
 * \
 */

public interface UserProfileRepository extends JpaRepository<UserProfile,String> {
}
