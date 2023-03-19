fun main() {
    // 1. You be the compiler. Which of the following are valid statements?
//    var name: String? = "Ray" // valid
//    var age: Int = null // not valid (null can't be a value for a non-null type)
//    var distance: Float = 26.7 // not valid (without a 'f' literal it is a Double type)
//    var middleName: String? = null // valid

    divideIfWhole(10, 2)
    divideIfWhole(10, 3)

    // 3. Refactor and reduce
    val x = divideIfWhole(10, 2) ?: 0
    println("It divides $x times.")
    val y = divideIfWhole(10, 3) ?: 0
    println("It divides $y times.")
}

// 2. Divide and conquer
fun divideIfWhole(value: Int, divisor: Int): Int? {
    if (value % divisor == 0) {
        val times = value / divisor
        println("Yep, it divides $times times.")
        return times
    } else {
        println("Not divisible :[")
        return null
    }
}