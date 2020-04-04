package com.xuhj.factoryProxy;

import com.xuhj.Invation.MyInvocationHandle;
import com.xuhj.targetClass.GunDog;
import com.xuhj.targetInterface.IDog;
import com.xuhj.utis.DogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyFactory {
    public static Object getProxy(Object target){
//        MyInvocationHandle m = new MyInvocationHandle();
//        m.setTarget(target);
//        getInterfaces 获得这个对象所实现的接口    newProxyInstance  用来创建一个对象的代理对象,见MyInvocationHandle类
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               //每通过反射用这个对象去调用自己的方法时，都会调用invoke这个方法
                DogUtils.method1();
                //method.invoke()  用来执行某个对象的目标方法
                System.out.println(args);
                method.invoke(target,args);
                DogUtils.method2();
                return null;
            }
        });
        return proxy;
    }

    public static void main(String[] args) {
        IDog dog = new GunDog();
        //这个才是真正的代理对象
        IDog realProxy = (IDog) MyProxyFactory.getProxy(dog);
        realProxy.run(); //调用的是invoke这个方法
        realProxy.jump();//每次调用接口中的方法，都是通过这个invoke这个方法进行实现的

    }
}