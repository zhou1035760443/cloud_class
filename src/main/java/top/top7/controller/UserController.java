package top.top7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.top7.pojo.User;
import top.top7.service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2019/12/2.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
}
