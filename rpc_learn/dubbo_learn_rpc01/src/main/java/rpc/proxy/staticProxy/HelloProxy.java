package rpc.proxy.staticProxy;

import rpc.proxy.HelloIfc;
import rpc.proxy.HelloImpl;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 16:22
 **/
public class HelloProxy {
    public HelloIfc inf;

    public HelloProxy(){
        inf = new HelloImpl();
    }

    public String say(String name){
        String result;
        System.out.println("before");
        result = inf.say(name);
        System.out.println("after");
        return result;
    }
}
