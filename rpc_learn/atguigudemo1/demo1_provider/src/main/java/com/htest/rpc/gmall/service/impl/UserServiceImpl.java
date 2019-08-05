package com.htest.rpc.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.htest.rpc.gmall.bean.UserAddress;
import com.htest.rpc.gmall.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-04 21:05
 **/

public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1,"南京江宁","1", "李老师", "025-xxx","Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

        return Arrays.asList(address1, address2);
    }
}
