import kotlin.math.PI

// 1. Given the 'Circle' class below:
// write a method that can change an instance's area by a growth factor. For example if you call
// circle.grow(factor = 3), the area of the instance will triple.
class Circle(var radius: Double = 0.0) {
    val area: Double
        get() {
            return PI * radius * radius
        }
}

fun Circle.grow(factor: Int): Double {
    return area * factor
}

// 2. Here is a naive way of writing advance() for the SimpleDate class your saw earlier in the chapter:
// What happens when the function should go from the end of one month to the start of the next?
// Rewrite advance() to account for advancing from December 31st to January 1st.
val months = arrayOf(
    "January", "February", "March",
    "April", "May", "June",
    "July", "August", "September",
    "October", "November", "December"
)

class SimpleDate(var month: String, var day: Int = 0) {
    fun advance() {
        if (month == "December" && day == 31) {
            month = "January"
            day = 1
        } else {
            day += 1
        }
    }
}

fun main() {
    // 1
    val circle = Circle(4.0)
    println(circle.area)
    println(circle.grow(4))

    // 2
    var date = SimpleDate(month = "December", day = 31)
    date.advance()
    println(date.month) // December; should be January!
    println(date.day) // 32; should be 1!

    // 3
    val number = MyMath
    println(number.isEven(2))
    println(number.isOdd(3))

    // 4
    println(2.isEven())
    println(3.isOdd())

    // 5
    println(81.primeFactors())
}

// 3. Create a Kotlin object named 'MyMath' with isEven() and isOdd() methods that return true if
// a number is even or odd respectively.
object MyMath {
    fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    fun isOdd(number: Int): Boolean {
        return number % 2 != 0
    }
}

// 4. Add extension methods isEven() and isOdd() to Int.
fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun Int.isOdd(): Boolean {
    return this % 2 != 0
}

// 5. Add the extension method primeFactors() to Int. Since this is an expensive operation,
// this is best left as an actual method.
fun Int.primeFactors(): List<Int> {
    var remainingValue = this
    var testFactor = 2
    val primes = mutableListOf<Int>()
    while (testFactor * testFactor <= remainingValue) {
        if (remainingValue % testFactor == 0) {
            primes.add(testFactor)
            remainingValue /= testFactor
        } else {
            testFactor += 1
        }
    }

    if (remainingValue > 1) {
        primes.add(remainingValue)
    }

    return primes
}