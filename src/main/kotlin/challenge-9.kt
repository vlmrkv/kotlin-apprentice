fun main() {
    repeatTask(6, task = { println("Kotlin is cool!") })
    println(mathSum(10) { it * it })
    println(mathSum(10) { fibonacciNumbersSum(it) })
    appRatings.forEach {
        val sum = it.value.reduce(Int::plus)
        averageRatings[it.key] = sum.toDouble() / it.value.size
    }
    println(averageRatings)
    val filteredApps = averageRatings.filter {
        it.value > 3
    }.map { it.key }
    println(filteredApps)
}

// 1. Repeating yourself. Write a function that will run a given lambda a given number of times.
fun repeatTask(times: Int, task: () -> Unit) {
    for (i in 0 until times) {
        task()
    }
}

// 2. Lambda sums. Write a function that you can reuse to create different mathematical sums.
fun mathSum(length: Int, series: (Int) -> Int): Int {
    var result = 0
    for (i in 0 .. length) {
        result += series(i)
    }
    return result
}

fun fibonacciNumbersSum(n: Int): Int {
    if (n <= 0) {
        return 0
    }
    if (n == 1 || n == 2) {
        return 1
    }
    return fibonacciNumbersSum(n - 1) + fibonacciNumbersSum(n - 2)
}

// 3. Functional ratings. First, create a map called 'averageRatings' which will contain a mapping of
// app names to average ratings. Use 'forEach' to iterate through the 'appRatings' map, then use 'reduce'
// to calculate the average rating and store this rating in the 'averageRatings' map.
// Finally, use 'filter' and 'map' chained together to get a list of the app names whose average
// rating is greater than 3.
val appRatings = mapOf(
    "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
    "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
    "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
)

val averageRatings: MutableMap<String, Double> = mutableMapOf()