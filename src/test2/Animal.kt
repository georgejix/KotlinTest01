package test2

sealed class Animal {
    fun say() {
        println("say");
    }

    //中缀表达式
    infix fun eat(food:String){
        println("eat ${food}");
    }

    class Cat : Animal()
    class Dog : Animal()
}