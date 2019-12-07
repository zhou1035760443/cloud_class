package top.top7.service;

import top.top7.Response.UserResponse;
import top.top7.pojo.User;

/**
 * Created by Administrator on 2019/12/2.
 */
public interface UserService {

    //删除用户
    public String deleteById(User user);


    //修改一个用户信息
    public User saveAndFlush(User user);
    public User findById(Integer id);

    //查询所有用户
    public UserResponse findAll(Integer size, Integer page);




    //登录
//    public User login(User user);

    //注册
    public Integer register(User user);

    //名字或电话查询用户
    public User findUserByNameOrTel(String userTel);
}
