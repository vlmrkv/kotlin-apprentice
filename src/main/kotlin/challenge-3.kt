import kotlin.math.*

fun main() {
    // #1 What's wrong with the following code?
    val firstName = "Joe"

    if (firstName == "Howard") {
        val lastName = "Lucas"
    } else if (firstName == "Ray") {
        val lastName = "Wenderlich"
    }

    val fullName = firstName + " " + lastName // 'lastName' unavailable

    // #2 In each of the following statements, what is the value of the Boolean 'answer' constant?
    val answer1 = true && true // constant
    val answer2 = false || false // constant
    val answer3 = (true && 1 != 2) || (4 > 3 && 100 < 1) // constant
    val answer4 = ((10 / 2) > 3) && ((10 % 2) == 0)

    // #3 Suppose the squares on a chessboard are numbered left to right, top to bottom, with 0 being the
    // top-left square and 63 being the bottom-right square. Rows are numbered top to bottom, 0 to 7.
    // Columns are numbered left to right, 0 to 7. Given a current position on the chessboard, expressed
    // as a row and column number, calculate the next position on the chessboard, again expressed as row
    // and column number. The ordering is determined by the numbering from 0 to 63.
    // The position after 63 is again 0.
    println("Input a row:")
    val row = readln().toInt()
    println("Input a column:")
    val column = readln().toInt()
    var nextRow = row
    var nextColumn = column + 1
    if (nextColumn > 7) {
        nextColumn = 0
        nextRow += 1
    }
    if (nextRow > 7) {
        nextRow = 0
    }
    println("Next row is $nextRow, next column is $nextColumn")

    // #4 Given the coefficients a, b and c, calculate the solutions to a quadratic equation with these
    // coefficients. Take into account the different number of solutions (0, 1 or 2).
    println("Input coefficient a:")
    val a = readln().toDouble()
    println("Input coefficient b:")
    val b = readln().toDouble()
    println("Input coefficient c:")
    val c = readln().toDouble()

    var discr: Double = b.pow(2) - (4 * a * c)
    if (discr > 0) {
        val root1 = (-b + sqrt(discr)) / (2 * a)
        val root2 = (-b - sqrt(discr)) / (2 * a)
        println("First root is $root1, second root is $root2")
    } else if (discr == 0.0) {
        val root = - (b / (2 * a))
        println("The only one root is $root")
    } else {
        println("The quadratic equation has no roots")
    }

    // #5 Given a month (represented with a string in all lowercase) and the current year (represented with
    // an Int), calculate the number of days in the month. Remember that because of leap years, "february"
    // has 29 days when the year is a multiple of 4 but not a multiple of 100. February also has 29 days when
    // the year is a multiple of 400.
    // (jan, mar, may, jul, aug, oct, dec - 31; feb - 28/29; apr, jun, sep, nov - 30)
    val month = readln()
    val year = readln().toInt()
    var days: Int
    if (month == "jan" || month == "mar" || month == "may" || month == "jul" || month == "aug" ||
        month == "oct" || month == "dec") {
        days = 31
        println(days)
    } else if (month == "apr" || month == "jun" || month == "sep" || month == "nov") {
        days = 30
        println(days)
    } else if (month == "feb" && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
        days = 29
        println(days)
    } else if (month == "feb") {
        days = 28
        println(days)
    } else {
        println("This is not a month")
    }

    // #6 Given a number as a 'Double' value, determine if this number is a power of 2.
    val number: Double = readln().toDouble()
    val log = log2(number)
    if (log == log2(number).toInt().toDouble()) {
        println("The number $number is a power of 2")
    } else {
        println("The number $number is not a power of 2")
    }

    // #7 Print a table of the first 20 powers of 2.
    var n = 0
    while (n < 20) {
        println((2.0.pow(n)).toInt())
        n += 1
    }

    // #8 Given a number 'n', calculate the n-th Fibonacci number. Start with 1 and 1 and add these values
    // together to get the next value. The next value is the sum of the previous two.
    val num = readln().toInt()
    var counter2 = 0
    var first = 1
    var second = 1
    while (counter2 < num) {
        var next = first + second
        println(next)
        first = second
        second = next
        counter2 += 1
    }

    // #9 Given a number 'n', calculate the factorial of 'n'.
    var factorial = 1
    var numb = readln().toInt()
    var count = 1
    while (count <= numb) {
        factorial *= count
        count += 1
    }
    println(factorial)

    // #10 Given a number between 2 and 12, calculate the odds of rolling this number using two six-sided dice.
    // Compute it by exhaustively looping through all of the combinations and counting the fraction of outcomes
    // that give you that value. Don't use a formula.
}