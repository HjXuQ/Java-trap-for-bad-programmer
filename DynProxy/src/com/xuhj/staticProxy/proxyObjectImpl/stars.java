package com.xuhj.staticProxy.proxyObjectImpl;

import com.xuhj.staticProxy.publicInterface.skillsInterface;

public class stars implements skillsInterface {
    @Override
    public void swim() {
        System.out.println("我给你们表演游泳");
    }

    @Override
    public void sing() {
        System.out.println("我给你们表演唱歌");
    }
}
