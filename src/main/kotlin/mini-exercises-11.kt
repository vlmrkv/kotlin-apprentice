fun main() {
    // 1. Make a nullable 'String' called 'myFavoriteSong'. If you have a favorite song, set it
    // to a string representing that song. If you have more than one favorite song or no favorite,
    // set the nullable to 'null'.
    var myFavoriteSong: String? = null

    // 2. Create a constant called 'parsedInt' and set it equal to "10".toIntOrNull(); this will
    // try to parse the string "10" and convert it to an 'Int'. Check the type of 'parsedInt'.
    // Why is it a nullable?
    val parsedInt = "10".toIntOrNull()
    println(parsedInt) // 10

    // 3. Change the string being parsed in the above exercise to a non-integer. What does 'parseInt'
    // equal now?
    val parseInt2 = "cat".toIntOrNull()
    println(parseInt2) // null
}