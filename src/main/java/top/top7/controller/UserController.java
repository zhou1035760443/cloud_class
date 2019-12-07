package top.top7.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.top7.Response.UserResponse;
import top.top7.email.SendTelCode;
import top.top7.pojo.User;
import top.top7.service.UserService;
import top.top7.utils.Msg2;
import top.top7.utils.SessionKey;
import top.top7.utils.TelCode;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created by Administrator on 2019/12/2.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SendTelCode sendTelCode;
    @Autowired
    private UserService userService;

    @RequestMapping("/findOne")
    public User findOne(@RequestBody User user) {
        Integer userId = user.getId();
        return userService.findById(userId);
    }

    //判断用户是否已登录
    @RequestMapping("/checkLogin")
    public Integer checkLogin(HttpSession session){
        Object attribute = session.getAttribute(SessionKey.User_Session);
        if(attribute instanceof User){
            User  user=(User) attribute;
            return user.getId();
        }
        return 0;
    }

    //修改一个用户信息
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.saveAndFlush(user);
    }

    //分页查询所有用户
    @RequestMapping("/findAll/{size}/{page}")
    public UserResponse findAll(@PathVariable("size") Integer size, @PathVariable("page") Integer page) {
        return userService.findAll(size, page);
    }

    //删除用户
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public String deleteById(@RequestBody User user) {

        return userService.deleteById(user);
    }


    /*===================================================================*/
    //手机登录
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public Integer login( User user, Model model,HttpSession session) {
        System.out.println(user);
        try {
            String userTel=user.getUserTel();
            String password=user.getPassword();


            //从安全管理器中获取主体对象
            Subject subject = SecurityUtils.getSubject();
            //构建令牌对象
            UsernamePasswordToken token = new UsernamePasswordToken(userTel,password);
            //赋身份信息
//            token.setUsername(userTel.toString());
//            //赋凭证信息
//            token.setPassword(user.get("password").toString().toCharArray());
            //使用主体的login方法判定用户的权限
            subject.login(token);
            if (subject.isAuthenticated()) {
                User userSession = userService.findUserByNameOrTel(userTel);
                session.setAttribute(SessionKey.User_Session,userSession);

                System.out.println( session.getAttribute(SessionKey.User_Session));
                System.out.println("登录成功");
                return 1;
            }
        } catch (UnknownAccountException e) {
            //账号不存在
            System.out.println("账号不存在");
            return 2;
        } catch (IncorrectCredentialsException e) {
            //密码不正确
            System.out.println("密码不正确");
            return 3;
        }
        return 4;
    }





    //用户注销操作
    @RequestMapping("/logout")
    public Integer logout(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//登出
        /*session.removeAttribute(SessionKey.User_Session);
        System.out.println(session.getAttribute(SessionKey.User_Session));*/
        System.out.println("退出登录");
        return 1;
    }


    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Msg2 register(User user, HttpSession session) {
                Msg2 msg2=new Msg2();

        Object attribute = session.getAttribute(SessionKey.TEL_CODE);
        if(attribute instanceof String) {
            String telCode = (String) attribute;
            System.out.println(telCode);
            if (user.getSalt().equals(telCode)){
                User userByNameOrTel = userService.findUserByNameOrTel(user.getUserTel());
                if(userByNameOrTel==null){
                    user.setSalt(null);
                    user.setStatus(1);
                    userService.register(user);
                    msg2.setInfo(1);
                }else {
                    msg2.setInfo(3);
                    msg2.setUserBack(null);
                }
            } else {
                user.setSalt(null);
                msg2.setInfo(2);
                msg2.setUserBack(user);
            }
        }

//自增不需要





//        Integer maxId = userService.maxId() + 1;
//        user.setId(maxId);
        //user.setStatus(1);

        /*Integer reg = userService.register(user);
        System.out.println(user);
        if (reg == 1) {
            System.out.println("注册成功");
            return 1;
        } else {
            System.out.println("注册失败");
            return 2;
        }*/




        return msg2;
    }

    @RequestMapping("/sendTelCode/{userTel}")
    public void sendTelCode(@PathVariable("userTel") String userTel,HttpSession session){

        //生成随机数
        String str="0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i=0;i<6;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String randomCode=sb.toString();

        session.setAttribute(SessionKey.TEL_CODE,randomCode);

        sendTelCode.sendCode(userTel,randomCode);
    }

}
