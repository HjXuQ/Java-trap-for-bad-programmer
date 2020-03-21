package com.xuhj.classfeaturepractise;

import java.util.ArrayList;
import java.util.Random;

public class Memeber extends User{
    public Memeber(String name, Double leftMoney) {
        super(name, leftMoney);
    }

    public Memeber() {
    }



    public void openHongbao(ArrayList<Double> list ){
        Random rd = new Random();
        int index =rd.nextInt(list.size());
        Double money = list.remove(index);
        setLeftMoney(money);
    }
}
