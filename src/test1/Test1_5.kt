package test1

class Test1_5 {
    fun test() {
        InitOrderDemo("order")
        Constructors(1)
    }

    //无类体，可以不写花括号
    class Empty

    //类主构造函数
    class Person constructor(name: String) {

    }

    //主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字
    class Person2(name: String) {

    }

    //主构造函数不能包含任何的代码。 初始化的代码可以放到以 init 关键字作为前缀的初始化块（ initializer blocks） 中
    class InitOrderDemo(name: String) {
        val firstProperty = "First property: $name".also(::println)

        init {
            println("First initializer block that prints ${name}, $firstProperty")
        }

        val secondProperty = "Second property: ${name.length}".also(::println)

        init {
            println("Second initializer block that prints ${name.length}")
        }
    }

    //如果构造函数有注解或可见性修饰符， 这个 constructor 关键字是必需的， 并且这些修饰符在它前面
    //class Customer public @Inject constructor(name: String) { }

    //类也可以声明前缀有 constructor 的次构造函数
    class Person3 {
        constructor(parent: Person) {
            //parent.children.add(this)
        }
    }

    //如果类有一个主构造函数， 每个次构造函数需要委托给主构造函数， 可以直接委托或者通过
    //别的次构造函数间接委托。 委托到同一个类的另一个构造函数用 this 关键字即可
    class Person4(val name: String) {
        constructor(name: String, parent: Person) : this(name) {
            //parent.children.add(this)
        }
    }

    //请注意， 初始化块中的代码实际上会成为主构造函数的一部分。 委托给主构造函数会作为次
    //构造函数的第一条语句， 因此所有初始化块中的代码都会在次构造函数体之前执行。 即使该
    //类没有主构造函数， 这种委托仍会隐式发生， 并且仍会执行初始化块
    class Constructors {
        init {
            println("Init block")
        }

        constructor(i: Int) {
            println("Constructor")
        }
    }

    //如果一个非抽象类没有声明任何（ 主或次） 构造函数， 它会有一个生成的不带参数的主构造
    //函数。 构造函数的可见性是 public。 如果你不希望你的类有一个公有构造函数， 你需要声明一
    //个带有非默认可见性的空的主构造函数
    class DontCreateMe private constructor () {
    }

    //注意： 在 JVM 上， 如果主构造函数的所有的参数都有默认值， 编译器会生成 一个额外
    //的无参构造函数， 它将使用默认值。 这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样
    //的通过无参构造函数创建类的实例的库。
    class Customer(val customerName: String = "")
}