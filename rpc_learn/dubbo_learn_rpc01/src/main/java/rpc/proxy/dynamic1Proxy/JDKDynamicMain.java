package rpc.proxy.dynamic1Proxy;

import rpc.proxy.HelloIfc;
import rpc.proxy.HelloImpl;

import java.lang.reflect.Proxy;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 17:00
 **/
public class JDKDynamicMain {

    public static void main(String[]  args){
        HelloIfc hello = new HelloImpl();
        JDKDynamicProxy helloProxy = new JDKDynamicProxy(new HelloImpl());
        hello = (HelloIfc) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                helloProxy
        );
        hello.say("world! ");
    }

}
