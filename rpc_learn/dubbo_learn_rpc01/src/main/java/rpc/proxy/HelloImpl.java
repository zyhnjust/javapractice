package rpc.proxy;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 16:19
 **/
public class HelloImpl implements HelloIfc {
    @Override
    public String say(String name) {
        System.out.println("Hello "+ name);
        return "Hello " + name;
    }
}
