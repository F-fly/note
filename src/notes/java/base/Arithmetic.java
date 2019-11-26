package notes.java.base;

/**
 * Description:运算
 * Author:edsonJiao
 * Date:2019.11.26
 */
public class Arithmetic {
    //参数传递
    //Java的参数传递是以值传递的形式传入方法中，而不是引用传递

    //float与double
    //Java不能隐式执行向下转型，因为这会使得精度降低。
    //1.1字面量属于double类型，不能直接将1.1直接赋值给float变量，因为这是向下转型
    //float f=1.1;  会报错
    //1.1f字面量才是float类型
    float f=1.1f;

    //隐式类型转换
    //因为字面量1是int类型，它比short类型精读要高，因此不能隐式地将int类型向下转型为short类型。
    short s1=1;
    //s1=s1+1; 会报错
    //但是使用+=或者++运算符可以执行隐式类型转换
    {
        s1+=1;
    }
    //上面的语句相当于将s1+1的计算结果进行了向下转型：
    {
        s1=(short)(s1+1);
    }


    //switch
    //从Java7开始，可以在switch条件判断中使用String对象
    {
        String a="abc";
        switch (a){
            case "abc":
                System.out.println("abc");
                break;
            case "bcd":
                System.out.println("bcd");
                break;
        }
    }
    //switch不支持long,因为switch的设计初衷是对那些只有少数的几个值进行等值判断，如果值过于复杂，那么还是用if比较合适
}
