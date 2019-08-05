package com.htest.rpc.gmall.service.impl;

import com.htest.rpc.gmall.bean.UserAddress;
import com.htest.rpc.gmall.service.OrderService;
import com.htest.rpc.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-04 21:48
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("user id " + userId);
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for(UserAddress userAddress: addressList){
            System.out.println(userAddress.getUserAddress());
        }
        return addressList;
    }
}
