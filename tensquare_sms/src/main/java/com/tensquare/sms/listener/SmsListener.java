package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息消费者
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    /**
     * 模版CODE: SMS_163432310
     */
    @Value("${aliyun.sms.template_code}")
    private String template_code;

    /**
     * 签名名称
     */
    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void executeSms(Map<String, String> map) {
        String mobile = map.get("mobile");
//        String checkcode = map.get("checkcode");
        String code = map.get("code");//模版内容: 你的验证码为${code}

        System.out.println("手机号：" + map.get("mobile"));
//        System.out.println("验证码：" + map.get("checkcode"));
        System.out.println("验证码：" + map.get("code"));

        try {
//            smsUtil.sendSms(mobile, template_code, sign_name, "{\"checkcode\":\"" + checkcode + "\"}");
            smsUtil.sendSms(mobile, template_code, sign_name, "{\"code\":\"" + code + "\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
