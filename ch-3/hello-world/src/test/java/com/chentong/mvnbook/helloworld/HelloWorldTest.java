/*
 * Copyright (C) 2006-2022 chentong All rights reserved
 * PROJECT_NAME: maven-test
 * Author: morgan
 * Date: 2022/5/18
 * Description: HelloWorldTest.java
 * PACKAGE_NAME: com.chentong.mvnbook.helloworld
 * NAME: HelloWorldTest
 * USER: cherish
 * TIME: 16:50
 */
package com.chentong.mvnbook.helloworld;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * mvn第一个类文件
 *
 * @author morgan
 */
public class HelloWorldTest {
    
    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals("Hello Maven", result);
    }
    
}
