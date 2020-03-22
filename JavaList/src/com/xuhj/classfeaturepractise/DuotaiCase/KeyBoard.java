package com.xuhj.classfeaturepractise.DuotaiCase;

public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("键盘打开 鼠标一点一点");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭 鼠标一点一点");
    }
    public void type(){
        System.out.println("键盘点击");
    }
}
