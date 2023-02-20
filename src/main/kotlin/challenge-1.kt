import kotlin.math.*
fun main() {
    /* Declare a constant 'exercises' with value 9 and variable 'exercisesSolved' with value 0.
    Increment this variable every time you solve an exercise (including this one)*/
    println("#1")
    val exercises: Int = 9
    var exercisesSolved: Int = 0
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* Given the following code:
    age = 16
    print(age)
    age = 30
    print(age)
    Declare age so that it compiles. Did you use var or val? */
    println("#2")
    var age = 16
    print(age)
    age = 30
    print(age)
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* Consider the following code: */
    println("#3")
    val a1: Int = 46
    val b1: Int = 10
    /* Work out what answer equals when you add the following lines of code: */
    val answer1: Int = (a1 * 100) + b1
    println(answer1)
    val answer2: Int = (a1 * 100) + (b1 + 100)
    println(answer2)
    val answer3: Int = (a1 * 100) + (b1 / 10)
    println(answer3)
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* Add parentheses to the following calculation.
    The parentheses should show the order in which the operations are performed and should not alter
     the result of the calculation */
    println("#4")
    println((5 * 3) - (4 / 2) * 2)
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* Declare two constants a and b of type Double and assign both a value.
    * Calculate the average of a and b and store the result in a constant named average. */
    println("#5")
    val a2: Double = 7.5
    val b2: Double = 4.4
    val average = (a2 + b2) / 2
    println(average)
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* A temperature expressed in C can be converted to F by multiplying by 1.8 then incrementing by 32.
    * In this challenge, do the reverse: convert a temperature from F to C. Declare a constant named
    * Fahrenheit of type Double and assign it a value. Calculate the corresponding temperature in C and
    * store the result in a constant named Celcius. */
    println("#6")
    //to convert temperature from C to F: F = C * 1.8 + 32
    val fahrenheit: Double = 451.0
    val celsius: Double = (fahrenheit - 32) / 1.8
    println(celsius)
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* Suppose the squares on a chessboard are numbered left to right, top to bottom, with 0 being the
    * top-left square and 63 being the bottom-right square. Rows are numbered top to bottom, 0 to 7.
    * Columns are numbered left to right, 0 to 7. Declare a constant position and assign it a value
    * between 0 and 63. Calculate the corresponding row and column numbers and store the results in
    * constants named row and column. */
    println("#7")
    val position: Int = 34
    val row: Int = position / 8
    val column: Int = position % 8
    println("Position $position is at the intersection row $row and column $column")
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* A circle is made up of 2PI radians, corresponding with 360 degrees. Declare a constant degrees
    * of type Double and assign it an initial value. Calculate the corresponding angle in radians and store
    * the result in a constant named radians. */
    println("#8")
    //radian = 180 / pi
    val degrees: Double = 34.7
    val radians: Double = degrees / PI
    println(radians)
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")


    /* Declare four constants named x1, y1, x2 and y2 of type Double. These constants represent the
    * two-dimensional coordinates of two points. Calculate the distance between two points and store
    * the result in a constant named distance. */
    println("#9")
    val x1: Double = 4.3
    val y1: Double = 2.5
    val x2: Double = 1.7
    val y2: Double = 3.4
    val distance: Double = sqrt((x1 - x2).pow(2) + (y1 - y2).pow(2))
    println(distance)
    exercisesSolved += 1
    println("You solved $exercisesSolved exercises")
}