package com.xuhj.reflect.ReflectgetBin;

import com.xuhj.reflect.testRel.Person;

/**
 * @Description
 * @ClassName getObjBin
 * @Author xuhj
 * @date 2020.03.30 19:43
 */
public class getObjBin {
    public static void main(String[] args) throws ClassNotFoundException {
        //因为是即时编译的，所以已经有class文件了

        //将字节码文件加载进内存，返回Class对象
        Class cls1 = Class.forName("com.xuhj.reflect.testRel.Person");
        System.out.println(cls1);
        //已经在内存中了，获取它的二进制字节码文件
        Class cls2 = Person.class;
        System.out.println(cls2);
        //已经生成了他的对象获取其二进制文件
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        //也就是说类只会加载一次到内存

        //Java有三个阶段，第一个就是编译阶段，也就是源代码阶段，第二个就是Class对象阶段，也就是加载进内存了，第三个是运行时阶段，也就是具体到具体的对象类型了
        //每一种创建方式相对应的对应着三个不同的阶段
    }
}
