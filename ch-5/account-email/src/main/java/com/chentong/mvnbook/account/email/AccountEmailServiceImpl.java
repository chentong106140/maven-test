/*
 * Copyright (C) 2006-2022 chentong All rights reserved
 * PROJECT_NAME: maven-test
 * Author: morgan
 * Date: 2022/5/20
 * Description: AccountEmailServiceImpl.java
 * PACKAGE_NAME: com.chentong.mvnbook.account.email
 * NAME: AccountEmailServiceImpl
 * USER: cherish
 * TIME: 14:40
 */
package com.chentong.mvnbook.account.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author morgan
 */
public class AccountEmailServiceImpl implements AccountEmailService {

    private JavaMailSender javaMailSender;
    
    private String systemEmail;
    
    @Override
    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {
        
        try{
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
            
            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText,true);
            System.out.println("systemEmail:"+systemEmail);
            System.out.println("htmlText:"+htmlText);
            javaMailSender.send(msg);
        }catch (MessagingException e){
            throw new AccountEmailException("Faild to send mail.",e);
        }
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
