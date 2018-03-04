package com.weyland.prototype.service;

import com.weyland.prototype.repository.ServantRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 22:55
 * \* Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServantServiceTest {

    @Autowired
    ServantRepository servantRepository;

    @Test
    public void checkStar() {
        String servantStar = "1";
        Integer star = Integer.parseInt(servantStar);
        Assert.assertEquals(new Integer(1) ,star);
    }
}