package test1

class Test1_14 {
    fun test() {
        var list1 = listOf(1, 2, 3, 4, 5)
        list1.fold(0) { acc, result ->
            var res = acc + result
            println("result=$res")
            res
        }

        var a = "123"
        var b = a.length ?: -1
        println("b=$b")

        testLocalWith()
    }

    fun <T> localWith(t: T, body: T.(a: Int) -> Unit) {
        t.body(11)
    }

    fun testLocalWith() {
        localWith(Test1_14()) { a -> println("$a") }
        localWith(Test1_14()) { println("$it") }
        with(Test1_14()) { println("iii") }
    }
}