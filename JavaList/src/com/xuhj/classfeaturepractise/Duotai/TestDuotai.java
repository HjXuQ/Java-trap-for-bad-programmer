package com.xuhj.classfeaturepractise.Duotai;

import com.xuhj.classfeaturepractise.Extend.Animal;

public class TestDuotai {
    public static void main(String[] args) {
        //多态就是父类的引用，然后指向子类的对象，调用方法只能是父子类中都有的方法，不能调用子类中特有的方法，先去父类中找没有编译报错，如果有去子类中找实现
        Animals cat = new Cat();
        //如果是这种多态形式，是不行的,父类类型接受子类对象
        Animals dog = new Dog();
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Animals animals  = new Animals() {
            @Override
            public void show() {
                System.out.println("aaa");
            }

            @Override
            public void sayHello() {
                System.out.println("bbb");
            }
        };
        animals.sayHello();
        animals.show();
    dog1.sayHello1(new Animals() {
        @Override
        public void show() {
            System.out.println("aaa");
        }

        @Override
        public void sayHello() {
            System.out.println("bbb");
        }
    });
        /**
         * 因为 在类加载的时候会创建一个类对象到内存
         * 而静态方法因为是static修饰的也是类加载的时候作为属性附到类对象上
         * 所以没有创建类实例即没有实例化的时候它已经存在内存，且可用通过类调用
         */
        TestDuotai.showCat(cat1);
        showDog(dog1);
        System.out.println("------------------------");
        cat.show();
        dog.show();
        System.out.println("------------------------");
        showCatAnimal(cat);
        showCatAnimal(dog);

    }
    private static void showCat(Cat c){
        c.show();
    }
    public static void showDog(Dog d){
        d.show();
    }
    public static void showCatAnimal(Animals a){
        a.show();
    }
}
