fun main() {
    val firstName: String? = readlnOrNull()
    val lastName: String? = readlnOrNull()
    val fullName: String = firstName + " " + lastName
    val myDetails: String = "Hello, my name is $fullName"
    println(myDetails)
}