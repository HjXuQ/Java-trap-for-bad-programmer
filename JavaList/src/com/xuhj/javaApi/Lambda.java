package com.xuhj.javaApi;

import java.util.Arrays;

public class Lambda {
    public static void main(String[] args) {
        /**
         * Lambda表达式 函数式编程思想
         * 强调的是做什么，而不是怎么做的问题
         *Lambda省去面向对象的条条框框，格式由3个部分组成:
         *   一些参数
         *   一个箭头
         *   一段代码
         * Lambda表达式的标准格式为: (参数类型 参数名称) ‐> { 代码语句 }
         * 格式说明:
         * 小括号内的语法与传统方法参数列表一致:无参数则留空;多个参数则用逗号分隔。 -> 是新引入的语法格式，代表指向动作。
         * 大括号内的语法与传统方法体要求基本一致。
         *
         *
         * */
        /**
         *()->{System.out.println("多线程执行");}
         *前面的一对小括号即 run 方法的参数(无)，代表不需要任何条件;
         *中间的一个箭头代表将前面的参数传递给后面的代码;
         *后面的输出语句即业务逻辑代码
         *
         * 这么理解：
         *  对有接口但是未实现的地方使用Lambda表达式，
         *  例如：
         *      给定一个计算器 Calculator 接口，内含抽象方法 calc 可以将两个int数字相加得到和值:
         *    public interface Calculator {
         *        int calc(int a, int b);
         * }
         * 在下面的代码中，请使用Lambda的标准格式调用 invokeCalc 方法，完成120和130的相加计算:
         *    public class Demo08InvokeCalc {
         *        public static void main(String[] args) {
         * //  请在此使用Lambda【标准格式】调用invokeCalc方法来计算120+130的结果ß
         * invokeCalc(120, 130, (int a, int b) ‐> { 注意这一块代码，他在结果中调用的时候，只有这个地方有接口，所以说这个地方用Lamdba表达式
         *            return a + b;
         *        });
         *        invokeCalc(120, 130, (a, b) ‐> a + b); 还可以这么写
         * }
         * private static void invokeCalc(int a, int b, Calculator calculator) { int result = calculator.calc(a, b);
         * System.out.println("结果是:" + result);
         * } }
         *省略规则 在Lambda标准格式的基础上，使用省略写法的规则为:
         * 1. 小括号内参数的类型可以省略;
         * 2. 如果小括号内有且仅有一个参，则小括号可以省略;
         * 3. 如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。
         *
         *
         *
         * 这个很重要！！！！
         * Lambda的语法非常简洁，完全没有面向对象复杂的束缚。但是使用时有几个问题需要特别注意:
         * 1. 使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法。
         * 无论是JDK内置的 Runnable 、 Comparator 接口还是自定义的接口，只有当接口中的抽象方法存在且唯一 时，才可以使用Lambda。
         * 2. 使用Lambda必须具有上下文推断。 也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。
         * 备注:有且仅有一个抽象方法的接口，称为“函数式接口”。
         *
         * */
        new Thread(()->{System.out.println("多线程执行");}).start();
        StudentBo[] stu = new StudentBo[]{
                new StudentBo("111",23),
                new StudentBo("222",12),
                new StudentBo("333",45)
        };
        Arrays.sort(stu,(StudentBo o1, StudentBo o2) -> {
            return o1.getAge()- o2.getAge();
        });
        for(StudentBo s : stu){
            System.out.println(s.getAge());
        }

    }
}
