package com.HZ.MyLife.utils;


import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by xsjdn on 2020/1/6.
 */
public class MailUtil {
    public static void sendMail(String to,String code){

        try {
            // 获得连接:
            Properties props = new Properties();
            Session session = Session.getInstance(props, new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("service@ml.com", "123");
                }

            });
            // 构建邮件:
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("service@ml.com"));
            // 设置收件人:
            // TO:收件人   CC:抄送   BCC:暗送,密送.
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
            // 主题:
            message.setSubject("来自MyLife的激活邮件!");
            // 正文:
            message.setContent("<h1>来自MyLife的激活邮件:请点击下面链接激活!</h1><h3><a href='http://localhost:8080/UserServlet?method=activeUser&code="+code+"'>http://localhost:8080/UserServlet?method=activeUser&code="+code+"</a></h3>", "text/html;charset=UTF-8");

            // 发送邮件:
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
