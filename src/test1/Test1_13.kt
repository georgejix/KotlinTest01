package test1

class Test1_13 {
    fun test() {
        //如果一个默认参数在一个无默认值的参数之前， 那么该默认值只能通过使用命名参数调用该函数来使用：
        默认参数(baz = 1) // 使用默认值 bar = 0

        //不过如果最后一个 lambda 表达式参数从括号外传给函数函数调用， 那么允许默认参数不传值
        默认参数2 {
            println("qqqqq")
        }

        //如果我们不需要所有的参数：
        默认参数3("str", wordSeparator = '_')

        //当一个函数调用混用位置参数与命名参数时， 所有位置参数都要放在第一个命名参数之前。
        //例如， 允许调用 f(1, y = 2) 但不允许 f(x = 1, 2) 。


        //可以通过使用星号操作符将可变数量参数（ vararg ） 以命名形式传入：
        可变参数(strings = *arrayOf("a", "b", "c"))

        //如果我们已经有一个数组并希望将其内容传给该函数， 我们使用伸展（ spread） 操作符（ 在数组前面加 * ）
        var array1 = intArrayOf(1, 2, 3)
        var array2 = intArrayOf(1, 2, *array1, 3)
        for (i in array2) {
            print("$i,")
        }
        println()

        1 shl_ 2
    }

    fun 默认参数(bar: Int = 0, baz: Int) {
        println("bar=$bar,baz=$baz")
    }

    fun 默认参数2(bar: Int = 0, baz: Int = 1, q: () -> Unit) {
        println("bar=$bar,baz=$baz")
        q()
    }

    fun 默认参数3(str: String,
              normalizeCase: Boolean = true,
              upperCaseFirstLetter: Boolean = true,
              divideByCamelHumps: Boolean = false,
              wordSeparator: Char = ' ') {
    }

    fun 可变参数(vararg strings: String) {
        print("strings=")
        for (s in strings) {
            print("$s,")
        }
        println()
    }

    //中缀表示法
    /*标有 infix 关键字的函数也可以使用中缀表示法（ 忽略该调用的点与圆括号） 调用。 中缀函
    数必须满足以下要求：
    它们必须是成员函数或扩展函数；
    它们必须只有一个参数；
    其参数不得接受可变数量的参数且不能有默认值。*/
    infix fun Int.shl_(x: Int): Int {
        return 1
    }
    // 用中缀表示法调用该函数
    //1 shl_ 2
    // 等同于这样
    //1.shl_(2)

}