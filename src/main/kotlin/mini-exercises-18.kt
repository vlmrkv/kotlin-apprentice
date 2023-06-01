fun main() {
    val numbers = arrayListOf(1, 2, 3)
    numbers.removeAt(numbers.lastIndex)
    println(numbers)

    val date2 = SimpleDate2("October")
    println(date2.monthsUntilWinterBreak(date2)) // 2

    val date3 = SimpleDate3("September")
    date3.monthsUntilWinterBreak() // 3

    val date4 = SimpleDate4("November")
    println(date4.monthsUntilWinterBreak) // 1

    println(MyMath.factorial(6)) // 720
    println(MyMath.triangleNumber(4)) // 10

    val date = SimpleDate()
    date.month = "December"
    println(date.monthsUntilSummerBreak()) // 6

    println(4.abs()) // 4
    println((-4).abs()) // 4

    println(MyMath.primeFactors(81)) //
}

val months = arrayOf(
    "January", "February", "March",
    "April", "May", "June",
    "July", "August", "September",
    "October", "November", "December"
)

class SimpleDate() {
    var month: String = "January"

    val monthsUntilWinterBreak: Int
        get() {
            return months.indexOf("December") - months.indexOf(month)
        }
}

fun SimpleDate.monthsUntilSummerBreak(): Int {
    val monthIndex = months.indexOf(month)
    return if (monthIndex in 0..months.indexOf("June")) {
        months.indexOf("June") - months.indexOf(month)
    } else if (monthIndex in months.indexOf("June")..months.indexOf("August")) {
        0
    } else {
        months.indexOf("June") + (12 - months.indexOf(month))
    }
}

class SimpleDate1(var month: String)

fun monthsUntilWinterBreak(from: SimpleDate1): Int {
    return months.indexOf("December") - months.indexOf(from.month)
}

class SimpleDate2(var month: String) {
    fun monthsUntilWinterBreak(from: SimpleDate2): Int {
        return months.indexOf("December") - months.indexOf(from.month)
    }
}

class SimpleDate3(private var month: String) {
    fun monthsUntilWinterBreak(): Int {
        return months.indexOf("December") - months.indexOf(this.month)
    }
}

// Transform the method 'monthsUntilWinterBreak()' into a property with a customer getter.
class SimpleDate4(private var month: String) {
    val monthsUntilWinterBreak: Int
        get() {
            return months.indexOf("December") - months.indexOf(month)
        }

}

class MyMath {
    companion object {
        fun factorial(number: Int): Int {
            return (1..number).fold(1) { a, b -> a * b }
        }

        fun triangleNumber(number: Int): Int {
            return (1..number).fold(0) { a, b -> a + b }
        }
    }
}

fun Int.abs(): Int {
    return if (this < 0) -this else this
}

fun MyMath.Companion.primeFactors(value: Int): List<Int> {
    var remainingValue = value
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