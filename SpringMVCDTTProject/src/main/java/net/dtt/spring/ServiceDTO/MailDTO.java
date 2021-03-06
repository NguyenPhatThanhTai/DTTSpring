package net.dtt.spring.ServiceDTO;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.bytebuddy.asm.Advice.This;
import net.dtt.spring.Models.DAOModel.DetailOrdersDaoModel;
import net.dtt.spring.Models.DAOModel.OrdersDaoModel;

public class MailDTO {
	public boolean sendMail(String to, String subject, OrdersDaoModel order) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("herroseven@gmail.com", "@#Taitutoi952*000@#");
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress("UNIFY"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(Templte(order), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
        	e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public String Templte(OrdersDaoModel order) {
		String listTemplateString = "";
		for (DetailOrdersDaoModel orders : order.getDetailOrder()) {
			listTemplateString += "<i>" + orders.getProduct().getProductDetail().getName() + " x " + orders.getQuantity() + "</i><br>";
		}
		
		
		String Template = "<img src=\"https://cdn.discordapp.com/attachments/953479400467361813/964722518181171290/DTT_-_Shop_Cam_on_ban_1.png\"><br>"
				+ "<h1>Mail th??ng b??o ?????n kh??ch h??ng</h1>"
				+ "<h3><b>Kh??ch h??ng: </b> <i>"+order.getNameReceive()+"</i></h3>"
				+ "<h3><b>?????a ch???: </b> <i>"+order.getAddressReceive()+"</i></h3>"
				+ "<h3><b>SDT: </b> <i>"+order.getPhoneReceive()+"</i></h3>"
				+ "<h3>????n h??ng:</h3><br>"
				+ "<br>"

				+listTemplateString
				
				+ "<br>"
				+ "<h3>T???ng ti???n: "+order.getTotalPrice()+" VN??</h3>"
				+ "<br>"
				+ "<i>Hi???n t???i ????n h??ng ???? ???????c chu???n b??? ho??n th??nh v?? b??n giao cho b??n v???n chuy???n, xin c???m ??n qu?? kh??ch.</i><br>"
				+ "<br>"
				+ "<img src=\"https://cdn.discordapp.com/attachments/953479400467361813/964725960391946281/DTT_Shop.png\"><br>";
		
		return Template;
	}
}
