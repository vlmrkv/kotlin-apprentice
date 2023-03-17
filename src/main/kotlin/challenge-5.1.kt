fun main() {
    // It's prime time.
    println("Input a number")
    val number = readln().toInt()
    println(isPrime(number))
}

fun isNumberDivisible(number: Int, divisor: Int): Boolean {
    return number % divisor == 0
}

fun isPrime(number: Int): Boolean {
    if (number < 0) return false
    for (i in 2 until number) {
        if (isNumberDivisible(number, i)) return false
    }
    return true
}

