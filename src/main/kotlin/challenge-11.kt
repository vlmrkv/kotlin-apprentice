fun main() {
    val student = Student(null, null)
    val map1 = mapOf<String, String>()
    val map2 = mapOf("firstName" to "Richard", "lastName" to "Feynman")
    student.loadStudent(map1)
    student.loadStudent(map2)
}

// 1. Create a named object that lets you check whether a given 'Int' value is above a threshold.
// Name the object 'Threshold' and add a method 'isAboveThreshold(value: Int)'.
object Threshold {
    const val upperValue = 10
    fun isAboveThreshold(value: Int) {
        value > upperValue
    }
}

// 2. Create a version of the 'Student' class that uses a factory method 'loadStudent(studentMap: Map<String, String>)'
// to create a student with a first and last name from a map such as 'mapOf("first_name" to "Neils",
// "last_name" to "Bohr")'. Default to using "First" and "Last" as the names if the map not contain a
// first name or last name.
data class Student(
    val firstName: String?,
    val lastName: String?
) {
    fun loadStudent(studentMap: Map<String, String>): Student {
        val firstName = studentMap["firstName"] ?: "First"
        val lastName = studentMap["lastName"] ?: "Last"
        println("$firstName $lastName")
        return Student(firstName, lastName)
    }
}

// 3. Create an anonymous object that implements the following interface:
interface ThresholdChecker {
    val lower: Int
    val upper: Int

    /**
     * Returns true if value is higher than the upper threshold and false otherwise
     */
    fun isLit(value: Int): Boolean

    /**
     * Returns true if value is less than the lower threshold and false otherwise
     */
    fun tooQuiet(value: Int): Boolean
}

// Use a lower value of 7 and an upper value of 10 in the anonymous object.
val thresholdChecker = object : ThresholdChecker {
    override val lower = 7
    override val upper = 10

    override fun isLit(value: Int): Boolean {
        return value > upper
    }

    override fun tooQuiet(value: Int): Boolean {
        return value < lower
    }
}