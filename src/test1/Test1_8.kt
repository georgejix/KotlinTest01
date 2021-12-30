package test1

class Test1_8 {
    fun test() {
        var person = Person2()
        person.age = 10
        println(person.age)
    }

    /*覆盖规则
    在 Kotlin 中， 实现继承由下述规则规定： 如果一个类从它的直接超类继承相同成员的多个实
    现， 它必须覆盖这个成员并提供其自己的实现（ 也许用继承来的其中之一） 。 为了表示采用
    从哪个超类型继承的实现， 我们使用由尖括号中超类型名限定的 super ， 如 super<Base>*/
    open class A {
        open fun f() {
            print("A")
        }

        fun a() {
            print("a")
        }
    }

    interface B {
        fun f() {
            print("B")
        } // 接口成员默认就是“open”的

        fun b() {
            print("b")
        }
    }

    class C() : A(), B {
        // 编译器要求覆盖 f()：
        override fun f() {
            super<A>.f() // 调用 A.f()
            super<B>.f() // 调用 B.f()
        }
    }

    /*抽象类
    类和其中的某些成员可以声明为 abstract 。 抽象成员在本类中可以不用实现。 需要注意的
    是， 我们并不需要用 open 标注一个抽象类或者函数——因为这不言而喻。
    我们可以用一个抽象成员覆盖一个非抽象的开放成员*/
    open class Base {
        open fun f() {}
    }

    abstract class Derived : Base() {
        override abstract fun f()
    }

    //如果你需要改变一个访问器的可见性或者对其注解， 但是不需要改变默认的实现， 你可以定义访问器而不定义其实现
    class Person {
        var name: String = "zs"
            private set
    }

    //幕后字段
    class Person2 {
        var age: Int = 0
            get() = field + 1
            set(value) {
                field = value
            }
    }

    //延迟初始化
    class Person3 {
        lateinit var a: String
    }

}