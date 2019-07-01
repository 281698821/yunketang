package cn.itsource.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailUtills {
    @Autowired
    JavaMailSenderImpl emailSender;

    @Value("${email.username}")
    private String  username;

    /**
     * 异步普通邮件工具方法
     * sendTo：收件人
     * title：标题
     * content：内容
     */
    @Async
    public void sendMail(String sendTo,String title,String content) throws Exception {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);//        发送人
        mailMessage.setTo(sendTo);//          收件人
        mailMessage.setSubject(title);//               标题
        mailMessage.setText(content);            //            内容
        emailSender.send(mailMessage);
    }

    /**
     * 异步html邮件工具方法
     * sendTo：收件人
     * title：标题
     * content：内容
     */
    @Async
    public void sendHtmlMail(String sendTo,String title,String content) {
        MimeMessage mimeMsg = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
            helper.setTo(sendTo);
            helper.setFrom(username);
            helper.setSubject(title);
            helper.setText(content, true);
            emailSender.send(mimeMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}