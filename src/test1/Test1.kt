package test1

class Test1 {
    fun test() {
//        println("2+3=${add1(2, 3)}")
//        println("2+3=${add2(2, 3)}")
//        println("2+3=${add3(2, 3)}")
//        add4(2, 3)
//        add5(2, 3)
//        strTemplate1()
//        println(maxOf1(2, 3))
//        println(parseInt("a"))
//        println(getStringLength(12345))
//        for1()
//        while1()
//        println(when1("Hello"))
//        in1()
//        when2()
//        filterAndMap()
    }

    fun filterAndMap() {
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        //lambda表达式也可简写
        fruits.filter { item -> item.startsWith("a") }
                .sortedBy { item -> item }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

    fun when2() {
        val set1 = setOf(1, 2, 3, 4)
        when {
            1 in set1 -> println("1 in set1")
            2 in set1 -> println("2 in set1")
        }
    }

    fun in1() {
        val list1 = listOf("1", "2", "3", "4", "5")
        println("1" in list1)
        println(5 !in list1.indices)
        println(1 in 1..10)
        for (x in 1..5) {
            print(x)
        }
        println()
        for (x in 1..5 step 2) {
            print(x)
        }
        println()
        for (x in 9 downTo 3 step 2) {
            print(x)
        }
    }

    fun when1(obj: Any): String =
            when (obj) {
                1 -> "one"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

    fun while1() {
        val list1 = listOf("abc", "def", "ghi")
        var index = 0;
        while (index < list1.size) {
            println(list1[index++])
        }
    }

    fun for1() {
        val list1 = listOf("abc", "def", "ghi")
        for (item in list1) {
            println(item)
        }
        for (index in list1.indices) {
            println(list1[index])
        }
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    fun maxOf1(a: Int, b: Int): Int = if (a > b) a else b

    fun strTemplate1() {
        var a = 1;
        var str = "a was $a"
        a = 2
        println("$str, now a is $a")
    }

    fun add1(a: Int, b: Int): Int {
        return a + b
    }

    fun add2(a: Int, b: Int): Int = a + b

    fun add3(a: Int, b: Int) = a + b

    //无返回值
    fun add4(a: Int, b: Int): Unit {
        println("$a+$b=${a + b}")
    }

    //返回值可省略
    fun add5(a: Int, b: Int) {
        println("$a+$b=${a + b}")
    }
}