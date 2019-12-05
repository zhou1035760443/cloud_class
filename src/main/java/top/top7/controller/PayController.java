package top.top7.controller;

import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.top7.AlUtils.AlipayUtils;

/**
 * Created by Administrator on 2019/12/4.
 */
@RestController
public class PayController {

    @Autowired
    private AlipayUtils alipayUtils;

    @RequestMapping("/pay")

    public String pay(){
        String pay="";
        try {
            pay = alipayUtils.pay();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        return pay;
    }
}
