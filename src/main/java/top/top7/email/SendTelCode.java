package top.top7.email;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.top7.utils.SessionKey;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created by Administrator on 2019/12/6.
 */
@Component
public class SendTelCode {
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessSecret}")
    private String accessSecret;
    @Value("${aliyun.RegionId}")
    private String RegionId;
    @Value("${aliyun.SignName}")
    private String SignName;

    public String sendCode(String user_tel, String randomCode) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", RegionId);
        request.putQueryParameter("PhoneNumbers", user_tel);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", "SMS_179612117");
        request.putQueryParameter("TemplateParam", "{\"code\":"+randomCode+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

}
