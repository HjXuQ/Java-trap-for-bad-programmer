package com.xuhj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaListPractise {
    /**
     *  List作为Collection的子接口，除了Collection的故有接口，List还定义了自己特色API
     *  public void add(int index,E element ) 往特定的索引上添加特定的元素
     *  public E get(int index) 获取到指定索引的元素
     *  public E remove(int index) 移除集合中指定索引处的元素，返回的是移除的value值
     *  public E set(int index,E element) 用指定的元素去替换指定元素的位置，返回的是替换前的元素
     * */
    public static void main(String[] args) {
        /**
         * ArrayList<>集合
         * */
        List<String> praList = new ArrayList<String>();
        praList.add("11");
        praList.add("22");
        praList.add("33");
        //*  public void add(int index,E element ) 往特定的索引上添加特定的元素,直接扩充，该位置及其往后的元素都往后移动
        praList.add(1,"44");//4
        System.out.println(praList.size());
        for(String s : praList){
            System.out.println(s); //11  44  22  33
        }
        //*  public E get(int index) 获取到指定索引的元素
        System.out.println(praList.get(3)); //  33
        //*  public E remove(int index) 移除集合中指定索引处的元素，返回的是移除的value值
        System.out.println(praList.remove(1)); //44
        //*  public E set(int index,E element) 用指定的元素去替换指定元素的位置，返回的是替换前的元素
        System.out.println(praList.set(2,"666")); // 33
        /**
         * LinkedList集合 底层数据结构是一个双向链表，查询慢，增删快
         * 找到头和尾有快速，里边有大量操作首尾元素的方法
         *  API：
         *      public void addFirst(E e)  将元素插入到此列表的开头
         *      public void addLast(E e)将元素插入到元素的结尾
         *      public E getFirst()返回列表的第一个元素
         *      public E getLast() 返回列表的最后一个元素
         *      public E removeFirst()  移除第一个元素
         *      public E removeLast()  移除最后一个元素
         *      public E pop() 从此列表中所表示的堆栈中弹出栈顶元素
         *      public E push() 从此列表所表示的栈顶中添加元素   栈：先进后出，pop，push
         *      public boolean isEmpty() 判断此列表是否为空
         * */
        /**
         * 这里为什么不写成多态形式呢，多态有个弊病就是不能调用子类特有的成员变量和成员方法
         * 多态：
         *  用父类的引用指向子类的实例，是一个动态绑定，运行时运行的都是调用子类的成员方法
         *         List<String> linkedList = new LinkedList<String>();
         *         多态存在一个方法调用的问题，如果一个函数在父类中有，但是在子类中没有，这时候会先去子类中找有没有该方法，有的话
         *         执行子类的方法，没有的话执行父类中的方法，如果一个函数在子类中，但是父类没有，那么会直接编译报错，这种情况会去编译类型中去找
         *         像addFirst()方法在子类中有，但是父类中没有，就找不出来，
         *         解决办法：编译类型就是LinkedList<String>
         * */

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("小红");
        linkedList.add("小白");
        linkedList.add("小江");
        linkedList.add("小春");
        //         *      public void addFirst(E e)  将元素插入到此列表的开头
        linkedList.addFirst("小小");
        //         *      public void addLast(E e)将元素插入到元素的结尾
        linkedList.addLast("小大");
        //         *      public E getFirst()返回列表的第一个元素
        String FirstEle = linkedList.getFirst();
        System.out.println(FirstEle);
        //         *      public E getLast() 返回列表的最后一个元素
        String LastEle = linkedList.getLast();
        System.out.println(LastEle);
        for(String linkedEle : linkedList){
            System.out.println(linkedEle);
        }
        //         *      public E removeFirst()  移除第一个元素
        String removeFirstEle = linkedList.removeFirst();
        System.out.println(removeFirstEle);
        //         *      public E removeLast()  移除最后一个元素
        String removeLastEle = linkedList.removeLast();
        System.out.println("移除最后一个元素" + removeLastEle);
        for(String linkedEle : linkedList){
            System.out.println(linkedEle);
        }
        //         *      public E pop() 从此列表中所表示的堆栈中弹出一个元素
        String popEle = linkedList.pop();
        System.out.println("pop---1" + popEle);
        String popEle2 = linkedList.pop();
        System.out.println("pop---2" + popEle2);
        //         *      public E push() 从此列表所表示的堆栈中添加一个元素,push进去的在栈顶
        linkedList.push("我是新加的");
        linkedList.push("我是新加的2");
        linkedList.push("我是新加的3");
        linkedList.push("我是新加的4");
        linkedList.push("我是新加的5");
        linkedList.push("我是新加的6");
        System.out.println("--------------------");
        for(String linkedEle : linkedList){
            System.out.println(linkedEle);
        }
        String popEle3 = linkedList.pop();
        System.out.println("pop---3" + popEle3);
        String popEle4 = linkedList.pop();
        System.out.println("pop---4" + popEle4);
        String popEle5 = linkedList.pop();
        System.out.println("pop---5" + popEle5);
        //         *      public boolean isEmpty() 判断此列表是否为空
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.size());
        if(linkedList.isEmpty()){
            System.out.println("我为空");
        }else{
            System.out.println("我有元素的");
        }
        for(String linkedEle : linkedList){
            System.out.println(linkedEle);
        }
    }

}
