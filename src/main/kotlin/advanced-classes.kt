fun main() {
    val john = Person(firstName = "Johnny", lastName = "Mnemonic")
    val jane = Student(firstName = "Jane", lastName = "Air")
    println(john.fullName())
    println(jane.fullName())

    val history = Grade(letter = 'B', points = 9.0, credits = 3.0)
    jane.recordGrade(history)

    // Polymorphism
    val person = Person(
        firstName = "John",
        lastName = "Wick"
    )
    val oboePlayer = OboePlayer(
        firstName = "Helena",
        lastName = "Wick"
    )
    println(phonebookName(person))
    println(phonebookName(oboePlayer))

    // Runtime hierarchy checks
    var hallMonitor = Student(firstName = "John", lastName = "Wick")
    hallMonitor = oboePlayer
    println(hallMonitor.minimumPracticeTime)
    println(hallMonitor is OboePlayer) // true
    println(hallMonitor !is OboePlayer) // false
    println(hallMonitor is Person) // true

//    (oboePlayer as Student).minimumPracticeTime // error: no longer a band member
    println((hallMonitor as? BandMember)?.minimumPracticeTime) // 2

    println(afterClassActivity(oboePlayer)) // Goes to practice!
    println(afterClassActivity(oboePlayer as Student)) // Goes home!

    // Inheritance, methods and overrides
    val math = Grade(letter = 'B', points = 9.0, credits = 3.0)
    val science = Grade(letter = 'F', points = 9.0, credits = 3.0)
    val physics = Grade(letter = 'F', points = 9.0, credits = 3.0)
    val chemistry = Grade(letter = 'F', points = 9.0, credits = 3.0)

//    val dom = StudentAthlete(firstName = "Dom", lastName = "Grady")
//    dom.recordGrade(math)
//    dom.recordGrade(science)
//    dom.recordGrade(physics)
//    println(dom.isEligible) // true
//    dom.recordGrade(chemistry)
//    println(dom.isEligible) // false

    // Abstract classes
//    val human = Human("1/1/2000")
//    val mammal = Mammal("1/1/2000") // error. cannot create an instance of an abstract class

    // Sealed classes
//    val circle1 = Shape.Circle(4)
//    val circle2 = Shape.Circle(2)
//    val square1 = Shape.Square(4)
//    val square2 = Shape.Square(2)
//
//    fun size(shape: Shape): Int {
//        return when (shape) {
//            is Shape.Circle -> shape.radius
//            is Shape.Square -> shape.sideLength
//        }
//    }

//    println(size(circle1)) // radius = 4
//    println(size(square2)) // sideLength = 2

    // Nested and inner classes
    val mazda = Car1("mazda")
    val mazdaEngine = mazda.Engine("rotary")
    println(mazdaEngine) // rotary engine in a mazda

    // Visibility modifiers
    val privilegedUser = PrivilegedUser(username = "Jack Sparrow", id = "3487", age = 35)
    val privilege = Privilege(1, "sense of humor")
    privilegedUser.addPrivilege(privilege)
    println(privilegedUser.about()) // Jack Sparrow, 35
}

open class Person(var firstName: String, val lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student(
    firstName: String,
    lastName: String,
    var grades: MutableList<Grade> = mutableListOf()
) : Person(firstName, lastName) {
    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

open class BandMember(
    firstName: String,
    lastName: String
) : Student(firstName, lastName) {
    open val minimumPracticeTime: Int
        get() {
            return 2
        }
}

class OboePlayer(
    firstName: String,
    lastName: String
): BandMember(firstName, lastName) {
    // This is an example of an override, will be covered soon.
    override val minimumPracticeTime: Int =
        super.minimumPracticeTime
}

data class Grade(
    val letter: Char,
    val points: Double,
    val credits: Double
)

// Polymorphism
fun phonebookName(person: Person): String {
    return "${person.lastName}, ${person.firstName}"
}

// Runtime hierarchy checks
fun afterClassActivity(student: Student): String {
    return "Goes home!"
}

fun afterClassActivity(student: BandMember): String {
    return "Goes to practice!"
}

// Inheritance, methods and overrides
open class StudentAthlete(
    firstName: String,
    lastName: String
): Student(firstName, lastName) {
    var failedClasses = mutableListOf<Grade>()

//    override fun recordGrade(grade: Grade) {
//        super.recordGrade(grade)
//
//        if (grade.letter == 'F') {
//            failedClasses.add(grade)
//        }
//    }
//
//    val isEligible: Boolean
//        get() = failedClasses.size < 3

    override fun recordGrade(grade: Grade) {
        var newFailedClasses = mutableListOf<Grade>()
        for (grade in grades) {
            if (grade.letter == 'F') {
                newFailedClasses.add(grade)
            }
        }
        failedClasses = newFailedClasses

        super.recordGrade(grade) // this must be called first in fun recordGrade()
    }
}

// Preventing inheritance
class FinalStudent(firstName: String, lastName: String) : Person(firstName, lastName)

//class FinalStudentAthlete(firstName: String, lastName: String) : FinalStudent // type FinalStudent is final

open class AnotherStudent(firstName: String, lastName: String) : Person(firstName, lastName) {
    open fun recordGrade(grade: Grade) {}
    fun recordTardy() {}
}

class AnotherStudentAthlete(firstName: String, lastName: String) : AnotherStudent(firstName, lastName) {

    override fun recordGrade(grade: Grade) {
        super.recordGrade(grade)
    }
//    override fun recordTardy() {} // error. fun recordTardy() is final in parent class
}

// Abstract classes
abstract class Mammal(val birthDate: String) {
    abstract fun consumeFood()
}

class Human(birthDate: String) : Mammal(birthDate) {
    override fun consumeFood() {
        TODO("Not yet implemented")
    }
    fun createBirthCertificate() {
        // TODO: some code
    }
}

// Sealed classes
//sealed class Shape {
//    class Circle(val radius: Int): Shape()
//    class Square(val sideLength: Int): Shape()
//}

// Secondary constructor
open class Shape {
    constructor(size: Int) {
        // TODO: some code
    }

    constructor(size: Int, color: String) : this(size) {
        // TODO: some code
    }
}

//class Circle : Shape {
//    constructor(size: Int) : super(size) {
//        // TODO: some code
//    }
//
//    constructor(size: Int, color: String) : super(size, color) {
//        // TODO: some code
//    }
//}

// Nested and inner classes
class Car1(val carName: String) {
//    class Engine(val engineName: String) {
//        override fun toString(): String {
//            return "$engineName in a $carName" // error. cannot see carName in outer scope
//        }
//    }

    inner class Engine(val engineName: String) {
        override fun toString(): String {
            return "$engineName engine in a $carName"
        }
    }
}

// Visibility modifiers
data class Privilege(val id: Int, val name: String)

open class User(
    val username: String,
    private val id: String,
    protected var age: Int
)

class PrivilegedUser(username: String, id: String, age: Int) : User(username, id, age) {
    private val privileges = mutableListOf<Privilege>()

    fun addPrivilege(privilege: Privilege) {
        privileges.add(privilege)
    }

    fun hasPrivilege(id: Int): Boolean {
        return privileges.map { it.id }.contains(id)
    }

    fun about(): String {
//        return "$username, $id" // Error. id is private
        return "$username, $age" // age is protected. OK.
    }
}