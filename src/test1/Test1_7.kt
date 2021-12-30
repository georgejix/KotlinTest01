package test1

class Test1_7 {
    fun test() {
        Derived("hello", "world")
    }


    /*这意味着， 基类构造函数执行时， 派生类中声明或覆盖的属性都还没有初始化。 如果在基类
    初始化逻辑中（ 直接或通过另一个覆盖的 open 成员的实现间接） 使用了任何一个这种属
    性， 那么都可能导致不正确的行为或运行时故障。 设计一个基类时， 应该避免在构造函数、
    属性初始化器以及 init 块中使用 open 成员*/
    open class Base(val name: String) {
        init {
            println("Initializing Base")
        }

        open val size: Int = name.length.also { println("Initializing size in Base: $it") }
    }

    class Derived(
            name: String,
            val lastName: String
    ) : Base(name.capitalize().also { println("Argument for Base: $it") }) {
        init {
            println("Initializing Derived")
        }

        override val size: Int = (super.size + lastName.length).also {
            println("Initializing size in Derived: $it ")
        }
    }


    //派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现
    open class Foo {
        open fun f() {
            println("Foo.f()")
        }

        open val x: Int
            get() = 1
    }

    class Bar : Foo() {
        override fun f() {
            super.f()
            println("Bar.f()")
        }

        override val x: Int
            get() = super.x + 1
    }

    //在一个内部类中访问外部类的超类， 可以通过由外部类名限定的 super 关键字来实现： super@Outer
    class Bar2 : Foo() {
        override fun f() { /* …… */
        }

        override val x: Int get() = 0

        inner class Baz {
            fun g() {
                super@Bar2.f() // 调用 Foo 实现的 f()
                println(super@Bar2.x) // 使用 Foo 实现的 x 的 getter
            }
        }
    }
}