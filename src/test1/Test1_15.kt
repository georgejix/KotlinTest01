package test1

class Test1_15 {
    fun test() {
        val a = A(mutableMapOf("name" to "zhangsan", "age" to 18))
        println(a.name)

        val a2 = A("lisi", 19)
        println(a2.name)


        val b: B? = B()
        val ddd = b?.c?.str ?: "233"
        println(ddd)

        val c: C? = null
        if (null != c?.str) {
            println("ccc")
        }

        val d = arrayOf(1,2,3,4)
    }

    class B {
        var c: C? = null
    }

    class C {
        var str: String? = "123"
    }

    class A(map: MutableMap<String, Any>) {
        var name: String by map
        var age: Int by map

        constructor(name: String, age: Int) : this(HashMap()) {
            this.name = name
            this.age = age
        }
    }

}