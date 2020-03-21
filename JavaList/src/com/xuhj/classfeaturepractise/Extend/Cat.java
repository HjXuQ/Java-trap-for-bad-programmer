package com.xuhj.classfeaturepractise;

public  class Cat extends Animal{
    @Override
    public void run() {
        System.out.println("小猫傍地走");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("cat show");
        System.out.println("------------");
    }
    public void go(){
        show();
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.go();
        cat.run();
        cat.show();

    }
}
