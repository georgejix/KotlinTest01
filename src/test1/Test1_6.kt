package test1

class Test1_6 {
    fun test() {
        val foo = Foo()
        println(foo.x)
        val bar = Bar()
        println(bar.x)
    }

    //要声明一个显式的超类型， 我们把类型放到类头的冒号之后
    //类上的 open 标注与 Java 中 final 相反， 它允许其他类从这个类继承。 默认情况下，
    //在 Kotlin 中所有的类都是 final
    open class Base(p: Int)
    class Derived(p: Int) : Base(p)

    //如果类没有主构造函数， 那么每个次构造函数必须使用 super 关键字初始化其基类型， 或委
    //托给另一个构造函数做到这一点。 注意， 在这种情况下， 不同的次构造函数可以调用基类型
    //的不同的构造函数
    /*class MyView : View {
        constructor(ctx: Context) : super(ctx)
        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    }*/


    //覆盖方法
    //与 Java 不同， Kotlin 需要显式标注可覆盖的成员（ 我们称之为开放） 和覆盖后的成员
    //Derived.v() 函数上必须加上 override标注。 如果没写， 编译器将会报错。 如果函数没有标注
    //open 如 Base.nv() ， 则子类中不允许定义相同签名的函数， 不论加不加 override。 在一个
    //final 类中（ 没有用 open 标注的类） ， 开放成员是禁止的
    open class Base2 {
        open fun v() {}
        fun nv() {}
    }

    class Derived2() : Base2() {
        override fun v() {}
    }

    //标记为 override 的成员本身是开放的， 也就是说， 它可以在子类中覆盖。 如果你想禁止再
    //次覆盖， 使用 final 关键字
    open class Derived3() : Base2() {
        final override fun v() {}
    }

    //覆盖属性
    //属性覆盖与方法覆盖类似； 在超类中声明然后在派生类中重新声明的属性必须以 override
    //开头， 并且它们必须具有兼容的类型。 每个声明的属性可以由具有初始化器的属性或者具有
    //getter 方法的属性覆盖
    open class Foo {
        open val x: Int
            get() {
                return 1
            }
    }

    class Bar : Foo() {
        override val x: Int = 2
    }

    //你也可以用一个 var 属性覆盖一个 val 属性， 但反之则不行。 这是允许的， 因为一个
    //val 属性本质上声明了一个 getter 方法， 而将其覆盖为 var 只是在子类中额外声明一个
    //setter 方法
    //你可以在主构造函数中使用 override 关键字作为属性声明的一部分
    interface Foo2 {
        val count: Int
    }

    class Bar2(override val count: Int) : Foo2
    class Bar2_2 : Foo2 {
        override var count: Int = 0
    }

}