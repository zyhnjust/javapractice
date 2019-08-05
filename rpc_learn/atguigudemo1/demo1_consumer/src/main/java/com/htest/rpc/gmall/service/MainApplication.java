package com.htest.rpc.gmall.service;

import com.htest.rpc.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-04 21:39
 **/
public class MainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = ac.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("finishe");
        System.in.read();
    }
}
