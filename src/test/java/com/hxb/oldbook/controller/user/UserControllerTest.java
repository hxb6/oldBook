package com.hxb.oldbook.controller.user;

import com.hxb.oldbook.OldbookApplication;
import com.hxb.oldbook.pojo.User;
import com.hxb.oldbook.service.UserService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Package: com.hxb.oldbook.controller.user
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