package com.xuhj.javaApi;

import java.util.ArrayList;
import java.util.List;

public class printListAddr {
    @Override
    public String toString() {
        return "printListAddr{}" + super.toString();
    }

    public static void main(String[] args) {
        String str = String.format("%5d:",10);
        System.out.println(str);
        List<printListAddr> listAddrs = new ArrayList<>();
        for(int i = 0; i<5;i++){
            listAddrs.add(new printListAddr());
        }
//        //直接输出list。调用toString()方法，调用每个元素类型的重写的或者是Object类的对象
//        System.out.println(listAddrs);
//        printListAddr printListAddr1 = new printListAddr();
//        System.out.println(printListAddr1);
    }
}
