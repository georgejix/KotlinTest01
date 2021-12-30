package test1

class Test1_4 {
    fun test() {
        testLabel()
    }

    fun testLabel() {
        //标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点
        num@ for (i in 1..10) {
            print(i)
            if (5 == i) {
                break@num
            }
        }
        println("\n1--10")

        listOf(1, 2, 3, 4, 5).forEach num2@{
            if (3 == it) {
                //局部返回到该 lambda 表达式的调用者， 即 forEach 循环
                return@num2
            }
            print(it)
        }
        println("\n1--5")

        //通常情况下使用隐式标签更方便。 该标签与接受该lambda 的函数同名
        listOf(1, 2, 3, 4, 5).forEach {
            if (3 == it) {
                //局部返回到该 lambda 表达式的调用者， 即 forEach 循环
                return@forEach
            }
            print(it)
        }
        println("\n1--5")

        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
                print(it)
            }
        }
        println("\ndone with nested loop")
        //当要返一个回值的时候， 解析器优先选用标签限制的 return， 即
        //return@a 1
    }
}