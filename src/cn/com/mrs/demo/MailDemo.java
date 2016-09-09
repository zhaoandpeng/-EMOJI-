package cn.com.mrs.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

//邮件发送测试DEMO
public class MailDemo {

	public static void main(String[] args) {  
        sendMultiMessage();  
  
    }  
	
	 public static void sendMultiMessage() {  
	      HtmlEmail email = new HtmlEmail();//用来发送HTML格式的email，除了有MultipartEmail的所有能力，还可以发送内嵌的图象  
//	      SimpleEmail  email = new SimpleEmail ();//用来发送基本的文本email  
//	      MultipartEmail email = new MultipartEmail();//该类用来发送Multipart 信息。他允许发送带附件的文本信息  
//	      EmailAttachment email = new EmailAttachment();//方便发送email的时候，进行附件处理。主要提供给MultipartEmail和HtmlEmail来使用  
	      
	      String[] multiPaths = new String[] {"C:\\trust_std_config\\conn\\1.txt"};//将上传的文件地址  
	      List<EmailAttachment> attachmentList = new ArrayList<EmailAttachment>();  
          
	      for (int i = 0; i < multiPaths.length; i ++) {  
	    	  EmailAttachment attachment = new EmailAttachment();//邮件附件对象  
	    	  if (multiPaths[i].indexOf("http") == -1) //是本地文件  
	    		  attachment.setPath(multiPaths[i]);  
	    	  else {  
	    		  try {  
	    			  attachment.setURL(new URL(multiPaths[i]));//设置url地址  
	    		  } catch (MalformedURLException e) {  
	    			  e.printStackTrace();  
	    		  }  
	    	  }  
              
	    	  attachment.setDisposition(EmailAttachment.ATTACHMENT);  
	    	  attachment.setDescription("测试邮件的发送");  
	    	  String name = multiPaths[i].substring(multiPaths[i].lastIndexOf("\\")+1);  
	    	  System.out.println("--------name:" + name);  
	    	  attachment.setName(name);//附件在邮件中显示的名字，中文的乱码问题没有解决，导致附件名有中文时显示乱码  
	    	  attachmentList.add(attachment);  
        }  
	          
	          
//	    EmailAttachment attachment = new EmailAttachment();  
//	    attachment.setPath("F:\\Photos\\min\\psb.jpg");  
//	    attachment.setDisposition(EmailAttachment.ATTACHMENT);  
//	    attachment.setDescription("测试邮件的发送");  
//      attachment.setName("psb.jpg");  
	          
        try {  
            email.setHostName("mail.cairenhui.com");//发送服务器的名字  
            email.setCharset("utf-8");//设置编码集  
            email.addTo("huangrq@cairenhui.com");//收件人邮箱  
            email.setFrom("zhaopeng@cairenhui.com");//发送人邮箱  
            email.setAuthentication("zhaopeng", "Zp91803223");//发件人的用户名与密码  
            email.setSubject("这是一封测试邮件，请不要回复！");//发送主题（邮件主题）  
            email.setMsg("<b><a href=\"http://www.google.com\"> 邮件测试内容</a></b>");//邮件内容  
              
            for (int j = 0; j < attachmentList.size(); j ++)   
                email.attach(attachmentList.get(j));//添加多个附件  
//	          email.attach(attachment);  
            email.send();//发送  
            System.out.println("发送完成");  
        } catch (EmailException e) {  
            e.printStackTrace();  
        }  
	          
	 }  
}
