package com.hxb.oldBook.controller.user;

import com.hxb.oldBook.OldbookApplication;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Package: com.hxb.oldBook.controller.user
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 15:29
 * @Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OldbookApplication.class)
@EnableAutoConfiguration
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        User user = userService.selectByPrimaryKey(1);
    }
}