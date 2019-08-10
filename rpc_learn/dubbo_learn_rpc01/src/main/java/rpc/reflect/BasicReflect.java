package rpc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 14:42
 **/
public class BasicReflect {

    public static void main(String[] args) throws Throwable {

        /*
         首先获取类的三种办法。
         */
        methodClass mc = new methodClass();
        Class cl1 = mc.getClass();
        Class cl2 = methodClass.class;
        Class cl3 = Class.forName("rpc.reflect.methodClass");
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);

        Class<?> c = methodClass.class;
        System.out.println(c);
        System.out.println(c.newInstance());

        // 构建一个对象
        Object object = c.newInstance();

        // 查看方法 以及返回值各种
        for(int i=0;i< c.getMethods().length; i++){
            System.out.println(c.getMethods()[i]);
        }
        System.out.println(c.getName());
        Method[] declaredMethods = c.getDeclaredMethods();
        for(int i=0;i< declaredMethods.length; i++){
            System.out.println(declaredMethods[i]);
            Class returntype = declaredMethods[i].getReturnType();
            System.out.println(returntype.getName());
            System.out.println(declaredMethods[i].getName());
            Class[] paramTypes = declaredMethods[i].getParameterTypes();
            for(Class c1: paramTypes){
                System.out.println(c1.getName());
            }
            System.out.println();
        }

        // 查看某个方法
        Method method = c.getMethod("add", int.class, int.class);
        System.out.println("method: " + method);

        // 查看属性
        Field[] fs = c.getDeclaredFields();
        for(Field field: fs){
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            System.out.println("TypeName: " + typeName);
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }

        //执行层面 如何嗲用方法
        Object result = method.invoke(object, 1, 4);
        System.out.println("method.invoke(object, 1, 4):" + result);

        // 其他
        Class c4 = void.class;
        Class c5 = Double.class;
    }
}

class methodClass{
    public final int f = 3;
    public int add(int a, int b){
        return a+b;
    }
    public int divide(int a, int b){
        return a-b;
    }

}