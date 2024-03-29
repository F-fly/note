package notes.java.base;

/**
 * Description:继承
 * Author:edsonJiao
 * Date:2019.11.26
 */
public class Inheritance {
    //访问控制
    //Java中有三个访问权限修饰符：private、protected、public，如果不加访问权限修饰符表示包内可见。
    //可以对类或类中的成员（字段以及方法）加上访问修饰符
    //  类可见表示其他类可以使用这个类创建实例对象
    //  成员可见表示其他类可以通过这个类的实例对象访问到该成员
    //protected用于修饰成员，表示在继承体系中成员对于子类可见，但是这个访问修饰符对于类没有意义

    //设计良好的模块会隐藏所有实现细节，把它的API与实现清晰地隔离开来。模块之间之通过他们的API进行通信，一个模块不需要知
    //道其他模块的内部工作情况，这个概念被称为信息隐藏或封装。因此访问权限应当尽可能地使每个类或成员不被外界访问。

    //如果子类的方法重写了父类的方法，那么子类中该方法的访问级别不允许低于父类该方法的访问级别。这里是为了确保可以使用父
    //类实例的地方都可以使用子类实例，也就是确保满足里式替换原则。

    //字段决不能是公有的，因为这样做就会失去对这个字段修改行为的控制，客户端可以对其任意修改。
    //但是也有例外，如果是包级私有的类或者私有的嵌套类，那么直接暴露成员不会有特别大的影响。

    //抽象类
    //抽象类和抽象方法都是要abstract关键字进行声明。如果一个类中包含一个抽象方法，那么这个类必须声明为抽象类,抽象类中可以有非抽象的方法
    //抽象类和普通类最大的区别是，抽象类不能实例化，需要继承抽象类才能实例化它的子类

    //接口
    //  接口是抽象类的延伸，在Java8之前，它可以看成一个完全抽象的类，也就是说它不能有任何的方法实现。
    //从Java8开始，接口也可以拥有默认的方法实现，也就是可以有非抽象的方法。这是因为不支持默认方法的接口的维护成本太高了。
    //在Java之前，如果想在接口中加一个新的方法，那么要修改所有实现了该接口的类。
    //接口成员（字段和方法）默认都是public的,并且不允许定义为private或protected.
    //接口的字段默认是static和final的


    //比较
    //  从设计层面上看，抽象类提供一种IS-A关系，那么就必须满足里式替换原则，即子类对象必须能替换所有父类对象。
    //而接口更像一种Like-A关系，他只是提供一种方法实现约束，并不要求接口和实现接口的类满足IS-A关系。
    //  从使用上看，一个类可以实现多个接口，但是一个类只能继承一个抽象类
    //  接口的字段只能是static和fina的，而抽象类没有这种限制
    //  接口的方法只能是public,而抽象类的方法可以有多种访问权限。


    //使用说明
    //使用接口：
    //  需要让不相关的类都实现一个方法，例如不相关的类都可以实现Compareable接口的compareTo()方法;
    //  需要使用多重继承
    //使用抽象类：
    //  需要在几个相关的类中共享代码
    //  需要能控制继承来的成员的访问权限，而不是都是public
    //  需要继承非静态和非常量字段

    //在很多情况下，接口优先于抽象类。因为接口没有抽象类严格的类层次结构要求，可以灵活的为一个类添加行为。
    //并且从Java8开始接口也可以有默认方法的实现，使修改接口的成本变得很低


    //super
    //访问父类的构造函数：
    //  可以使用super()函数访问父类的构造函数，从而委托父类完成一些初始化的工作。//
    //  应该注意到，子类一定会调用父类的构造函数来完成初始化工作，一般是调用父类的默认构造函数，如果子类需要调用父类其它构造函数，那么就可以使用 super 函数。
    //  访问父类的成员：如果子类重写了父类的某个方法，可以通过使用 super 关键字来引用父类的方法实现。

    //重写和重载
    //重写(Override)
    //  存在于继承体系中，指子类实现了一个与父类在方法声明上完全相同的一个方法。
    //为了满足里式替换原则，重写有以下三个限制：
    //  子类方法的访问权限必须大于等于父类方法；
    //  子类方法的返回类型必须是父类方法返回类型或为其子类型;
    //  子类方法抛出的异常类型必须是父类抛出异常类型或为其子类型;
    //使用 @Override 注解，可以让编译器帮忙检查是否满足上面的三个限制条件。

    //在调用一个方法时，先从本类中查找看是否有对应的方法，如果没有查找到再到父类中查看，看是否有继承来的方法。
    //否则就要对参数进行转型，转成父类之后看是否有对应的方法。总的来说，方法调用的优先级为：
    //  this.func(this)
    //  super.func(this)
    //  this.func(super)
    //  super.func(super)

    //重载
    //存在于同一个类中，指一个方法与已经存在的方法名称上相同，但是参数类型、个数、顺序至少有一个不同。
    //应该注意的是，返回值不同，其它都相同不算是重载
}
