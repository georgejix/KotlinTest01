package test1

import java.io.File

class Test1_3 {
    fun test() {
//        testClass()
        常用代码()
//        test1()
//        test2()
    }

    fun test2() {
        var a:Int? = null
        var b = a ?: return
        println("bbb")
    }

    fun test1() {
        val a: Int = 2
        val b: Long = 1
        println(a.equals(b))
        println(1.5 in 1.0..2.0)

        val str: String = "abcdrfg"
        println(str[2])
        for (c in str) {
            print(c)
        }
        println()
        println(str.reversed())

        //if 的分支可以是代码块， 最后的表达式作为该块的值
        val max = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        println()

        var c = when (max) {
            a, 2 -> println("a")
            else -> null
        }
        println(c)
        var d = when {
            max == 2 -> println("a")
            else -> null
        }
        println(d)
    }

    fun 常用代码() {
        var list1 = listOf(1, 2, 3, 4, 5, 6)
        list1.filter { x -> x > 3 }
                .forEach { item -> print(item) }
        println()
        //或者省略参数，使用默认参数
        list1.filter { it > 3 }
                .forEach { print(it) }
        println()

        //遍历map
        var map1 = mapOf("a" to "123", "b" to "456", "c" to "789")
        for ((k, v) in map1) {
            println("$k->$v")
        }

        //区间
        for (i in 1..10) {
            print("$i")
        }
        println()
        for (i in 1 until 10) {
            print("$i")
        }
        println()
        for (i in 10 downTo 1) {
            print("$i")
        }
        println()

        //访问map
        println(map1["a"])

        //延时属性
        val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }
        println("----------")
        println(lazyValue)

        //扩展函数
        fun String.addSuffix(): String {
            return this + ".suffix"
        }
        println("ss".addSuffix())

        //单例
        var name1 = Name.name
        println(name1)

        //if not null缩写
        val files = File("Test").listFiles()
        println(files?.size)

        //if not null and else缩写
        println(files?.size ?: "empty")

        //if null
        println(files ?: "empty")

        //有可能会空的list
        var list2 = listOf<Int>()
        println(list2.firstOrNull() ?: "kong")

        //if not null执行一段代码
        var value = 123
        value?.let { println("value not null") }

        //try catch
        var a = try {
            1 + 1
        } catch (e: Exception) {
            3
        }
        println(a)

        //if表达式
        println(if1(3))

        var intArray1 = IntArray(3).apply { fill(-1) }
        intArray1.forEach { print(it) }
        println()

        //对一个对象调用多个方法
        var person = Person("张三")
        with(person) {
            eat()
            speak()
        }
    }

    class Person(n: String) {
        var name: String = n
        fun eat() {
            println("$name eat")
        }

        fun speak() {
            println("$name speak")
        }
    }

    fun if1(input: Int): String {
        return if (1 == input) {
            "one"
        } else if (2 == input) {
            "two"
        } else {
            "more than two"
        }
    }

    object Name {
        val name = "Name"
    }

    //数据类，自动生成成员变量的get，set方法，equals方法
    //sex设置了默认参数
    data class Stu(var name: String, var age: Int, var sex: String = "male")

    fun testClass() {
        var stu = Stu("张三", 18)
        println("${stu.name} age is ${stu.age} sex = ${stu.sex}")

        var stu2 = Stu("张三", 18)
        println("stu == stu2 : ${stu.equals(stu2)}")
    }
}