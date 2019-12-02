package top.top7.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.top7.dao.UserDao;
import top.top7.pojo.User;
import top.top7.service.UserService;

import java.util.List;


/**
 * Created by Administrator on 2019/12/2.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
