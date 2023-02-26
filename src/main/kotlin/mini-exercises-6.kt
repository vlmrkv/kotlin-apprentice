fun main() {
    // #1 Create a constant named 'myAge' and initialize it with your age. Write an if expression
    // to print out 'Teenager' if your age is between 13 and 19, and 'Not a teenager' if your age is not
    // between 13 and 19.
    val myAge: Int = readln().toInt()
    if (myAge >= 13 && myAge <= 19) {
        println("Teenager")
    } else {
        println("Not a teenager")
    }
    // #2 Create a constant called 'answer' and use a single line if-else expression to set it equal
    // to the result you print out for the same cases in the above exercise. Then print out 'answer'.
    val answer: String = if (myAge >= 13 && myAge <= 19) "Teenager" else "Not a teenager"
    println(answer)
}