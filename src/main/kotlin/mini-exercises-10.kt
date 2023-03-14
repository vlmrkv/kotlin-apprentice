fun main() {
    // 1. Write a function named 'printFullName' that takes two string called 'firstName'
    // and 'lastName'. The function should print out the full name defined as 'firstName' + " " +
    // 'lastName'. Use it to print out your own full name.
    println("Input your first name:")
    val firstName = readln()
    println("Input your last name:")
    val lastName = readln()
    println(printFullName(firstName, lastName))

    // 2. Call 'printFullName' using named arguments.
    println(printFullName(firstName = "Vladislav", lastName = "Markov"))

    // 3. Write a function named 'calculateFullName' that returns the full name as a string.
    // Use it to store your own full name in a constant.
    val myFullName = calculateFullName(firstName, lastName)
    println(myFullName)

    // 4. Change 'calculateFullName' to return a 'Pair' containing both the full name and the length
    // of the name. You can find a string's length by using the 'length' property. Use this function
    // to determine the length of your own full name.
    val fullName = "$firstName $lastName"
    val length= fullName.length - 1
    println(calculateFullName(fullName, length))
}

fun printFullName(firstName: String, lastName: String): String {
    return ("$firstName $lastName")
}

fun calculateFullName(firstName: String, lastName: String): String {
    return ("$firstName $lastName")
}

fun calculateFullName(fullName: String, length: Int): Pair<String, Int> {
    return Pair(fullName, length)
}