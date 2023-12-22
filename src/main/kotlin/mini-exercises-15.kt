//import kotlin.random.Random
//
//fun main() {
//    println(john.fullName)
//
//    var homeOwner = john
//    john.firstName = "John"
//    println(john.firstName)
//    println(homeOwner.firstName)
//
//    // Change the value of 'lastName' on 'homeOwner', then try reading 'fullName' on both 'john'
//    // and 'homeOwner'. What do you observe?
//    homeOwner.lastName = "Malkovich"
//    println(john.fullName) // John Malkovich
//    println(homeOwner.fullName) // John Malkovich
//
//    // Object identity
//    println(homeOwner === john) // true
//    println(john === homeOwner) // true
//    println(john === impostorJohn) // false
//    println(impostorJohn === homeOwner) // false
//
//    // Assignment of existing vars changes the instances the vars reference.
//    homeOwner = impostorJohn
//    println(john === homeOwner) // false
//
//    homeOwner = john
//    println(john === homeOwner) // true
//
//    // Equality (==) is not effective when John cannot be identified by his name alone
//    imposters.map {
//        it.firstName == "John" && it.lastName == "Wick"
//    }.contains(true) // true
//
//    // Check to ensure the real John is not found among the imposters.
//    println(imposters.contains(john)) // false
//
//    // Now hide the "real" John somewhere among the imposters.
//    val mutableImposters = mutableListOf<Person>()
//    mutableImposters.addAll(imposters)
//    mutableImposters.contains(john) // false
//    mutableImposters.add(Random.nextInt(5), john)
//
//    // John can now be found among the imposters.
//    println(mutableImposters.contains(john)) // true
//
//    // Since 'Person' is a reference type, you can use === to grab the real John out of the list of
//    // imposters and modify the value. The original 'John' variable will print the new last name!
//    val indexOfJohn = mutableImposters.indexOf(john)
//    if (indexOfJohn != -1) {
//        mutableImposters[indexOfJohn].lastName = "Malkovich"
//    }
//    println(john.fullName) // John Malkovich
//
//    // Test of 'memberOf()'
//    val group1 = mutableListOf<Person>(
//        Person(firstName = "Johnny", lastName = "Mnemonic"),
//        Person(firstName = "John", lastName = "Appleseed"),
//        john,
//        Person(firstName = "Jack", lastName = "Ripper"),
//        Person(firstName = "Jim", lastName = "Hawkins"),
//    )
//    val group2 = mutableListOf(
//        Person(firstName = "Johnny", lastName = "Mnemonic"),
//        Person(firstName = "John", lastName = "Appleseed"),
//        Person(firstName = "Jack", lastName = "Black"),
//        Person(firstName = "Jack", lastName = "Ripper"),
//        Person(firstName = "Jim", lastName = "Hawkins"),
//    )
//    println(memberOf(john, group1)) // true
//    println(memberOf(john, group2)) // false
//
//    val jane = Student(firstName = "Jane", lastName = "Appleseed")
//    val history = Grade(letter = "B", points = 9.0, credits = 3.0)
//    var math = Grade(letter = "A", points = 16.0, credits = 4.0)
//
//    jane.recordGrade(history)
//    jane.recordGrade(math)
//
//    //jane = Student(firstName = "John", lastName = "Wick") // jane is a 'val'
//    var jane2 = Student(firstName = "Jane", lastName = "Soldier")
//    jane2 = Student(firstName = "John", lastName = "Wick")
//    println(jane.gradePointAverage)
//
//    println(jane.credits) // 7.0
//    // The teacher made a mistake; math has 5 credits
//    math = Grade(letter = "A", points = 20.0, credits = 5.0)
//    jane.recordGrade(math)
//
//    println(jane.credits) // 12.0, not 8.0!!! It was recorded twice because class instances are mutable.
//
//    // Data classes
//    val albert = Student2(
//        firstName = "Albert",
//        lastName = "Einstein",
//        id = 1
//    )
//    val richard = Student2(
//        firstName = "Richard",
//        lastName = "Feynman",
//        id = 2
//    )
//    val albertCopy = albert.copy()
//
//    println(albert)
//    println(richard)
//    println(albert == richard) // false
//    println(albert == albertCopy) // true
//    println(albert === albertCopy) // false
//
//    val marie = StudentData("Marie", "Curie", id = 1)
//    val emmy = StudentData("Emmy", "Noether", id = 2)
//    val marieCopy = marie.copy()
//
//    println(marie)
//    println(emmy)
//    println(marie == emmy) // false
//    println(marie == marieCopy) // true
//    println(marie === marieCopy) // false
//
//    // Destructuring declarations
//    val (firstName, lastName, id) = marie
//    println(firstName)
//    println(lastName)
//    println(id)
//}
//
//// Creating classes
//open class Person(var firstName: String, var lastName: String) {
//    val fullName
//        get() = "$firstName $lastName"
//}
//
//val john = Person(firstName = "Johnny", lastName = "Appleseed")
//
//// Reference types
//class SimplePerson(val name: String)
//
//var var1 = SimplePerson(name = "John")
//var var2 = var1
//
//val impostorJohn = Person(firstName = "John", lastName = "Appleseed")
//
//// Create fake, imposter Johns.
//var imposters = (0..100).map {
//    Person(firstName = "John", lastName = "Wick")
//}
//
//fun memberOf(person: Person, group: List<Person>): Boolean {
//    return group.contains(person)
//}
//
//// Methods and mutability
//class Grade(
//    val letter: String,
//    val points: Double,
//    val credits: Double
//)
//
//class Student(
//    val firstName: String,
//    val lastName: String,
//    val grades: MutableList<Grade> = mutableListOf(),
//    var credits: Double = 0.0,
//) {
//    val gradePointAverage: Double
//        get() {
//            var totalPts = 0.0
//            grades.forEach {
//                totalPts += it.points
//            }
//            return totalPts / credits
//        }
//    fun recordGrade(grade: Grade) {
//        grades.add(grade)
//        credits += grade.credits
//    }
//}
//
//// Data classes
//class Student2(
//    var firstName: String,
//    var lastName: String,
//    var id: Int
//) {
//    override fun hashCode(): Int {
//        val prime = 31
//        var result = 1
//
//        result = prime * result + firstName.hashCode()
//        result = prime * result + id
//        result = prime * result + lastName.hashCode()
//
//        return result
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other)
//            return true
//
//        if (other == null)
//            return false
//
//        if (javaClass != other.javaClass)
//            return false
//
//        val obj = other as Student2?
//
//        if (firstName != obj?.firstName)
//            return false
//
//        if (id != obj.id)
//            return false
//
//        if (lastName != obj.lastName)
//            return false
//
//        return true
//    }
//
//    override fun toString(): String {
//        return "Student (firstName=$firstName, lastName=$lastName, id=$id)"
//    }
//
//    fun copy(
//        firstName: String = this.firstName,
//        lastName: String = this.lastName,
//        id: Int = this.id
//    ) = Student2(firstName, lastName, id)
//}
//
//data class StudentData(
//    var firstName: String,
//    var lastName: String,
//    var id: Int
//)