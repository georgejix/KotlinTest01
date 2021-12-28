package test2

class Father : IWash by Son {
    override fun wash() {
        println("wash by father");
        Son.wash();
    }
}