package test1

class Test1_11 {
    fun test() {
        Person.Stu().say()
        Person2().Stu2().say()
        printAllValues<Color>()
        foo()
    }

    class Person {
        class Stu {
            fun say() {
                println("a student")
            }
        }
    }

    class Person2 {
        var name: String = "张三"

        inner class Stu2 {
            fun say() {
                println("$name is a student")
            }
        }
    }

    enum class Color {
        RED, BLUE, GREEN
    }

    inline fun <reified T : Enum<T>> printAllValues() {
        println(enumValues<T>().joinToString { it.name })
    }

    fun foo() {
        var bean = object {
            var x = 0
            var y = 0
        }
        bean.x = 1
        println("${bean.x} , ${bean.y}")
    }

    /* 请注意， 匿名对象可以用作只在本地和私有作用域中声明的类型。 如果你使用匿名对象作为
     公有函数的返回类型或者用作公有属性的类型， 那么该函数或属性的实际类型会是匿名对象
     声明的超类型， 如果你没有声明任何超类型， 就会是 Any 。 在匿名对象中添加的成员将无法
     访问。*/
    class C {
        // 私有函数， 所以其返回类型是匿名对象类型
        private fun foo() = object {
            val x: String = "x"
        }

        // 公有函数， 所以其返回类型是 Any
        fun publicFoo() = object {
            val x: String = "x"
        }

        fun bar() {
            val x1 = foo().x // 没问题
            //val x2 = publicFoo().x // 错误： 未能解析的引用“x”
        }
    }
}