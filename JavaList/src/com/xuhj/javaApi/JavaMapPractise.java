package com.xuhj.javaApi;

import java.util.*;

public class JavaMapPractise {
    public static void main(String[] args) {
        /**
         * Map接口定义了双列集合的规范，K代表的是key，V代表的是Value，key一定不能相同，value可以相同
         *
         * Map常用的API接口
         *  public V put(K key, V value)将指定的键和值添加到map集合
         *  public V remove(Object key) 移除指定的键所对应的值，返回的是删除的键对应的值
         *  public V get(Object key) 获取对应值所对应的value值
         *  public Set<K> keySet() 将map中所有的键存储到一个Set集合中，由于key是没有重复的，存储到set中正好
         *  public Set<Map,Entry<K,V>> entrySet() 获取到Map集合中的所有的键值对的集合Set
         * */
        //创建HashMap对象  哈希表 元素的存取顺序不一样，集合肯定会有自己存储方式，你存入的方式正好和他的方式一样代表不了他有序
        HashMap<String,String> hashMap = new HashMap<String, String>();
        //         *  public V put(K key, V value)将指定的键和值添加到map集合
        hashMap.put("1","11");
        hashMap.put("2","22");
        hashMap.put("3","33");
        hashMap.put("4","44");
        //         *  public V remove(Object key) 移除指定的键所对应的值，返回的是删除的键对应的值
        String removeValue = hashMap.remove("4");
        System.out.println(removeValue);
        Set<String> keySet = hashMap.keySet();
        for(String keySingle : keySet){
            String keyValue = hashMap.get(keySingle);
            System.out.println(keySingle + "------" + keyValue);
        }
        /**
         * Map 中存放的是两种对象，一种称为key(键)，一种称为value(值)，它们在在 Map 中是一一对应关系，
         * 这一对对象又称做 Map 中的一个 Entry(项) 。 Entry 将键值对的对应关系封装成了对象。即键值对对象，
         * 这 样我们在遍历 Map 集合时，就可以从每一个键值对( Entry )对象中获取对应的键与对应的值。
         *  public K getKey() :获取Entry对象中的键。
         *  public V getValue() :获取Entry对象中的值。 在Map集合中也提供了获取所有Entry对象的方法:
         *  public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。
         * */
        //获取到每一个kv对象,这个就是相当于把Map中的每一个KV对象封装到Set集合中，就是把一对KV值封装成一个Entry，然后加入到Set中
        Set<Map.Entry<String,String>> entrySet = hashMap.entrySet();
        for(Map.Entry<String,String> entry : entrySet){
            System.out.println(entry.getKey() + "-----" + entry.getValue());
        }
        //HashMap的K值是自定义对象时，我们需要重写hasCode()和equals()方法，好用来判断k值的唯一性
        HashMap<StudentBo,String> studentBoStringHashMap = new HashMap<StudentBo,String>();
        studentBoStringHashMap.put(new StudentBo("xuhj1",23),"xuhj11");
        studentBoStringHashMap.put(new StudentBo("xuhj2",24),"xuhj22");
        studentBoStringHashMap.put(new StudentBo("xuhj3",25),"xuhj33");
        studentBoStringHashMap.put(new StudentBo("xuhj4",26),"xuhj44");
        studentBoStringHashMap.put(new StudentBo("xuhj5",27),"xuhj55");
        studentBoStringHashMap.put(new StudentBo("xuhj6",28),"xuhj66");
        studentBoStringHashMap.put(new StudentBo("xuhj7",29),"xuhj77");
        System.out.println(studentBoStringHashMap.size());
        //第一种遍历方式 keySet()
        Set<StudentBo> stuKeySet = studentBoStringHashMap.keySet();
        for(StudentBo stuSingle : stuKeySet){
            System.out.println(stuSingle.getAge() + stuSingle.getName() + studentBoStringHashMap.get(stuSingle));
            /**
             * 23xuhj1xuhj11
             * 24xuhj2xuhj22
             * 25xuhj3xuhj33
             * 26xuhj4xuhj44
             * 27xuhj5xuhj55
             * 28xuhj6xuhj66
             * 29xuhj7xuhj77
             * */
        }
        System.out.println("------------------------");
        //第二种遍历方式 Entry项
        Set<Map.Entry<StudentBo,String>> entries = studentBoStringHashMap.entrySet();
        for(Map.Entry<StudentBo,String> entrySingle : entries){
            System.out.println(entrySingle.getKey().getAge() + entrySingle.getKey().getName() + entrySingle.getValue());
            /**
             * 23xuhj1xuhj11
             * 24xuhj2xuhj22
             * 25xuhj3xuhj33
             * 26xuhj4xuhj44
             * 27xuhj5xuhj55
             * 28xuhj6xuhj66
             * 29xuhj7xuhj77
             * */
        }
        //数据库中顺序查处数据->保存到hashMap中->再一个个的添加到List中，顺序不会变的，Map不强调顺序，只要有key值就能取出
        List<Map<String,StudentBo>> list = new ArrayList<Map<String,StudentBo>>();
        //如果想要保证存取顺序有序，可以使用LinkedHashMap，HashMap()的子类
        //定义  计算一个字符串中每个字符出现次数。
        Map<String,String> linkedHashMapChar = new LinkedHashMap<String, String>();
        Set<String> keySets = new LinkedHashSet<String>();
        String x1 = "aaaaaxxxx";
        char[] a = x1.toCharArray();
        for(char n : a){
            //遍历每一个字符，存入到set中
            keySets.add(n+"");
            //System.out.println(n);
        }
        for(String keySetSingle : keySets){
            int count = 0;
            for(int i =0;i<a.length;i++){
                if(keySetSingle.equals(a[i]+"")){
                    count++;
                    linkedHashMapChar.put(keySetSingle,String.valueOf(count));
                }
            }
            count =0;
        }
        Set<String> setss = linkedHashMapChar.keySet();
        for(String s : setss){
            System.out.println(s + "-------" + linkedHashMapChar.get(s));
        }


    }
}
