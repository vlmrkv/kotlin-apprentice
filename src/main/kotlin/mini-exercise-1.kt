fun main() {
    println("Input your age:")
    val myAge: Int = readlnOrNull()?.toInt() ?: return println("You input empty string")
    if (myAge == null) {
        println("You input empty string")
    }
    var averageAge: Double = myAge.toDouble()
    println(averageAge.toInt())
    averageAge = ((myAge + 30) / 2).toDouble()
    println(averageAge.toInt())

    println("-------------------")

    val testNumber = 10
    val evenOdd = testNumber % 2
    println(evenOdd)

    println("-------------------")

    var answer = 0
    answer += 1
    answer += 10
    answer *= 10
    answer shr 3
    println(answer)
}

