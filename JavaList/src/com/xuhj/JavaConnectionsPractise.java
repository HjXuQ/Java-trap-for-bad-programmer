package com.xuhj;

import java.util.ArrayList;
import java.util.Collection;

//类名遵守阿里巴巴开发技术书册 UpperCamelCase
//List学习
public class JavaConnectionsPractise {
    public static void main(String[] args) {
        /**
         * 1.集合和数组的区别
         *  1.长度区别
         *      1.数组固定长度
         *      2.集合可变长度
         *  2.内容区别
         *      1.数组可以是引用类型（Person[] ps = new Person[8];），也可以是基本类型
         *      2.集合只能是引用类型
         *  3.元素种类
         *      1.数组只能存储一种类型
         *      2.集合可以存储多种类型(一般在实际应用中都是存储一种类型)
         * */

        /**
         * Collection接口 双列集合
         * ｜----List接口：元素按照先后顺序排序，允许有重复值
         * ｜-------｜LinkedList接口实现类：底层是链表，适合删除和插入操作，线程不安全，没有同步
         * ｜-------｜ArrayList接口实现类：底层是数组，适合查找操作，线程不安全，没有同步
         * ｜-------｜Vector接口实现类：底层是数组，适合查找操作，线程安全，同步，性能较差
         * ｜----Set接口：仅接受一次，不允许重复，并且内部自动排序
         * ｜-------｜HashSet：使用Hash表（数组）存储元素
         * ｜------------｜LinkHashSet：链表维护元素的插入顺序
         * ｜-------｜TreeSet：底层实现为二叉树，并且排好序
         *
         *
         *
         * Map 接口 键值对的集合 （双列集合）
         * ├———Hashtable 接口实现类， 同步， 线程安全
         * ├———HashMap 接口实现类 ，没有同步， 线程不安全-
         * │—————–├ LinkedHashMap 双向链表和哈希表实现
         * │—————–└ WeakHashMap
         * ├ ——–TreeMap 红黑树对所有的key进行排序
         * └———IdentifyHashMap
         * */

        /**
         * Collection的常用方法，每一个继承或者实现他的类都可以使用
         *
         * boolean add(E e)集合末尾添加元素
         * boolean remove(Object o)如果集合中存在和o相等的元素，那么删除他返回true
         * void clear()清空本类中所有的元素
         * boolean contains(Object o)判断集合中是否存在该元素
         * boolean isEmpty() 判断集合是否为空
         * int size() 返回集合的大小，也就是集合中有多少个元素
         * boolean addAll(Collection c)将参数中的类集的所有元素添加到另一个类集
         * Object[] toArray() 返回一个包含该集合所有元素的数组，就是将集合转化为数组形式
         * Iterator iterator() 集合的迭代器，集合的专用遍历方式
         * */
        //Collection方法演示
        //采用多态方式
        Collection<String> coll = new ArrayList<String>();
        //boolean add(E e)集合末尾添加元素
        coll.add("苹果");
        coll.add("桃子");
        //ArrayList可以插入重复元素
        coll.add("苹果");
        //boolean remove(Object o)如果集合中存在和o相等的元素，那么删除他返回true
        if (coll.remove("苹果")) {
            System.out.println("苹果元素被删除了");//苹果元素被删除了
        }
        //void clear()清空本类中所有的元素
        coll.clear();
        //boolean isEmpty() 判断集合是否为空
        if (coll.isEmpty()) {
            System.out.println("集合为空");//集合为空
        }
        //int size() 返回集合的大小，也就是集合中有多少个元素
        System.out.println("coll一共有" + coll.size() + "元素");//coll一共有0元素
        coll.add("苹果");
        coll.add("桃子");
        Collection<String> collCopy = new ArrayList<String>();
        collCopy.add("新增苹果");
        //boolean addAll(Collection c)将一个类集的所有元素添加到另一个类集
        //将coll中的元素全部添加到collCopy的尾部
        collCopy.addAll(coll);
        Object[] obj = collCopy.toArray();
        for (Object simpleObj : obj){
            System.out.println(simpleObj);//新增苹果   苹果    桃子
        }
        
    }
}
