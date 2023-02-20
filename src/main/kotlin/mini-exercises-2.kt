fun main() {
    // Check using Control+Shift+P that the type for both has been inferred correctly as Int.
    val age1 = 42
    val age2 = 21
    val avg1 = (age1 + age2) / 2 //answer 31 is wrong
    println(avg1)
    val avg2: Double = (age1 + age2).toDouble() / 2 //answer 31.5 is correct
    println(avg2)
}