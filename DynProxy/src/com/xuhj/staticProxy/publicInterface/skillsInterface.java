package com.xuhj.staticProxy.publicInterface;

public interface skillsInterface {
    void swim();
    void sing();
}

/**
 *
 * 静态代理：
 *  代理对象和被代理对象都要实现这个公共接口，既然被代理对象要求和代理对象需要实现一样的功能，还要实现代理，这也就是说被代理对象需要存在代理对象的引用
 *  然后然后在实现的接口的方法里对直接的代理对象进行方法增强
 *
 *
 *  但是如果说实现该接口的方法太多，万一进行方法的扩展，那么所有的类都要进行实现，很麻烦，所以引入了动态代理
 * */