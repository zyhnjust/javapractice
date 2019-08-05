package com.htest.study.rpc.dubbo.atguigudemo2.dubbo_springboot_consumer.controller;

import com.htest.rpc.gmall.bean.UserAddress;
import com.htest.rpc.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-05 07:23
 **/
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid")String userId) {
        return orderService.initOrder(userId);
    }

}
