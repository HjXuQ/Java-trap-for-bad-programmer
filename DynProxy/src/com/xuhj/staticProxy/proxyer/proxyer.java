package com.xuhj.staticProxy.proxyer;

import com.xuhj.staticProxy.proxyObjectImpl.stars;
import com.xuhj.staticProxy.publicInterface.skillsInterface;

public class proxyer implements skillsInterface {
    private stars starsQuote;

    public void setStarsQuote(stars starsQuote) {
        this.starsQuote = starsQuote;
    }
    //在被代理对象中进行一定的逻辑判断，这样的话我们不用直接扩展原始接口就可以对方法进行增强
    @Override
    public void swim() {
            System.out.println("想要我游泳 10万");
            starsQuote.swim();
    }

    @Override
    public void sing() {
        System.out.println("想要我唱歌 20万");
        starsQuote.sing();

    }
}
