package rpc.proxy.dynamic1Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("after");
        return result;

    }
}
