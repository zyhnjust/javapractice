package com.htest.study.rpc.dubbo.atguigudemo2.dubbo_springboot_consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.htest.rpc.gmall.bean.UserAddress;
import com.htest.rpc.gmall.service.OrderService;
import com.htest.rpc.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-05 07:24
 **/
@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        // TODO Auto-generated method stub
        System.out.println("用户id："+userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;    }
}
