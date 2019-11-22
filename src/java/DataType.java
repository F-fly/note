package java;

/**
 * Description:数据类型
 * Author:edsonJiao
 * Date:2019.11.12
 */
public class DataType {
    byte aByte;         //8
    char aChar;         //16
    short aShort;       //16
    int anInt;          //32
    float aFloat;       //32
    long aLong;         //64
    double aDouble;     //64
    boolean aBoolean;   //boolean只有两个值,ture和false,可以用1bit来存储,但是具体大小没有明确规定.
                        //JVM会在编译时期将boolean类型转换为int,使用1来表示true,0表示false.
                        //JVM支持boolean数组,但是是通过byte数组实现的.


    /**包装类型**/
    //基本数据类型都有相应的包装类型,基本数据类型与其对应的包装类型之间的赋值使用自动装箱和拆箱完成.
    Integer x=2; //装箱 调用了Integer.valueOf(2)
    int y=x;    //拆箱 调用了x.intValue()

    /**缓存池**/
    //new Integer(123)与Integer.valueOf(123)的区别在于:
    //1.new Integer(123)每次都会创建一个对象;
    //2.Integer.valueOf(123)会使用缓存池中的对象,多次调用会取得同一个对象的引用
    Integer a=new Integer(123);
    Integer b=Integer.valueOf(123);
    {
        System.out.println(a==b);     //false
    }
    Integer c=Integer.valueOf(123);
    Integer d=Integer.valueOf(123);
    {
        System.out.println(c==d);   //true
    }
    //valueOf()方法的实现比较简单,就是判断值是否在缓存池中,如果在,就返回缓存池中的内容.具体代码看源码

    //在Java8中,缓存池的大小为-128-127.具体实现看源码.缓存池就是一个数组

    //编译器在每次自动装箱过程调用valueOf()方法,因此多个值相同且在缓存池范围的Integer实例使用自动装箱来创建,那么就会引用相同的对象
    Integer m=123;
    Integer n=123;
    {
        System.out.println(m==n);   //true
    }

    //基本数据类型对应的缓存池如下:
    //1.boolean values true and false
    //2.all byte values
    //3.short values between -128 and 127
    //4.int values between -128 and 127
    //5.char in the range \u0000 to \u007F
    //在使用这些基本数据类型对应的包装类型时,如果该数值范围在缓存池范围内,就可以直接使用缓存池中的对象.
    //在jdk1.8所有的缓存池中,Integer的缓存池IntegerCache比较特殊,这个缓存池下界是-128,上界默认是127
    //但是这个上界是可以调的,在启动JVM的时候,通过 -XX:AutoBoxCacheMax=<size>来指定缓冲池的大小.
    //该选项在JVM初始化的时候会设定一个名为java.lang.Integer.high系统属性,然后在IntegerCache初始化的时候就会读取该系统属性作为上界




































}
