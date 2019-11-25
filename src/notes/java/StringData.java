package notes.java;

/**
 * Description:String
 * Author:edsonJiao
 * Date:2019.11.25
 */
public class StringData {

    //String类不属于基本数据类型,被声明为final,因此它不可被继承.(Integer是包装类也不能被继承)
    //在Java8中,String内部使用char数组存储数据
    //在Java9之后,String类的实现改用byte数组存储字符串,同时使用coder来标识使用了哪种编码.详情看源码
    //在Java9中,String类的实现使用的byte数组名为value,它被声明为final,这意味着value数组初始化值之后就不能引用其他数组.
    //并且String内部没有改变的value数组的方法,因此可以保证String不可变.


    //不可变的好处
    //1.可以缓存hash值
    //  因为String的hash值经常被使用,例如String用作HashMap的key.不可变的特性可以使得hash值也不可变,因此只需要进行一次计算
    //2.String Pool的需要
    //  如果一个String对象已经被创建过了,那么就会从Spring Pool中取得引用.只有String是不可变的,才能使用String Pool
    //3.安全性
    //  String经常作为参数,String的不可变性可以保证参数不可变.例如在作为网络连接参数的情况下,
    //  如果String是可变的,那么在网络连接过程中,String被改变,改变String对象的那一方以为现在连接的是其他主机,而实际情况却不一定是
    //4.线程安全
    //  String不可变性天生具备线程安全,所以可以在多个线程中安全的使用


    //String,StringBuffer and StringBuilder
    //1.可变性
    //  String不可变
    //  StringBuffer和StringVBuilder可变
    //2.线程安全
    //  String不可变,所以线程安全
    //  StringBuilder不是线程安全的
    //  StringBuffer是线程安全的,内部使用synchronized进行同步


    //String Pool(字符串常量池)
    //String Pool保存着所有的字符串字面量(literal strings),这些字面量在编译时期就确定.
    //不仅如此,还可以使用String的intern()方法在运行过程中将字符串添加到String Pool中
    //当一个字符串调用intern()方法时,如果String Pool中已经存在一个字符串和该字符串值相等(使用equals()方法进行确定),
    //那么就会返回String Pool中字符串的引用;否则,就会在String Pool中添加一个新的字符串,并返回这个字符串的引用.

    //下面示例中,s1和s2次采用new String()的方式新建了两个不同的字符串,而s3和s4是铜鼓奥s1.intern()方法取得一个字符串引用.
    //intern()首先把s1引用的字符串放到String Pool中,然后返回这个字符串引用.
    //因此s3和s4引用的是同一个字符串.
    String s1=new String("aaa");
    String s2=new String("aaa");
    String s3=s1.intern();
    String s4=s1.intern();
    {
        System.out.println(s1 == s2); //false
        System.out.println(s3 == s4); //true
    }
    //如果采用"bbb"这种字两面的形式创建字符串,会自动将字符串放入String Pool中.
    String s5="bbb";
    String s6="bbb";
    {
        System.out.println(s5 == s6);  //true
    }

    //new String("abc")
    //使用这种方式一共会创建两个字符串对象(前提是String Pool中还没有"abc"字符串对象).
    //  1."abc"属于字符串字面量,因此编译时期会在String Pool中创建一个字符串对象,只想这个"abc"字符串字面量
    //  2.而使用new的方式会在堆中创建一个字符串对象
    //可以写个测试方法,然后javap -verbose反编译看一下

    //从String构造函数的源码中可以得知,在将一个字符串对象作为另一个字符串对象的构造方法参数时,并不会完全赋值value数组内容,而是都会指向同一个value数组
    //?????
    //疑问:String构造参数是如何访问另一个String的value数组
}
