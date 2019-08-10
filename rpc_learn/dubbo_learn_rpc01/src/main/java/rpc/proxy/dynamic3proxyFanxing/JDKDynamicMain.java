package rpc.proxy.dynamic3proxyFanxing;

import rpc.proxy.HelloIfc;
import rpc.proxy.HelloImpl;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 17:00
 **/
public class JDKDynamicMain {

    public static void main(String[]  args){
        JDKDynamicProxy dynamicProxy = new JDKDynamicProxy(new HelloImpl());
        HelloIfc hello = dynamicProxy.getProxy();
        hello.say("world! ");
    }



}
