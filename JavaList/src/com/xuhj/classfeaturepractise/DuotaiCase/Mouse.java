package com.xuhj.classfeaturepractise.DuotaiCase;

public class Mouse implements USB {
    @Override
    public void open() {
            System.out.println("鼠标开启，一点一点");
    }

    @Override
    public void close() {
    System.out.println("鼠标关闭，一点一点");
    }
    public void click(){
        System.out.println("鼠标点击");
    }
}
