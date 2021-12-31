package test1

import kotlin.reflect.KProperty

class Test1_12 {
    fun test() {
        register(object : Listener {
            override fun click(msg: String) {
                println(msg)
            }

        })
        register2(object : Listener2() {
            override fun click(msg: String) {
                println(msg)
            }

        })
        val b = BaseImpl(10)
        Derived(b).print()

        var s = DelegateImpl()
        println(s.p)
        s.p = "123"

        val lazyV: String by lazy {
            println("init lazyV")
            "hello"
        }
        println(lazyV)
        println(lazyV)

    }

    interface Listener {
        fun click(msg: String)
    }

    fun register(listener: Listener) {
        listener.click("click!")
    }

    abstract class Listener2 {
        open fun click(msg: String) {}
    }

    fun register2(listener: Listener2) {
        listener.click("click!")
    }

    //委托实现
    interface Base {
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override fun print() {
            print(x)
        }
    }

    class Derived(b: Base) : Base by b
    class Derived2(b: Base) : Base by b {
        //如果又重写了这个方法，会覆盖委托实现中的该方法
        override fun print() {
        }
    }

    //委托属性
    class DelegateImpl {
        var p: String by Delegate()
    }

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }

    class DelegateMap(map: MutableMap<String, String>) {
        var a: String by map
    }
}