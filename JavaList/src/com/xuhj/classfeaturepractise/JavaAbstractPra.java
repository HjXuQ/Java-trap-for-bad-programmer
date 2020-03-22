package com.xuhj.classfeaturepractise;

import com.xuhj.classfeaturepractise.luckyMoney.Memeber;
import com.xuhj.classfeaturepractise.luckyMoney.Qunzhu;

import java.util.ArrayList;

public class JavaAbstractPra {
    /**
     * 关于抽象类的使用，以下为语法上要注意的细节，虽然条目较多，但若理解了抽象的本质，无需死记硬背。 1. 抽象类不能创建对象，如果创建，编译无法通过而报错。只能创建其非抽象子类的对象。
     * 理解:假设创建了抽象类的对象，调用抽象的方法，而抽象方法没有具体的方法体，没有意义。
     * 2. 抽象类中，可以有构造方法，是供子类创建对象时，初始化父类成员使用的。 理解:子类的构造方法中，有默认的super()，需要访问父类构造方法。
     * 3. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
     *  abstract class 类名字 { }
     *  理解:未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设
     * 计。
     * 4. 抽象类的子类，必须重写抽象父类中所有的抽象方法，否则，编译无法通过而报错。除非该子类也是抽象 类。
     * 理解:假设不重写所有抽象方法，则类中可能包含抽象方法。那么创建对象后，调用抽象的方法，没有 意义。
     * */
    //群主发红包
    public static void main(String[] args) {
        Qunzhu qunzhu = new Qunzhu("群主", 200.0);
        //从键盘输入
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入金额");
//        int money = sc.nextInt();
//        System.out.println("请输入份数");
//        int count = sc.nextInt();
        //发送红包
        ArrayList<Double> sendList = qunzhu.send(200,4);
        System.out.println(sendList.size());
        Memeber m = new Memeber();
        Memeber m1 = new Memeber();
        Memeber m2 = new Memeber();
        //打开红包
        m.openHongbao(sendList);
        m1.openHongbao(sendList);
        m2.openHongbao(sendList);
        //展示信息
        qunzhu.show();
        m.show();
        m1.show();
        m2.show();



    }
}
