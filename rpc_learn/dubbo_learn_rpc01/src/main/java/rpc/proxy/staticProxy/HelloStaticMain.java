package rpc.proxy.staticProxy;

import rpc.proxy.HelloIfc;
import rpc.proxy.HelloImpl;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 16:29
 **/
public class HelloStaticMain {

    public static void main(String[] args){
        HelloIfc hello = new HelloImpl();
        HelloProxy proxy = new HelloProxy();
        proxy.say("World");
    }
}
