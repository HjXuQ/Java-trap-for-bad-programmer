package com.xuhj.targetClass;

import com.xuhj.targetInterface.IDog;

public class GunDog implements IDog {
    @Override
    public void run() {
        System.out.println("猎狗再跑~");
    }

    @Override
    public void jump() {
        System.out.println("猎狗再跳~");
    }
}
