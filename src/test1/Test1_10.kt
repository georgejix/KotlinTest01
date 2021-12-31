package test1

class Test1_10 {
    fun test() {
        C().caller(D()) // 输出 "D.foo in C"
        C1().caller(D()) // 输出 "D.foo in C1" —— 分发接收者虚拟解析
        C().caller(D1()) // 输出 "D.foo in C" —— 扩展接收者静态解析
        println(Book("书", 200).component1())

        //解构
        var (name, sex) = Person("张三", "female")
        println("name=$name,sex=$sex")
    }

    open class D {
    }

    class D1 : D() {
    }

    open class C {
        open fun D.foo() {
            println("D.foo in C")
        }

        open fun D1.foo() {
            println("D1.foo in C")
        }

        fun caller(d: D) {
            d.foo() // 调用扩展函数
        }
    }

    class C1 : C() {
        override fun D.foo() {
            println("D.foo in C1")
        }

        override fun D1.foo() {
            println("D1.foo in C1")
        }
    }

    /*为了确保生成的代码的一致性和有意义的行为， 数据类必须满足以下要求：
    主构造函数需要至少有一个参数；
    主构造函数的所有参数需要标记为 val 或 var ；
    数据类不能是抽象、 开放、 密封或者内部的；
    （ 在1.1之前） 数据类只能实现接口*/
    data class Book(var name: String, var pages: Int)

    //在类体中声明的属性
    /*在 toString() 、 equals() 、 hashCode() 以及 copy() 的实现中只会用到 name 属性， 并
    且只有一个 component 函数 component1() 。 虽然两个 Person 对象可以有不同的年龄， 但
    它们会视为相等。*/
    data class Person(val name: String, val sex: String) {
        var age: Int = 0
    }

}