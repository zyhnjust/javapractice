package com.htest.rpc.gmall.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-04 21:15
 **/
public class MainApplication {

    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();

        System.in.read();
    }
}
