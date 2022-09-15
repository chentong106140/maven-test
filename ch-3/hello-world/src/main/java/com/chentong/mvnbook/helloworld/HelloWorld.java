/*
 * Copyright (C) 2006-2022 chentong All rights reserved
 * PROJECT_NAME: maven-test
 * Author: morgan
 * Date: 2022/5/18
 * Description: HelloWorld.java
 * PACKAGE_NAME: com.chentong.mvnbook.helloworld
 * NAME: HelloWorld
 * USER: cherish
 * TIME: 16:09
 */
package com.chentong.mvnbook.helloworld;

/**
 * mvn第一个类文件
 *
 * @author morgan
 */
public class HelloWorld {
    
    public String sayHello(){
        return "Hello Maven";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());
        
    }
}
