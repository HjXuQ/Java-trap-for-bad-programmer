package com.xuhj.classfeaturepractise.polymorphic;

public interface InterFaceName {
    //抽象方法 使用 abstract 关键字修饰，可以省略，没有方法体。该方法供子类实现使用。
    public abstract void showAsb();
    //默认方法:使用 default 修饰，不可省略，供子类调用或者子类重写。必须要有函数体
    public default void showDefault(){
        System.out.println("show Default");
    };
    //静态方法:使用 static 修饰，供接口直接调用,必须有方法体
    public static void showStatic(){

    };
    //私有方法:使用 private 修饰，供接口中的默认方法或者静态方法调用。如果说默认方法和静态方法有很多相同的逻辑，我们可以抽象抽出来放在private中来供其调用
    //从java9开始，接口中可以定义私有方法，因为当前是1.8版本所以现在还不能创建私有方法
    public void showNormal();

}
