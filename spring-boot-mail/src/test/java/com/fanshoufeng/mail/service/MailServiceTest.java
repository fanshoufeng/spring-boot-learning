package com.fanshoufeng.mail.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailServiceTest {

    @Autowired
    private MailService mailService;

    private static final String to = "shoufeng.fan@aliyun.com";

    @Test
    void sendSimpleMail() {
        String subject = "test simple mail";
        String content = "hello this is simple mail";
        mailService.sendSimpleMail(to, subject, content);
    }

    @Test
    void sendHtmlMail() {
        String subject = "test simple mail";
        String content = "<html>\n" +
                "<body>\n" +
                "   <h3>hello world！这是一封Html邮件！</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(to, subject, content);
    }

    @Test
    void sendAttachmentsMail() {
        String subject = "主题：带附件的邮件";
        String content = "有附件，请查收！";
        String filePath = "D:\\temp\\application.log";
        mailService.sendAttachmentsMail(to, subject, content, filePath);
    }

    @Test
    void sendInlineResourceMail() {
        String subject = "主题：这是有图片的邮件";
        String rscId = "IMG_8190";
        String content = "<html><body>这是有图的邮件：<img src=\'cid:" + rscId + "\'></body></html>";
        String rscPath = "D:\\temp\\IMG_8190.JPG";
        mailService.sendInlineResourceMail(to, subject, content, rscPath, rscId);
    }
}