/*
 * Copyright (C) 2006-2016 QiGuo All rights reserved
 * Author: Cherish
 * Date: 2022/5/20
 * Description:AccountEmailService.java
 */
package com.chentong.mvnbook.account.email;

/**
 * 发送邮件接口
 *
 * @author Cherish
 */
public interface AccountEmailService {
    void sendMail(String to , String subject , String htmlText) throws AccountEmailException;
}
