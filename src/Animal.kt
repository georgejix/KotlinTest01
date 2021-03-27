sealed class Animal {
    fun say() {
        println("say");
    }

    class Cat : Animal()
    class Dog : Animal()
}