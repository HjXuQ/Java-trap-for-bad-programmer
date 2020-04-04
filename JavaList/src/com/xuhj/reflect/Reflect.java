package com.xuhj.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Description 可以执行任何对象的任何方法
 * @ClassName Reflect
 * @Author xuhj
 * @date 2020.03.30 19:30
 */
public class Reflect {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        ClassLoader classLoader = Reflect.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("pro.properties");
        pro.load(in);
        String name = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        Class cls = Class.forName(name);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
