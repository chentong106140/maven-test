/*
 * Copyright (C) 2006-2022 chentong All rights reserved
 * PROJECT_NAME: maven-test
 * Author: morgan
 * Date: 2022/5/20
 * Description: AccountEmailException.java
 * PACKAGE_NAME: com.chentong.mvnbook.account.email
 * NAME: AccountEmailException
 * USER: cherish
 * TIME: 14:37
 */
package com.chentong.mvnbook.account.email;

import javax.mail.MessagingException;

/**
 * @author morgan
 */
public class AccountEmailException extends MessagingException {
    private static final long serialVersionUID = -4817386460334501672L;

    public AccountEmailException() {
    }

    public AccountEmailException(String message) {
        super(message);
    }

    public AccountEmailException(String message, Exception cause) {
        super(message, cause);
    }
}
