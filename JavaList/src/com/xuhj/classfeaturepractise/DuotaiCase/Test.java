package com.xuhj.classfeaturepractise.DuotaiCase;

public class Test {
    public static void main(String[] args) {
        USB mouse = new Mouse();
        USB keyboard  = new KeyBoard();
        Laptop laptop = new Laptop();
        laptop.run();
        laptop.useUSB(mouse);
        laptop.useUSB(keyboard);
        laptop.shutDown();
    }
}
