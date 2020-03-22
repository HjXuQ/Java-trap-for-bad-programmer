package com.xuhj.classfeaturepractise.polymorphic;

public class InterfaceImpl implements InterFaceName {

    @Override
    public void showAsb() {
        System.out.println("show Abstract");
        showPriv();
    }

    @Override
    public void showNormal() {
        System.out.println("show Normal");
    }


    public void showPriv() {
        System.out.println("show Priv");
        showDefault();
    }

    public static void main(String[] args) {
        InterfaceImpl i = new InterfaceImpl();
        i.showPriv();
        i.showDefault();
        i.showNormal();
    }

}
