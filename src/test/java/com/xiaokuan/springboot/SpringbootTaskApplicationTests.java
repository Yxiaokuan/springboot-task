package com.xiaokuan.springboot;

import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    public void send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("开会通知");
        message.setText("下周放假");
        message.setFrom("1111111111@163.com");
        message.setTo("2222222222@qq.com");
        javaMailSender.send(message);
    }
    @Test //复杂邮件
    public void test() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
         messageHelper.setSubject("开会通知");
        messageHelper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

        //上传文件
        messageHelper.addAttachment("1.png",new File("D:\\picture\\1.png"));
        messageHelper.addAttachment("2.png",new File("D:\\picture\\2.png"));

        messageHelper.setFrom("11111111111@163.com");
        messageHelper.setTo("2222222222@qq.com");
        javaMailSender.send(message);
    }

}
