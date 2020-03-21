package com.xuhj.javaApi;

import java.util.*;

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
        //如果我们往集合中存放自定义的对象，那么保证其唯一， 就必须复写hashCode和equals方法建立属于当前对象的比较方式。就是说要对哪些成员变量进行比较，判断不同元素进行插入
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
            //因为我重写了hasCode()方法和equals()方法，需要判断两个成员变量一起判断，所以说在age相同但是name不同的话，也是不同元素
            /**
             * name1----12
             * name2----12
             * name3----12
             * */
        }
        //  LinkedHashSet
        //Set集合保证元素是唯一的，但是里面的元素是无序的，我们想要有序，我们可以用其子类，LinkHashSet函数
        Set<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("111");
        linkedHashSet.add("222");
        linkedHashSet.add("333");
        Iterator it = linkedHashSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            /**
             * 111
             * 222
             * 333  说明是有序的
             * */
        }
        String[] str = new String[]{"1","2","3","4"};
        JavaSetPractise javaSetPractise = new JavaSetPractise();
        javaSetPractise.getArray(str);
        //Collections 的常用方法
        /**
         *   public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
         *   public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。
         *   public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
         *   public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排
         * */
        ArrayList<Integer> intList = new ArrayList<Integer>();
        //         *   public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
        Collections.addAll(intList,1,2,3,3,4,5);
        //         *   public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。
        Collections.shuffle(intList);
        for(Integer integer : intList){
            System.out.println(integer);
        }
        //默认升序排序   *   public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
        Collections.sort(intList);
        for(Integer integer : intList){
            System.out.println(integer);
        }
        ArrayList<StudentBo> studentBos = new ArrayList<StudentBo>();
        StudentBo studentBo1 = new StudentBo("name1",2);
        StudentBo studentBo2 = new StudentBo("name1",1);
        StudentBo studentBo3 = new StudentBo("name1",5);
        StudentBo studentBo4 = new StudentBo("name1",0);
        Collections.addAll(studentBos,studentBo1,studentBo2,studentBo3,studentBo4);
        System.out.println(studentBos.size());
        Collections.sort(studentBos, new Comparator<StudentBo>() {
            @Override
            public int compare(StudentBo o1, StudentBo o2) {
                //升序排序
                return o1.getAge() - o2.getAge();
            }
        });
        for(int i =0 ;i<studentBos.size();i++){
            System.out.println("我是第" + i + "个" + studentBos.get(i).getAge());
        }

    }
    //可变参数的写法
    public void getArray(String... args){
        for (String s : args){
            System.out.println(s);
        }
    }
}
