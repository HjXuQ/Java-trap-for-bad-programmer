package com.xuhj.File;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestCodingSwitch {
	//修改提交语句
    public static void main(String[] args) {
        String testString = "你好啊是啊";
        try {
            //编码 //查看分支树
            byte[] utf = testString.getBytes("UTF-8");
            byte[] gbk = testString.getBytes("GBK");
            byte[] iso = testString.getBytes("ISO-8859-1");
            System.out.println("utf-8" + Arrays.toString(utf));
            System.out.println("gbk" + Arrays.toString(gbk));
            System.out.println("iso" + Arrays.toString(iso));
            byte[] a = new String(gbk,"ISO-8859-1").getBytes("ISO-8859-1");
            System.out.println(new String(a,"GBK"));
            System.out.println("--------------------");
            //解码
            String utf2 = new String(utf,"UTF-8");
            System.out.println("utf2 " + utf2);
            String gbk2 = new String(utf,"GBK");
            System.out.println(Arrays.toString(gbk2.getBytes("GBK")));
//			System.out.println(Arrays.toString(gbk2.getBytes("GBK")));
            System.out.println("gbk2 " + gbk2);
            String gbk3 = new String(gbk,"UTF-8");
//			System.out.println(Arrays.toString(gbk3.getBytes("GBK")));
            System.out.println("gbk3 " + gbk3);
            String regbkString = new String(gbk3.getBytes("UTF-8"),"GBK");
            System.out.println("regbkString" + regbkString);
            String reutfString =  new String(gbk2.getBytes("GBK"),"UTF-8");
            System.out.println("reytf" + reutfString);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //以下是转换规则：UTF-8三个字节一个汉字，GBK两个字节一个汉字
        //汉字用GBK编码用UTF-8解码后，再用UTF-8对解码后的字节数组进行编码。用GBK对字节数组编码会产生乱码，是不可逆的
        //汉字用UTF-8编码经过GBK解码之后，在经过GBK编码，再经过UTF-8编码，奇数个字有问题，偶数个字没有问题
        //GBK和UTF-8经过ISO-8859-1解码，然后再用ISO-8859-1编码，在经过GBK或者UTF-8解码是没有问题的，所以ISO-8859-1是安全的编码格式。
    }
}

