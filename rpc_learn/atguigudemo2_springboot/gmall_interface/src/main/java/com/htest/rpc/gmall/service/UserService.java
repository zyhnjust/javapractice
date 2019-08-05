package com.htest.rpc.gmall.service;

import com.htest.rpc.gmall.bean.UserAddress;

import java.util.List;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-04 20:54
 **/
public interface UserService {

    /**
     * get all addrs via user id
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
