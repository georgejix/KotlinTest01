package test1

class Test1_9 {
    fun test() {
        C().foo()
        println(null.toString())
        println(arrayOf(1, 2, 3, 4, 5).lastIndex)
        println(Stu.getName())
        println(Stu().getName())
    }

    //扩展函数是静态解析的
    /*这个例子会输出 "c"， 因为调用的扩展函数只取决于参数 c 的声明类型， 该类型是 C 类。
    如果一个类定义有一个成员函数和一个扩展函数， 而这两个函数又有相同的接收者类型、 相
    同的名字并且都适用给定的参数， 这种情况总是取成员函数。 例如：*/
    class C {
        fun foo() {
            println("member")
        }
    }

    fun C.foo() {
        println("extension")
    }

    //为可空的接收者类型定义扩展
    fun Any?.toString(): String {
        return this?.toString() ?: "null!"
    }

    //扩展属性
    /*由于扩展没有实际的将成员插入类中， 因此对扩展属性来说幕后字段是无效的。 这就
    是为什么扩展属性不能有初始化器。 他们的行为只能由显式提供的 getters/setters 定义*/
    val <T> Array<T>.lastIndex: Int
        get() = size - 1

    //伴生对象的扩展
    //如果一个类定义有一个伴生对象 ， 你也可以为伴生对象定义扩展函数和属性
    class Stu {
        companion object {}
    }

    //就像伴生对象的其他普通成员， 只需用类名作为限定符去调用他们
    fun Stu.Companion.getName(): String {
        return "李四Companion"
    }

    fun Stu.getName(): String {
        return "李四Stu"
    }
}