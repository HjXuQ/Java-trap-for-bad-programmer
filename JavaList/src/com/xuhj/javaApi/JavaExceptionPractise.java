package com.xuhj;

import javax.security.auth.login.LoginException;

public class JavaExceptionPractise {
    /**
     * 异常机制其实是帮助我们找到程序中的问题，异常的根类是 java.lang.Throwable ，
     * 其下有两个子类: java.lang.Error(不可避免) 与 java.lang.Exception （可以避免），平常所说的异常指 java.lang.Exception 。
     *Throwable中的常用方法:
     * public void printStackTrace() :打印异常的详细信息。包含了异常的类型，异常的原因，还包括异常出现的位置，在开发和调试阶段都得用这个
     * public String getMessage() :获取发生异常的原因。 ,
     * public String toString() :获取异常的类型和异常描述信息(不用)。
     * */

    /**
     * 编译时期异常:checked异常。在编译时期,就会检查,如果没有处理异常,则编译失败。(如日期格式化异常) 必须处理
     * 运行时期异常:runtime异常。在运行时期,检查异常.在编译时期,运行异常不会编译器检测(不报错)。(如数学异 常) 一般不用处理
     * Java异常处理的五个关键字:try、catch、finally、throw、throws
     * throw：如果产生了问题，我们就会throw将问题描述类即异常进行抛出，也就是将问题返回给该方法的调用者。
     * throws:声明异常:将问题标识出来，报告给调用者。如果方法内通过throw抛出了编译时异常，而没有捕获处理(稍后讲
     * 解该方式)，那么必须通过throws进行声明，让调用者去处理。 关键字throws运用于方法声明之上,用于表示当前方法不处理异常,而是提醒该方法的调用者来处理异常(抛出异常)
     * <p>
     * 多个异常使用捕获又该如何处理呢?
     * 1. 多个异常分别处理。
     * 2. 多个异常一次捕获，多次处理。 3. 多个异常一次捕获一次处理。
     * 一般我们是使用一次捕获多次处理方式，格式如下:
     * try{ 编写可能会出现异常的代码
     * }catch(异常类型A e){ 当try中出现A类型异常,就用该catch来捕获. 处理异常的代码
     * //记录日志/打印异常信息/继续抛出异常
     * }catch(异常类型B e){ 当try中出现B类型异常,就用该catch来捕获.
     * 处理异常的代码
     * //记录日志/打印异常信息/继续抛出异常 }
     * 注意:这种异常处理方式，要求多个catch中的异常不能相同，并且若catch中的多个异常之间有子父类异常的关系，
     * 那么子类异常要求在上面的catch处理，父类异常在下面的catch处理。
     * 异常处理情况
     * 运行时异常被抛出可以不处理。即不捕获也不声明抛出。 如果finally有return语句,永远返回finally中的结果,避免该情况.
     * 如果父类抛出了多个异常,子类重写父类方法时,抛出和父类相同的异常或者是父类异常的子类或者不抛出异 常。
     * 父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
     */
    private static String[] names = {"11", "222", "33"};

    public static void main(String[] args) {
        try {
            checkUserName("222");
        } catch (JavaRegisterException | LoginException e) {
            e.printStackTrace();
        }

    }

    //登陆，测试自定义异常
    public static boolean checkUserName(String uname) throws LoginException, JavaRegisterException {
        for (String name : names) {
            if (name.equals("222")) {
                throw new JavaRegisterException("这个已经被注册了");
            }
        }
        return true;
    }
}
