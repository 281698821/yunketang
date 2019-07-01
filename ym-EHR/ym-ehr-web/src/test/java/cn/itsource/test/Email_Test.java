package cn.itsource.test;

import cn.itsource.utils.EmailUtills;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Email_Test {
    @Autowired
    JavaMailSenderImpl emailSender;
    @Autowired
    private EmailUtills emailUtills;
    @Value("${email.username}")
    private String  username;


    @Test
    public void testName() throws Exception{
        System.out.println(username);
    }


    // 简单邮件
    @Test
    public void SimpleMailMessage() throws Exception {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);//        发送人
        mailMessage.setTo("2671927629@qq.com");//          收件人
        mailMessage.setSubject("隐世集团");//               标题
        mailMessage.setText("隐无为-祝福你");            //            内容
        emailSender.send(mailMessage);
    }

    //  html 文件
    @Test
    public void htmlMailMessage() {
        MimeMessage mimeMsg = emailSender.createMimeMessage();
        try {
            String html = "<h1>隐世集团祝福你</h1><img src='https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547633928248&di=40201d947b60c782cfbded8eb1d300bf&imgtype=0&src=http%3A%2F%2Fs9.sinaimg.cn%2Fbmiddle%2F49ad91f449cee86567688%26690'/>";
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
            helper.setTo("2671927629@qq.com");
            helper.setFrom(username);
            helper.setSubject("隐世集团");
            helper.setText(html, true);
            emailSender.send(mimeMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUtils() throws Exception{
        emailUtills.sendMail(username,"hhh","xxx");
        System.in.read();
    }

    @Test
    public void testName1() throws Exception{
        emailUtills.sendHtmlMail(username,"<h1>xxx</h1>","<h1>活动详情：激情闪耀共创辉煌主题晚会<hr> 举办时间：Thu Dec 29 00:00:00 CST 2011<br> 活动地址：湖北武汉汉庭大酒店\n" +
                "湖北武汉汉庭大酒店</h1>");
        System.in.read();
    }

}