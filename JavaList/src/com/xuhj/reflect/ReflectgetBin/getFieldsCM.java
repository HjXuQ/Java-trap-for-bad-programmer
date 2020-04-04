package com.xuhj.reflect.ReflectgetBin;

import com.xuhj.reflect.testRel.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description
 * @ClassName getFieldsCM
 * @Author xuhj
 * @date 2020.03.30 20:00
 */
public class getFieldsCM {
    public static void main(String[] args) throws Exception {
        /**
         * 获取对象功能
         *  *获取功能
         *      1.获取成员变量们
         *          * Field getFields() 获取所有Public修饰的变量
         *          * Field getField(String name)
         *          * Field[] getDeclaredFields()
         *          * Field getDeclaredField(String name)
         *          2. 获取构造方法们
         *              * Constructor<?>[] getConstructors()
         *              * Constructor<T> getConstructor(类<?>... parameterTypes)
         *
         *              * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         *              * Constructor<?>[] getDeclaredConstructors()
         *          3. 获取成员方法们：
         *              * Method[] getMethods()
         *              * Method getMethod(String name, 类<?>... parameterTypes)
         *
         *              * Method[] getDeclaredMethods()
         *              * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         *
         *          4. 获取类名
         *              * String getName()
         * */

        //获取Person的成员变量
         Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for(Field field : fields){
            System.out.println(field);
        }
        System.out.println("-----------");
        //取值
        Field todayNew = personClass.getField("today");
        Person p = new Person();
        Object value  = todayNew.get(p);
        System.out.println(value);
        //设置值
        todayNew.set(p,new Date());
        System.out.println(p);

        System.out.println("=============");
        //获取所有的成员变量，不考虑修饰符
         Field[] fields1 = personClass.getDeclaredFields();
         for(Field field : fields1){
             System.out.println(field);
         }
         //根据名称获得相对应的列
        Field d = personClass.getDeclaredField("today");
         //忽略访问修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);

        //获取构造方法
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("华杰",12);
        System.out.println(person);

        System.out.println("-------");
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        //创建对象
        Object person2 = constructor1.newInstance();
        System.out.println(person2);

        //还可以这样创建，直接在Class中创建，这样创建的是没有参数的构造方法
        Object person3 = personClass.newInstance();
        System.out.println(person3);

        Method show = personClass.getMethod("show");
        Person p1 = new Person();
        show.invoke(p1);

        Method method = personClass.getMethod("eat",String.class);
        method.invoke(p1,"饭");

        System.out.println("=========");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for(Method method1 : methods){
            System.out.println(method1);
            String name = method1.getName();
            System.out.println(name);
        }
        //获取类名
        String className = personClass.getName();
        System.out.println(className);
    }
}
