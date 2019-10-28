package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
	private static final String ALIDM_SMTP_HOST = "smtpdm.aliyun.com";
	private static final String ALIDM_SMTP_PORT = "25";//或"80"
	public void sendEmail(String url,String payload) throws UnsupportedEncodingException {
		// 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
        // 发件人的账号，填写控制台配置的发信地址,比如xxx@xxx.com
        props.put("mail.user", "blackcat@service.yangming886.work");
        // 访问SMTP服务时需要提供的密码(在控制台选择发信地址进行设置)
        props.put("mail.password", "082679mgYM");
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        //mailSession.setDebug(true);
        //UUID uuid = UUID.randomUUID();
        //final String messageIDValue = "<" + uuid.toString() + ">";
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession){
            //@Override
            //protected void updateMessageID() throws MessagingException {
                //设置自定义Message-ID值
                //setHeader("Message-ID", messageIDValue);
            //}
        };
        try {
        // 设置发件人邮件地址和名称。填写控制台配置的发信地址,比如xxx@xxx.com。和上面的mail.user保持一致。名称用户可以自定义填写。
        InternetAddress from = new InternetAddress("blackcat@service.yangming886.work", "blackcat");
        message.setFrom(from);
        //可选。设置回信地址
        Address[] a = new Address[1];
        a[0] = new InternetAddress("15827019922@cug.edu.cn");
        message.setReplyTo(a);
        // 设置收件人邮件地址，比如yyy@yyy.com
        InternetAddress to = new InternetAddress(url);
        message.setRecipient(MimeMessage.RecipientType.TO, to);
        // 设置邮件标题
        message.setSubject("dear friend");
        // 设置邮件的内容体
        message.setContent(payload, "text/html;charset=UTF-8");
        
        Transport.send(message);
        }
        catch (MessagingException e) {
            String err = e.getMessage();
            // 在这里处理message内容， 格式是固定的
            System.out.println(err);
        }
	}
	public void sendEmailBatch(String[] urls,String payload) throws UnsupportedEncodingException  {
		// 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
        // 发件人的账号，填写控制台配置的发信地址,比如xxx@xxx.com
        props.put("mail.user", "blackcat@service.yangming886.work");
        // 访问SMTP服务时需要提供的密码(在控制台选择发信地址进行设置)
        props.put("mail.password", "082679mgYM");
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        //mailSession.setDebug(true);
        //UUID uuid = UUID.randomUUID();
        //final String messageIDValue = "<" + uuid.toString() + ">";
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession){
            //@Override
            //protected void updateMessageID() throws MessagingException {
                //设置自定义Message-ID值
                //setHeader("Message-ID", messageIDValue);
            //}
        };
        try {
        // 设置发件人邮件地址和名称。填写控制台配置的发信地址,比如xxx@xxx.com。和上面的mail.user保持一致。名称用户可以自定义填写。
        InternetAddress from = new InternetAddress("blackcat@service.yangming886.work", "blackcat");
        message.setFrom(from);
        //可选。设置回信地址
        Address[] a = new Address[1];
        a[0] = new InternetAddress("15827019922@cug.edu.cn");
        message.setReplyTo(a);
        // 设置收件人邮件地址，比如yyy@yyy.com
        InternetAddress[] adds = new InternetAddress[2];
        adds[0] = new InternetAddress(urls[0]);
        adds[1] = new InternetAddress(urls[1]);
        message.setRecipients(Message.RecipientType.TO, adds);
        // 设置邮件标题
        message.setSubject("dear friend");
        // 设置邮件的内容体
        message.setContent(payload, "text/html;charset=UTF-8");
        
        Transport.send(message);
        }
        catch (MessagingException e) {
            String err = e.getMessage();
            // 在这里处理message内容， 格式是固定的
            System.out.println(err);
        }
	}
	public Boolean validateEmailAddress(String url) { 
		
	        Boolean res=false;
	        Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");  
	        Matcher m = p.matcher(url);  
	        boolean b = m.matches();  
	        if(b) {  
	            System.out.println("Y"); 
	            res=true;
	        } else {  
	            System.out.println("N");  
	        }   
	        return res;
	}
}