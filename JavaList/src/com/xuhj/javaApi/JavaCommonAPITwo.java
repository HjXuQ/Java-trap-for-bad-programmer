package com.xuhj.javaApi;

import java.util.Random;
import java.util.Scanner;

public class JavaCommonAPITwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //获取字符串
        //String a = scanner.nextLine();
       // int b = scanner.nextInt();
        //System.out.println(b);
        //System.out.println(a);
        Random r = new Random();
        //生成比10要小的数字，不能等于10
        System.out.println(r.nextInt(10) + 1);
        //String 类
        /**
         * public String() :初始化新创建的 String对象，以使其表示空字符序列。
         * public String(char[] value) :通过当前参数中的字符数组来构造新的String。
         * public String(byte[] bytes) :通过使用平台的默认字符集解码当前参数中的字节数组来构造新的String。
         * public boolean equals (Object anObject) :将此字符串与指定对象进行比较。
         * public boolean equalsIgnoreCase (String anotherString) :将此字符串与指定对象进行比较，忽略大小
         * 写。
         * public int length () :返回此字符串的长度。
         * public String concat (String str) :将指定的字符串连接到该字符串的末尾。
         * public char charAt (int index) :返回指定索引处的 char值。
         * public int indexOf (String str) :返回指定子字符串第一次出现在该字符串内的索引。
         * public String substring (int beginIndex) :返回一个子字符串，从beginIndex（包含）开始截取字符串到字符
         * 串结尾。
         * public String substring (int beginIndex, int endIndex) :返回一个子字符串，从beginIndex到
         * endIndex截取字符串。含beginIndex，不含endIndex。
         * */
        //         * public String() :初始化新创建的 String对象，以使其表示空字符序列。
        String s1 = new String("aaaaa");
        System.out.println(s1);
        //         * public String(char[] value) :通过当前参数中的字符数组来构造新的String。
        String s2 = new String(new char[]{'a', 'b'});
        System.out.println(s2);
        //         * public String(byte[] bytes) :通过使用平台的默认字符集解码当前参数中的字节数组来构造新的
        String s3 = new String(new byte[]{97});
        System.out.println(s3);
        //         * public boolean equals (Object anObject) :将此字符串与指定对象进行比较。
        if(s1.equals(s2)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
        //         * public boolean equalsIgnoreCase (String anotherString) :将此字符串与指定对象进行比较，忽略大小
        if(s1.equalsIgnoreCase(s2)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
        //         * public int length () :返回此字符串的长度。
        String name = "aaaabbbaaaabbbb";
        System.out.println("name" + name.length());
        //         * public String concat (String str) :将指定的字符串连接到该字符串的末尾。
        System.out.println(name.concat(new String("ćccccc")));
        //         * public char charAt (int index) :返回指定索引处的 char值。
        System.out.println(name.charAt(1));
        //         * public int indexOf (String str) :返回指定子字符串第一次出现在该字符串内的索引。
        System.out.println(name.indexOf('a'));
        //public String substring (int beginIndex) :返回一个子字符串，从beginIndex(包含)开始截取字符串到字符串结尾。
        System.out.println(name.substring(2));
        //public String substring (int beginIndex, int endIndex) :返回一个子字符串，从beginIndex到
        //         * endIndex截取字符串。含beginIndex，不含endIndex。
        System.out.println(name.substring(2,6));



    }
}
