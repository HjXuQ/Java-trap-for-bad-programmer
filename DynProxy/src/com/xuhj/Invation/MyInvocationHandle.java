package com.xuhj.Invation;

import com.xuhj.utis.DogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//不用一个专门的类来进行实现，其实完全可以写成内部类
public class MyInvocationHandle implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }
//    只调用这个方法来进行逻辑处理
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtils.method1();
        method.invoke(target,args);
        DogUtils.method2();
        return null;
    }
}
