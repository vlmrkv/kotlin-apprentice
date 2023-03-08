fun main() {
    // 1. Write a 'when' expression that takes an age as an integer and prints out the life
    // stage related to that age. You can make up the life stages, or use the categorization as
    // follows: 0-2 years, Infant; 3-12 years, Child; 13-19 years, Teenager; 20-39, Adult;
    // 40-60, Middle aged; 61+, Elderly.
    val years = readln().toInt()
    when (years) {
        in 0..2 -> println("Infant")
        in 3..12 -> println("Child")
        in 13..19 -> println("Teenager")
        in 20..39 -> println("Adult")
        in 40..60 -> println("Middle aged")
        else -> println("Elderly")
    }

    // 2. Write a 'when' expression that destructures a 'Pair' containing a string and an integer.
    // The string is a name, and the integer is an age. Use the same cases that you used in the
    // previous exercise to print out the name followed by the life stage. For example, for myself
    // it would print out "Joe is an adult."
    val name = readln()
    val age = readln().toInt()
    val Pair = Pair(name, age)
    when (Pair.second) {
        in 0..2 -> println("${Pair.first} is an infant")
        in 3..12 -> println("${Pair.first} is a child")
        in 13..19 -> println("${Pair.first} is a teenager")
        in 20..39 -> println("${Pair.first} is an adult")
        in 40..60 -> println("${Pair.first} is a middle aged")
        else -> println("${Pair.first} is an elderly")
    }

}