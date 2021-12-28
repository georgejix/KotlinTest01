package test1

class Test1_2 {
    fun test() {
        //不需要new关键字，直接就可以实例化
        var rect = Rectangle(10.0, 8.0)
        println("rect area = ${rect.calculateArea()},perimeter = ${rect.perimeter}")

        var triangle = Triangle(5.0, 4.0, 3.0)
        println("triangle area = ${triangle.calculateArea()},perimeter = ${triangle.perimeter}")
    }

    abstract class Shape(private val sides: List<Double>) {
        val perimeter: Double get() = sides.sum()
        abstract fun calculateArea(): Double
    }

    interface RectangleProperties {
        val isSquare: Boolean
    }

    class Rectangle(private val height: Double, private val width: Double) :
            Shape(listOf(height, height, width, width)), RectangleProperties {
        override fun calculateArea(): Double {
            return width * height
        }

        override val isSquare: Boolean get() = width == height
    }

    class Triangle(var sideA: Double, var sideB: Double, var sideC: Double)
        : Shape(listOf(sideA, sideB, sideC)) {
        override fun calculateArea(): Double {
            val s = perimeter / 2
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
        }

    }
}