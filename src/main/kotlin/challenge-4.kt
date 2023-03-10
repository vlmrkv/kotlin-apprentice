import kotlin.math.*

fun main() {
    // 1. In the following 'for' loop, what will be the value of 'sum', and how many iterations
    // will happen?
    var sum = 0
    for (i in 0..5) { // 6 iteration will happen
        sum += 1 // sum will be 6
    }

    // 2. In the 'while' loop below, how many instances of "a" will there be in 'aLotOfAs'?
    var aLotOfAs = ""
    while (aLotOfAs.length < 10) {
        aLotOfAs += "a"
    }
    println(aLotOfAs.count()) // 10 instances of "a"

    // 3. Consider the following 'when' expression.
    // What will this code print when 'coordinates' is each of the following?
//    val (x, y, z) = Triple(1, 5, 0) // On the x/y plane
//    val (x, y, z) = Triple(2, 2, 2) // x = y = z
//    val (x, y, z) = Triple(3, 0, 1) // On the x/z plane
//    val (x, y, z) = Triple(3, 2, 5) // Nothing special
//    val (x, y, z) = Triple(0, 2, 4) // On the y/z plane

    when {
        x == y && y == z -> println("x = y = z")
        z == 0 -> println("On the x/y plane")
        y == 0 -> println("On the x/z plane")
        x == 0 -> println("On the y/z plane")
        else -> println("Nothing special")
    }

    // 4. A closed range can never be empty. Why?
    val range = 5 until 5
    val range2 = 5..5 // the second number included in the range
    println(range)
    println(range.isEmpty())
    println(range2)
    println(range2.isEmpty())

    // 5. Print a countdown from 10 to 0 without using downTo.
    val interval = 0..10
    for (i in interval) {
        println(10 - i)
    }

    // 6. Print 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0.
    var number = 0.0
    println(number)
    for (i in 1..10) {
        number += 0.1
        println(number)
    }
}