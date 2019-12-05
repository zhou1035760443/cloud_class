package top.top7.AlUtils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101700705849";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCKseyYB1UL/grMnnQ+B8nivTBrp3aXU5R/OBBWZkxsQ8YlSC9MIrICebJBIrE4uI7OgTbEemVXfvx+8PzkEG1VmVIKFOWg6qh6swmLxPMGWlOM6cDz1xym8RMZsJkARNQ5jJeVfmuI9w7lr+YPxFkmcC9fmDkjg337U1poOGvQVy/zYAy9Tv57ulRmLSepQ/2JI/L3ped9KAl9KyVy8hGv6+yXtG/13A6iy5V6/x3COISr+cNTE2/OHMgo5hmX3H4TemIKroyAf+BLpKgJ5BWqHIyZDKEa9xrdXVoj5u9+KDcVrsePYzR+ro+BMzC4DWb2DhUH0zJwffMz3XzZIzbrAgMBAAECggEAGstWzuQTvRZeFbvC7zzn9sLf+NxIX+HIvW8iUN7AguXxAMDaSlYll67VDhparH+TLzftUbXnoCirNQbvhEvcI35USBhTaGwNEm9GN9dbr+2BWKbMHQ+AvIu0SfFBDbk+WsPbgQkEU1iPazY5NvCS3Ictz8UDvOWpUAWBYMMNqRj2FnxwlZENtzVkFhCW8fLMcazEyJwyAp+3eJHhEva6QeNh4dKF/tmuwAYzBGM98Um4laLWgQGyrWGO5M4Y2XRu6SfEof1/YRxweCETNqlOCQNGZ/aCmEcMnOA0x3t7R3yhA7K7Ni7WLA4+M9KyTM6aq6PcTc7A4AuvgsGychXbIQKBgQDCQxQ02dikz+wV+8eX+/ISrUtH6IQkDEl/xsHTQnxJYTHXGbJDFRplkq8/pBImrfjAXeLnd8cT5d66LNRXg3BOKiIz/OPA/PfJ2MWQGHCraL8e7mT02TOpb8veckH3lLHtggGgKjfyHpUV84buly0ZARm4hiej0TfaDhbSNJkGuwKBgQC2xfsvnwGTmEqmHNIeswwcjIVLK5TM3etBDs3mgMa3iHYHjoo3XUZuIPmOiyhdE3zP8bzrWRSE2ajJxtTX8jnAjOg1TCBgf+Ah10+wfCWJEEP701vRZ4+fXk5hox8ZdPVwK15mhb3ialzXWcVzDLLxPsP08taCiPCox0ko25JFkQKBgQCJvpKnXwjU5HHcrKk8RXPCdop4tJBuFyBOsBpjuDL0vSxf/2J9WotbFoWZNLeCIb3OeUQZKL9KhqZFkOAIJbUOV6XlAx5ji3wP7ds4b3wErsNGJXgEfba6IAGI+6925EK9zH9mmEkPL0w7QnCc4SkjH7qjMs0MxZ86yN65sn4HXQKBgQC2CX/BEVQnpYGL6p6YNun0MTy8/p4IYWri9BS85DuHJmGv6xbcR4lTPIJxp0W/Vh50mab4nFNkcci7ls38emNs1KqeEsEYe6RG8ESNWUilN88OLJeBe+y+5NWaRzY9S5D8dCVkZQYXUKpBTkbq7JX40vOmropZnnxbDYlfKTmJEQKBgQCdX5Iz4SG96/bSqIb7YJJlSbGlVYqh/ZPqPffHxYCj3UKkupItL0roeBCqMUVVEd/3YppXPyvX2B4RyiyiutXDsAgCJKJQjZTzFDNzmnputiuTjGVyh+PhQHdGlY29v7oIzBn57xdIe+GEU7QJTEbFio5YmI5FurfJmVowvvFISQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAirHsmAdVC/4KzJ50PgfJ4r0wa6d2l1OUfzgQVmZMbEPGJUgvTCKyAnmyQSKxOLiOzoE2xHplV378fvD85BBtVZlSChTloOqoerMJi8TzBlpTjOnA89ccpvETGbCZAETUOYyXlX5riPcO5a/mD8RZJnAvX5g5I4N9+1NaaDhr0Fcv82AMvU7+e7pUZi0nqUP9iSPy96XnfSgJfSslcvIRr+vsl7Rv9dwOosuVev8dwjiEq/nDUxNvzhzIKOYZl9x+E3piCq6MgH/gS6SoCeQVqhyMmQyhGvca3V1aI+bvfig3Fa7Hj2M0fq6PgTMwuA1m9g4VB9MycH3zM9182SM26wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}