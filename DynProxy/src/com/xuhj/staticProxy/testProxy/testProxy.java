package com.xuhj.staticProxy.testProxy;

import com.xuhj.staticProxy.proxyObjectImpl.stars;
import com.xuhj.staticProxy.proxyer.proxyer;

public class testProxy {
    public static void main(String[] args) {
        stars star = new stars();
        proxyer pyer = new proxyer();
        pyer.setStarsQuote(star);
        pyer.swim();
        pyer.sing();

    }
}
