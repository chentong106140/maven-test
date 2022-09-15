/*
 * Copyright (C) 2006-2022 chentong All rights reserved
 * PROJECT_NAME: maven-test
 * Author: morgan
 * Date: 2022/5/24
 * Description: AccountEmailServiceTest.java
 * PACKAGE_NAME: com.chentong.mvnbook.account.email
 * NAME: AccountEmailServiceTest
 * USER: cherish
 * TIME: 10:06
 */
package com.chentong.mvnbook.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

import static org.junit.Assert.assertEquals;

/**
 * 测试类
 *
 * @author morgan
 */
public class AccountEmailServiceTest {
    private GreenMail greenMail;
    
    @Before
    public void startMailServer()
    throws Exception
    {
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test@juvenxu.com","123456");
        greenMail.start();
    }
    
    @Test
    public void testSendMail()
    throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
        
        String subject = "Test subject";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendMail("chentong@iqiguo.com",subject,htmlText);
        
        greenMail.waitForIncomingEmail(2000,1);
        
        Message[] msgs = greenMail.getReceivedMessages();
        assertEquals(1,msgs.length);
        assertEquals(subject,msgs[0].getSubject());
        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
        
        System.out.println(msgs.length);
        System.out.println(msgs[0].getSubject());
        System.out.println(GreenMailUtil.getBody(msgs[0]).trim());
    }
    
    @After
    public void stopMailServer() throws Exception{
        greenMail.stop();
    }
}
