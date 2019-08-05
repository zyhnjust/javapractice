package com.htest.rpc.gmall.service;

import com.htest.rpc.gmall.bean.UserAddress;

import java.util.List;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-04 20:52
 **/
public interface OrderService {

    /**
     * init the order
     * @param userId
     * @return
     */
    public List<UserAddress> initOrder(String userId);

}
