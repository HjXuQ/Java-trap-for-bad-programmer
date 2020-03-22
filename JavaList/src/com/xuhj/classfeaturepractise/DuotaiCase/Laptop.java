package com.xuhj.classfeaturepractise.DuotaiCase;

public class Laptop {
    public void run(){
        System.out.println("电脑开启");
    }
    public void useUSB(USB usb){
        //判断是否有USB设备
        if(usb != null){
            usb.open();
            if(usb instanceof Mouse){
                ((Mouse) usb).click();
            }else if (usb instanceof KeyBoard){
                ((KeyBoard) usb).type();
            }
        }
        usb.close();
    }
    public void shutDown(){
        System.out.println("笔记本关闭");
    }
}
