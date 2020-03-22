package com.xuhj.classfeaturepractise.luckyMoney;

import java.util.ArrayList;
import java.util.List;

public class Qunzhu extends User {
    public Qunzhu(String name, Double leftMoney) {
        super(name, leftMoney);
    }

    public Qunzhu() {
    }
    public ArrayList<Double> send(int money,int count){
        //获取群主的余额
        //可以在非main方法里直接调用父类或者子类的方法
        double leftMoney = getLeftMoney();
        if(money > leftMoney){
            return null;
        }
        //设置群主余额
        setLeftMoney(leftMoney - money);
        //创建一个List集合保存余额
        List<Double> simple = new ArrayList<Double>();
        money = money * 100;
        //每一份的金额
        int m = money / count;
        //剩下的金额
        int l = money % count;
        for(int i =0;i < count - 1;i++){
            simple.add(m / 100.0);
        }
        if(l == 0){
            simple.add(m / 100.0);
        }else {
            simple.add((l + m ) / 100.0);
        }
        return (ArrayList<Double>) simple;
    }

}
