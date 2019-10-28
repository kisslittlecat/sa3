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
	private static final String ALIDM_SMTP_PORT = "25";//��"80"
	public void sendEmail(String url,String payload) throws UnsupportedEncodingException {
		// ���÷����ʼ��Ļ�������
        final Properties props = new Properties();
        // ��ʾSMTP�����ʼ�����Ҫ���������֤
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // ���ʹ��ssl����ȥ��ʹ��25�˿ڵ����ã�������������,
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
        // �����˵��˺ţ���д����̨���õķ��ŵ�ַ,����xxx@xxx.com
        props.put("mail.user", "blackcat@service.yangming886.work");
        // ����SMTP����ʱ��Ҫ�ṩ������(�ڿ���̨ѡ���ŵ�ַ��������)
        props.put("mail.password", "082679mgYM");
        // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // �û���������
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
        Session mailSession = Session.getInstance(props, authenticator);
        //mailSession.setDebug(true);
        //UUID uuid = UUID.randomUUID();
        //final String messageIDValue = "<" + uuid.toString() + ">";
        // �����ʼ���Ϣ
        MimeMessage message = new MimeMessage(mailSession){
            //@Override
            //protected void updateMessageID() throws MessagingException {
                //�����Զ���Message-IDֵ
                //setHeader("Message-ID", messageIDValue);
            //}
        };
        try {
        // ���÷������ʼ���ַ�����ơ���д����̨���õķ��ŵ�ַ,����xxx@xxx.com���������mail.user����һ�¡������û������Զ�����д��
        InternetAddress from = new InternetAddress("blackcat@service.yangming886.work", "blackcat");
        message.setFrom(from);
        //��ѡ�����û��ŵ�ַ
        Address[] a = new Address[1];
        a[0] = new InternetAddress("15827019922@cug.edu.cn");
        message.setReplyTo(a);
        // �����ռ����ʼ���ַ������yyy@yyy.com
        InternetAddress to = new InternetAddress(url);
        message.setRecipient(MimeMessage.RecipientType.TO, to);
        // �����ʼ�����
        message.setSubject("dear friend");
        // �����ʼ���������
        message.setContent(payload, "text/html;charset=UTF-8");
        
        Transport.send(message);
        }
        catch (MessagingException e) {
            String err = e.getMessage();
            // �����ﴦ��message���ݣ� ��ʽ�ǹ̶���
            System.out.println(err);
        }
	}
	public void sendEmailBatch(String[] urls,String payload) throws UnsupportedEncodingException  {
		// ���÷����ʼ��Ļ�������
        final Properties props = new Properties();
        // ��ʾSMTP�����ʼ�����Ҫ���������֤
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // ���ʹ��ssl����ȥ��ʹ��25�˿ڵ����ã�������������,
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
        // �����˵��˺ţ���д����̨���õķ��ŵ�ַ,����xxx@xxx.com
        props.put("mail.user", "blackcat@service.yangming886.work");
        // ����SMTP����ʱ��Ҫ�ṩ������(�ڿ���̨ѡ���ŵ�ַ��������)
        props.put("mail.password", "082679mgYM");
        // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // �û���������
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
        Session mailSession = Session.getInstance(props, authenticator);
        //mailSession.setDebug(true);
        //UUID uuid = UUID.randomUUID();
        //final String messageIDValue = "<" + uuid.toString() + ">";
        // �����ʼ���Ϣ
        MimeMessage message = new MimeMessage(mailSession){
            //@Override
            //protected void updateMessageID() throws MessagingException {
                //�����Զ���Message-IDֵ
                //setHeader("Message-ID", messageIDValue);
            //}
        };
        try {
        // ���÷������ʼ���ַ�����ơ���д����̨���õķ��ŵ�ַ,����xxx@xxx.com���������mail.user����һ�¡������û������Զ�����д��
        InternetAddress from = new InternetAddress("blackcat@service.yangming886.work", "blackcat");
        message.setFrom(from);
        //��ѡ�����û��ŵ�ַ
        Address[] a = new Address[1];
        a[0] = new InternetAddress("15827019922@cug.edu.cn");
        message.setReplyTo(a);
        // �����ռ����ʼ���ַ������yyy@yyy.com
        InternetAddress[] adds = new InternetAddress[2];
        adds[0] = new InternetAddress(urls[0]);
        adds[1] = new InternetAddress(urls[1]);
        message.setRecipients(Message.RecipientType.TO, adds);
        // �����ʼ�����
        message.setSubject("dear friend");
        // �����ʼ���������
        message.setContent(payload, "text/html;charset=UTF-8");
        
        Transport.send(message);
        }
        catch (MessagingException e) {
            String err = e.getMessage();
            // �����ﴦ��message���ݣ� ��ʽ�ǹ̶���
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