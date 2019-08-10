package rpc.proxy.dynamic3proxyFanxing;

import rpc.proxy.HelloIfc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 16:41
 **/
public class JDKDynamicProxy implements InvocationHandler {

    private Object target;
    public JDKDynamicProxy(Object target){
        this.target = target;
    }

    public HelloIfc getProxy() {
        return (HelloIfc) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("after");
        return result;

    }
}
