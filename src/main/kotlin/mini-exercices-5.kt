fun main() {
    // #1 Create a constant called 'myAge' and set it to your age. Then, create a constant
    // named 'isTeenager' that uses Boolean logic to determine if the age denotes someone
    // in the age range of 13 to 19.
    val myAge = readln().toInt()
    val isTeenager = myAge >= 13 && myAge <= 19
    println(isTeenager) // false
    // #2 Create another constant named theirAge and set it to the age 30. Then, create a constant
    // named 'bothTeenagers' that uses Boolean logic to determine if both you and them are teenagers.
    val theirAge = readln().toInt()
    val bothTeenagers = (myAge >= 13 && myAge <= 19) && (theirAge >= 13 && theirAge <= 19)
    println(bothTeenagers) // false
    // #3 Create a constant named 'reader' and set it to your name as a string. Create a constant
    // named 'author' and set it to the name 'Richard Lucas'. Create a constant named 'authorIsReader'
    // that uses string equality to determine if 'reader' and 'author' are equal.
    val reader = readln()
    val author = "Richard Lucas"
    val authorIsReader = reader == author
    println(authorIsReader) // false
    // #4 Create a constant named 'readerBeforeAuthor' which uses string comparison to determine if
    // 'reader' comes before 'author'.
    val readerBeforeAuthor = reader < author
    if (readerBeforeAuthor) {
        println("Reader comes before author")
    } else {
        println("Author comes before reader")
    }
}