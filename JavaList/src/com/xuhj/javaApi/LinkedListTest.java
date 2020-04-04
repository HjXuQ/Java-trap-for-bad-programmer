package com.xuhj.javaApi;

import java.util.LinkedList;

/**
 * @Description
 * @ClassName LinkedList
 * @Author xuhj
 * @date 2020.03.30 23:00
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.push("4");
        for(String s : list){
            System.out.println(s);
        }
        list.pop();
        for(String s : list){
            System.out.println(s);
        }
        list.pop();
        for(String s : list){
            System.out.println(s);
        }

    }
}
