package com.xuhj;

import sun.jvm.hotspot.gc_implementation.parallelScavenge.PSYoungGen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class JavaCommonAPIPractise {
    public static void main(String[] args) throws ParseException {
        //Object类
        /**
         * toString()
         * toString方法返回该对象的字符串表示，其实该字符串内容就是对象的类型+@+内存地址值。
         * 由于toString方法返回的结果是内存地址，而在开发中，经常需要按照对象的属性得到相应的字符串表现形式，因此也需要重写它。
         *   @Override
         *     public String toString() {
         *         return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
         *     }
         * 在我们直接使用输出语句输出对象名的时候,其实通过该对象调用了其toString()方法。
         *equals(Object o)
         * `public boolean equals(Object obj)`：指示其他某个对象是否与此对象“相等”。
        调用成员方法equals并指定参数为另一个对象，则可以判断这两个对象是否是相同的。这里的“相同”有默认和自定义两种方式。
        ### 默认地址比较
        如果没有覆盖重写equals方法，那么Object类中默认进行`==`运算符的对象地址比较，只要不是同一个对象，结果必然为false。
        ### 对象内容比较
        如果希望进行对象的内容比较，即所有或指定的部分成员变量相同就判定两个对象相同，则可以覆盖重写equals方法。例如：
        import java.util.Objects;
        public class Person {
        private String name;
        private int age;
         @Override
         public boolean equals(Object o) {
         // 如果对象地址一样，则认为相同
         if (this == o)
         return true;
         // 如果参数为空，或者类型信息不一样，则认为不同
         if (o == null || getClass() != o.getClass())
         return false;
         // 转换为当前类型
         Person person = (Person) o;
         // 要求基本类型相等，并且将引用类型交给java.util.Objects类的equals静态方法取用结果
         return age == person.age && Objects.equals(name, person.name);
         }
         }
         getClass() 反射动态的获取这个类的类型 A a = new A(); a.getClass() == A.class
         * */
        /**
         * Objects类
         * 在刚才IDEA自动重写equals代码中，使用到了`java.util.Objects`类，那么这个类是什么呢？
         * 在**JDK7**添加了一个Objects工具类，它提供了一些方法来操作对象，它由一些静态的实用方法组成，这些方法是null-save（空指针安全的）或null-tolerant（容忍空指针的），用于计算对象的hashcode、返回对象的字符串表示形式、比较两个对象。
         * 在比较两个对象的时候，Object的equals方法容易抛出空指针异常，而Objects类中的equals方法就优化了这个问题。方法如下：
         * * `public static boolean equals(Object a, Object b)`:判断两个对象是否相等。
         * 我们可以查看一下源码，学习一下：
         * ~~~java
         * public static boolean equals(Object a, Object b) {
         * //   && 具有短路特性，当a!=null为假时，不看第二个判断式，直接就是假
         *     return (a == b) || (a != null && a.equals(b));
         * }
         * ~~~
         * */
       System.out.println( Objects.equals("a",null));

       /**
        * Date
        * ` java.util.Date`类 表示特定的瞬间，精确到毫秒。
        * 继续查阅Date类的描述，发现Date拥有多个构造函数，只是部分已经过时，但是其中有未过时的构造函数可以把毫秒值转成日期对象。
        * - `public Date()`：分配Date对象并初始化此对象，以表示分配它的时间（精确到毫秒）。
        * - `public Date(long date)`：分配Date对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，即1970年1月1日00:00:00 GMT）以来的指定毫秒数。
        * > tips: 由于我们处于东八区，所以我们的基准时间为1970年1月1日8时0分0秒。
        * 简单来说：使用无参构造，可以自动设置当前系统时间的毫秒时刻；指定long类型的构造参数，可以自定义毫秒时刻。
        *
        * ### 常用方法
        *
        * Date类中的多数方法已经过时，常用的方法有：
        *
        * * `public long getTime()` 把日期对象转换成对应的时间毫秒值。
        *
        * ## 2.2 DateFormat类
        *
        * `java.text.DateFormat` 是日期/时间格式化子类的抽象类，我们通过这个类可以帮我们完成日期和文本之间的转换,也就是可以在Date对象与String对象之间进行来回转换。
        *
        * * **格式化**：按照指定的格式，从Date对象转换为String对象。
        * * **解析**：按照指定的格式，从String对象转换为Date对象。
        *
        * ### 构造方法
        *
        * 由于DateFormat为抽象类，不能直接使用，所以需要常用的子类`java.text.SimpleDateFormat`。这个类需要一个模式（格式）来指定格式化或解析的标准。构造方法为：
        *
        * * `public SimpleDateFormat(String pattern)`：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。
        *
        * 参数pattern是一个字符串，代表日期时间的自定义格式。
        *
        * ### 格式规则
        *
        * 常用的格式规则为：
        *
        * | 标识字母（区分大小写） | 含义   |
        * | ----------- | ---- |
        * | y           | 年    |
        * | M           | 月    |
        * | d           | 日    |
        * | H           | 时    |
        * | m           | 分    |
        * | s           | 秒    |
        *
        * DateFormat类的常用方法有：
        *
        * - `public String format(Date date)`：将Date对象格式化为字符串。
        * - `public Date parse(String source)`：将字符串解析为Date对象。
        * */
        Date today = new Date();
        System.out.println(today);  //Sun Mar 15 14:27:11 CST 2020  毫秒值
        System.out.println(new Date(0L));  //Thu Jan 01 08:00:00 CST 1970 从这个时候东八区开始计时
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //        * - `public String format(Date date)`：将Date对象格式化为字符串。
        String time = simpleDateFormat.format(today);
        System.out.println(time);
        String date = "2019-02-12 12:23:12";
        Date date1 = simpleDateFormat.parse(date);
        System.out.println(date1);
        //获取毫秒值
        long seconds = today.getTime();
        System.out.println(seconds);
        /**
         * 日历我们都见过
         * `java.util.Calendar`是日历类，在Date后出现，替换掉了许多Date的方法。该类将所有可能用到的时间信息封装为静态成员变量，方便获取。日历类就是方便获取各个时间属性的。
         * ### 获取方式
         * Calendar为抽象类，由于语言敏感性，Calendar类在创建对象时并非直接创建，而是通过静态方法创建，返回子类对象，如下：
         * Calendar静态方法
         * * `public static Calendar getInstance()`：使用默认时区和语言环境获得一个日历
         *
         * ### 常用方法
         *
         * 根据Calendar类的API文档，常用方法有：
         *
         * - `public int get(int field)`：返回给定日历字段的值。
         * - `public void set(int field, int value)`：将给定的日历字段设置为给定值。
         * - `public abstract void add(int field, int amount)`：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
         * - `public Date getTime()`：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
         *
         * Calendar类中提供很多成员常量，代表给定的日历字段：
         *
         * | 字段值          | 含义                   |
         * | ------------ | -------------------- |
         * | YEAR         | 年                    |
         * | MONTH        | 月（从0开始，可以+1使用）       |
         * | DAY_OF_MONTH | 月中的天（几号）             |
         * | HOUR         | 时（12小时制）             |
         * | HOUR_OF_DAY  | 时（24小时制）             |
         * | MINUTE       | 分                    |
         * | SECOND       | 秒                    |
         * | DAY_OF_WEEK  | 周中的天（周几，周日为1，可以-1使用） |
         *
         * */
        //         * * `public static Calendar getInstance()`：使用默认时区和语言环境获得一个日历
        Calendar calendar = Calendar.getInstance();
        //         * - `public int get(int field)`：返回给定日历字段的值。
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);
        //         * - `public void set(int field, int value)`：将给定的日历字段设置为给定值。
        calendar.set(Calendar.YEAR,2020);
        //         * - `public abstract void add(int field, int amount)`：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        calendar.add(Calendar.YEAR,2);//加两年
        //         * - `public Date getTime()`：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
        Date dateCal = calendar.getTime();
        System.out.println(dateCal);
        System.out.println("年" + year + "月" + month + "日" + dayOfMonth);
        /**
         * 第三章 System类
         * `java.lang.System`类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：
         * - `public static long currentTimeMillis()`：返回以毫秒为单位的当前时间。
         * - `public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`：将数组中指定的数据拷贝到另一个数组中。
         * ## 3.1 currentTimeMillis方法
         * 实际上，currentTimeMillis方法就是 获取当前系统时间与1970年01月01日00:00点之间的毫秒差值
         *
         * 数组的拷贝动作是系统级的，性能很高。System.arraycopy方法具有5个参数，含义分别为：
         *
         * | 参数序号 | 参数名称    | 参数类型   | 参数含义       |
         * | ---- | ------- | ------ | ---------- |
         * | 1    | src     | Object | 源数组        |
         * | 2    | srcPos  | int    | 源数组索引起始位置  |
         * | 3    | dest    | Object | 目标数组       |
         * | 4    | destPos | int    | 目标数组索引起始位置 |
         * | 5    | length  | int    | 复制元素个数     |
         *
         * */
        System.out.println(System.currentTimeMillis());

        /**
         * 包装类
         *
         * ## 5.1 概述
         *
         * Java提供了两个类型系统，基本类型与引用类型，使用基本类型在于效率，然而很多情况，会创建对象使用，因为对象可以做更多的功能，如果想要我们的基本类型像对象一样操作，就可以使用基本类型对应的包装类，如下：
         *
         * | 基本类型    | 对应的包装类（位于java.lang包中） |
         * | ------- | --------------------- |
         * | byte    | Byte                  |
         * | short   | Short                 |
         * | int     | **Integer**           |
         * | long    | Long                  |
         * | float   | Float                 |
         * | double  | Double                |
         * | char    | **Character**         |
         * | boolean | Boolean               |
         *
         * ## 5.2 装箱与拆箱
         *
         * 基本类型与对应的包装类对象之间，来回转换的过程称为”装箱“与”拆箱“：
         *
         * * **装箱**：从基本类型转换为对应的包装类对象。
         *
         * * **拆箱**：从包装类对象转换为对应的基本类型。
         *
         * 用Integer与 int为例：（看懂代码即可）
         *
         * 基本数值---->包装对象
         *
         * ~~~java
         * Integer i = new Integer(4);//使用构造函数函数
         * Integer iii = Integer.valueOf(4);//使用包装类中的valueOf方法
         * ~~~
         *
         * 包装对象---->基本数值
         *
         * ~~~java
         * int num = i.intValue();
         * ~~~
         * ## 5.3自动装箱与自动拆箱
         *
         * 由于我们经常要做基本类型与包装类之间的转换，从Java 5（JDK 1.5）开始，基本类型与包装类的装箱、拆箱动作可以自动完成。例如：
         *
         * ```java
         * Integer i = 4;//自动装箱。相当于Integer i = Integer.valueOf(4);
         * i = i + 5;//等号右边：将i对象转成基本数值(自动拆箱) i.intValue() + 5;
         * //加法运算完成后，再次装箱，把基本数值转成对象。
         * ```
         *
         * ## 5.3 基本类型与字符串之间的转换
         *
         * ### 基本类型转换为String
         *
         *    基本类型转换String总共有三种方式，查看课后资料可以得知，这里只讲最简单的一种方式：
         *
         * ~~~
         * 基本类型直接与””相连接即可；如：34+""
         * ~~~
         *
         * String转换成对应的基本类型
         *
         * 除了Character类之外，其他所有包装类都具有parseXxx静态方法可以将字符串参数转换为对应的基本类型：
         *
         * - `public static byte parseByte(String s)`：将字符串参数转换为对应的byte基本类型。
         * - `public static short parseShort(String s)`：将字符串参数转换为对应的short基本类型。
         * - `public static int parseInt(String s)`：将字符串参数转换为对应的int基本类型。
         * - `public static long parseLong(String s)`：将字符串参数转换为对应的long基本类型。
         * - `public static float parseFloat(String s)`：将字符串参数转换为对应的float基本类型。
         * - `public static double parseDouble(String s)`：将字符串参数转换为对应的double基本类型。
         * - `public static boolean parseBoolean(String s)`：将字符串参数转换为对应的boolean基本类型。
         *
         * 代码使用（仅以Integer类的静态方法parseXxx为例）如：
         *
         * ```java
         * public class Demo18WrapperParse {
         *     public static void main(String[] args) {
         *         int num = Integer.parseInt("100");
         *     }
         * }
         * ```
         *
         * > 注意:如果字符串参数的内容无法正确转换为对应的基本类型，则会抛出`java.lang.NumberFormatException`异常。
         * >
         *
         *
         * */

        StudentBo studentBo = new StudentBo("111",3);
        System.out.println(studentBo.toString());
    }
}
