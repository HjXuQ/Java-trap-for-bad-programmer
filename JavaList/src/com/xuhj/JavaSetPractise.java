package com.xuhj;

import java.util.HashSet;
import java.util.Iterator;

public class JavaSetPractise {
    /**
     * Set 元素不能重复，并且无序 并没有对Collection接口做特色的补充，他的方法就是Collection中共有的方法
     *  HashSet底层其实是封装了一个HashSet
     *  HashSet 是根据对象的哈希值来确定元素在集合中的存储位置，因此具有良好的存取和查找性能。
     *  保证元素唯一性 的方式依赖于: hashCode 与 equals 方法。
     * */
    /**
     *
     /**
     * Collection的常用方法，每一个继承或者实现他的类都可以使用
     * boolean add(E e)集合末尾添加元素
     * boolean remove(Object o)如果集合中存在和o相等的元素，那么删除他返回true
     * void clear()清空本类中所有的元素
     * boolean contains(Object o)判断集合中是否存在该元素
     * boolean isEmpty() 判断集合是否为空
     * int size() 返回集合的大小，也就是集合中有多少个元素
     * boolean addAll(Collection c)将参数中的类集的所有元素添加到调用者的类集里面
     * Object[] toArray() 返回一个包含该集合所有元素的数组，就是将集合转化为数组形式
     * Iterator iterator() 集合的迭代器，集合的专用遍历方式
     * */
    public static void main(String[] args) {
        // HashSet 底层是数组+链表+红黑树
        //HashSet  存储已知类型
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("abc");
        hashSet.add("bac");
        hashSet.add("cab");
        for(String set : hashSet){
            System.out.println(set);
        }
        hashSet.remove("abc");
        System.out.println(hashSet.size());
        if(hashSet.contains("bac")){
            System.out.println("bac 存在");
        }
        hashSet.add("abc1");
        hashSet.add("bac2");
        hashSet.add("cab3");
        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//bac2 cab3 abc1 bac  cab  说明是无序的
        }
        //HashSet存储自定义对象元素
        //如果我们往集合中存放自定义的对象，那么保证其唯一， 就必须复写hashCode和equals方法建立属于当前对象的比较方式。就是说要对哪些成员变量进行比较
        //你重写了hashCode和equals方法，判断插入元素的时候用到哪些字段进行校验判断，就是说我要插入一条数据，我要根据这几个属性来判断是否和以前插入的一样
        StudentBo s1 = new StudentBo("name1",12);
        StudentBo s2 = new StudentBo("name2",12);
        StudentBo s3 = new StudentBo("name3",12);
        HashSet<StudentBo> hashSetStudentBo = new HashSet<StudentBo>();
        hashSetStudentBo.add(s1);
        hashSetStudentBo.add(s2);
        hashSetStudentBo.add(s3);
        for(StudentBo single : hashSetStudentBo){
            System.out.println(single.getName() + "----" + single.getAge());
            /**
             * name1----12
             * name2----12
             * name3----12
             * */
        }

    }
}
