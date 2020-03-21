package com.xuhj.javaApi;

import java.util.*;

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
         * ｜-------|LinkedList (非继承List接口，继承的是一个类)接口实现类：底层是链表，适合删除和插入操作，线程不安全，没有同步
         *             public class LinkedList<E>
         *                          extends AbstractSequentialList<E>
         *                                  implements List<E>, Deque<E>, Cloneable, Serializable
         * ｜-------｜ArrayList接口实现类：底层是数组，适合查找操作，线程不安全，没有同步
         *              public class ArrayList<E>
         *                          extends AbstractList<E>
         *                                  implements List<E>, RandomAccess, Cloneable, Serializable
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

        /**
         * 迭代器的使用
         * public Iterator iterator() 获取对应集合的迭代器对象便于遍历集合中的元素的
         * public E next() 获取下一个集合元素
         * public boolean hasNext() 判断是否还有下一个元素
         * 原理： 在遍历集合时，内部使用指针的方式来跟踪元素，在调用Iterator的next（）方法之前，指针会在第一个元素之前，不指向任何元素，
         * 当第一次调用next（）方法的时候，迭代器的索引会往前走一步，指向第一个元素值并且返回，
         * 在使用增强for循环遍历集合时，他的底层也是迭代器的原理，所以说再遍历的时候不能对集合进行删除和增加操作
         * 它用于遍历Collection和数组。通常只进行遍历元素，不要在遍历的过程中对集合元素进行增删操作。
         * */
        Iterator<String> it = collCopy.iterator();
        while(it.hasNext()){
            String s = it.next();//不能对s进行操作，如果删除元素的话就这么写,用迭代器对象进行删除，it.remove()
            if(s.equals("苹果")){
                it.remove();
            }
        }
        System.out.println(collCopy.size());//2

        /**
         * 增强的for循环使用   目标只能是Collection或者是数组
         *  for(元素类型 迭代参数 ： 遍历对象）{
         *      xxx
         *  }
         *
         * */
        //增强for循环遍历数组
        String[] arr = new String[]{"1","2","3","4"};
        for(String s : arr){
            System.out.println(s); // 1 2 3 4
        }
        //增强for循环遍历集合
        for(String s : collCopy){
            System.out.println(s); //新增苹果     桃子
        }

        /**
         * 在定义集合的时候，集合中可以存放任意对象类型，当对象被存储到集合后，这时就会被强转成Object类型，然后取出时就必须要进行类型转换
         * 但是当我们加了泛型之后，就代表这个集合里面只能存储这类对象，其他对象不能存储
         * 泛型的好处
         *      1.将运行期间的类型转换异常，改到编译期间就报错
         *      2.避免了类型转换的麻烦
         * ### 定义和使用含有泛型的类
         *
         * 定义格式：
         * ~~~
         * 修饰符 class 类名<代表泛型的变量> {  }
         * ~~~
         * 例如，API中的ArrayList集合：
         * ~~~java
         * class ArrayList<E>{
         *     public boolean add(E e){ }
         *
         *     public E get(int index){ }
         *    	....
         * }
         * ~~~
         * 使用泛型： 即什么时候确定泛型。
         * **在创建对象的时候确定泛型**
         *  例如，`ArrayList<String> list = new ArrayList<String>();`
         * 此时，变量E的值就是String类型,那么我们的类型就可以理解为：
         * ~~~java
         * class ArrayList<String>{
         *      public boolean add(String e){ }
         *
         *      public String get(int index){  }
         *      ...
         * }
         * ~~~
         * 再例如，`ArrayList<Integer> list = new ArrayList<Integer>();`
         * 此时，变量E的值就是Integer类型,那么我们的类型就可以理解为：
         * ~~~java
         * class ArrayList<Integer> {
         *      public boolean add(Integer e) { }
         *
         *      public Integer get(int index) {  }
         *      ...
         * }
         * ~~~
         * 举例自定义泛型类
         * ~~~java
         * public class MyGenericClass<MVP> {
         * 	//没有MVP类型，在这里代表 未知的一种数据类型 未来传递什么就是什么类型
         * 	private MVP mvp;
         *
         *     public void setMVP(MVP mvp) {
         *         this.mvp = mvp;
         *     }
         *
         *     public MVP getMVP() {
         *         return mvp;
         *     }
         * }
         * ~~~
         * 使用:
         *
         * ~~~java
         * public class GenericClassDemo {
         *   	public static void main(String[] args) {
         *          // 创建一个泛型为String的类
         *          MyGenericClass<String> my = new MyGenericClass<String>();
         *          // 调用setMVP
         *          my.setMVP("大胡子登登");
         *          // 调用getMVP
         *          String mvp = my.getMVP();
         *          System.out.println(mvp);
         *          //创建一个泛型为Integer的类
         *          MyGenericClass<Integer> my2 = new MyGenericClass<Integer>();
         *          my2.setMVP(123);
         *          Integer mvp2 = my2.getMVP();
         *     }
         * }
         * ~~~
         * 泛型的知识待补充～还要好好爬坑·
         * */

        //这个系列中的一小节以一个程序结束
        /**
         *   按照斗地主的规则，完成洗牌发牌的动作。
         *         具体规则：
         *
         *         使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
         */
        /**
         * 1.    54张牌 我们创建两个集合，一个存放数字，一个存放花色，然后两个依次搭配，然后存入到一个新的集合里面
         * 2.    我们对54张扑克牌进行%3，不同的进行分配
         * */
        //创建一个总的扑克牌List存储54张牌
        List<String> pokerBox = new ArrayList<String>();
        //创建数字集合
        List<String> numberList = new ArrayList<String>();
        for(int i = 2;i <= 10;i++){
            numberList.add(i+"");
        }
        //创建花色集合
        List<String> colorsList = new ArrayList<String>();
        colorsList.add("♥");
        colorsList.add("♦");
        colorsList.add("♠");
        colorsList.add("♣");
        //循环两种集合进行自由搭配
        for(String numberlist : numberList){
            for(String colorslist : colorsList){
                String pokerBoxEle = numberlist+colorslist;
                pokerBox.add(pokerBoxEle);
            }
        }
        pokerBox.add("J");
        pokerBox.add("Q");
        pokerBox.add("K");
        pokerBox.add("A");
        pokerBox.add("小😊");
        pokerBox.add("大😊");
        //洗牌
        Collections.shuffle(pokerBox);
        //每一个人是一个List数组
        List<String> person1 = new ArrayList<String>();
        List<String> person2 = new ArrayList<String>();
        List<String> person3 = new ArrayList<String>();
        List<String> bottomPoker = new ArrayList<String>();
        for(int i =0;i < pokerBox.size();i++){
            String singleEle = pokerBox.get(i);
            if(i > 51){
                //留下最后三张牌
                bottomPoker.add(singleEle);
            }else{
                if(i % 3 == 0){
                    person1.add(singleEle);
                }else if(i % 3 == 1){
                    person2.add(singleEle);
                }else {
                    person3.add(singleEle);
                }
            }

        }
        System.out.println("小红"  + person1.toString());//小红[9♣, 10♦, 4♣, 5♠, 10♥, 7♣, 大😊, 2♣, 9♦, 7♠, 2♦, 3♠, K, 4♥]
        System.out.println("小明"  + person2.toString());//小明[5♣, 5♥, 4♦, 9♥, 4♠, 8♦, 2♠, 6♠, 3♣, A, 9♠, Q, 6♥, 10♣]
        System.out.println("小白"  + person3.toString());//小白[6♣, 3♥, 8♠, 小😊, 10♠, 7♦, 6♦, 3♦, 5♦, 8♣, 8♥, J, 2♥, 7♥]
    }
}
