package top.top7.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * Created by Administrator on 2019/12/5.
 */
@Component
public class UserEmail {

    @Autowired
     JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String MAIL_SENDER;
    //测试发送简单得邮件



    public void getEmail(String email) {
        String str="0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i=0;i<6;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String random=sb.toString();

        //存入session
        System.out.println(random);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //发件人
        simpleMailMessage.setFrom(MAIL_SENDER);
        //收件人
        simpleMailMessage.setTo(email);
        //设置主题
        simpleMailMessage.setSubject("网易云课堂");
        //设置内容
        simpleMailMessage.setText("您的登录验证码是："+random+"该验证码在3分钟内有效！");

        mailSender.send(simpleMailMessage);
    }
}
