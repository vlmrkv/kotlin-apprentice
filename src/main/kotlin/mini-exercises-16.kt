//fun main() {
//    val marie = Student3(1, "Marie", "Curie")
//    val albert = Student3(2, "Albert", "Einstein")
//    val emmy = Student3(3, "Emmy", "Noether")
//    val richard = Student3(4, "Richard", "Feynman")
//
//    StudentRegistry.addStudent(marie)
//    StudentRegistry.addStudent(albert)
//    StudentRegistry.addStudent(emmy)
//    StudentRegistry.addStudent(richard)
//
//    StudentRegistry.listAllStudents()
//    StudentRegistry.numberOfStudents()
//
//    val emmY = Scientist.newScientist("Emmy", "Noether")
//    val isaac = Scientist.newScientist("Isaac", "Newton")
//    val nick = Scientist.newScientist("Nikola", "Tesla")
//
//    ScientistRepository.addScientist(emmY)
//    ScientistRepository.addScientist(isaac)
//    ScientistRepository.addScientist(nick)
//
//    ScientistRepository.listAllScientists()
//
//    val counter = object : Counts {
//        override fun studentCount(): Int {
//            return StudentRegistry.allStudents.size
//        }
//
//        override fun scientistCount(): Int {
//            return ScientistRepository.allScientists.size
//        }
//    }
//
//    println(counter.studentCount())
//    println(counter.scientistCount())
//}
//
//data class Student3(
//    val id: Int,
//    val firstName: String,
//    val lastName: String
//) {
//    var fullName = "$lastName, $firstName"
//}
//
//object StudentRegistry {
//    val allStudents = mutableListOf<Student3>()
//
//    fun addStudent(student: Student3) {
//        allStudents.add(student)
//    }
//
//    fun removeStudent(student: Student3) {
//        allStudents.remove(student)
//    }
//
//    fun listAllStudents() {
//        allStudents.forEach {
//            println(it.fullName)
//        }
//    }
//
//    fun numberOfStudents() {
//        println(allStudents.size)
//    }
//}
//
//class Scientist private constructor(
//    val id: Int,
//    val firstName: String,
//    val lastName: String
//) {
//    companion object {
//        var currentId = 0
//
//        fun newScientist(
//            firstName: String,
//            lastName: String
//        ): Scientist {
//            currentId += 1
//            return Scientist(currentId, firstName, lastName)
//        }
//    }
//    var fullName = "$firstName $lastName"
//}
//
//object ScientistRepository {
//    val allScientists = mutableListOf<Scientist>()
//
//    fun addScientist(scientist: Scientist) {
//        allScientists.add(scientist)
//    }
//
//    fun removeScientist(scientist: Scientist) {
//        allScientists.remove(scientist)
//    }
//
//    fun listAllScientists() {
//        allScientists.forEach {
//            println("${it.id}: ${it.fullName}")
//        }
//    }
//}
//
//interface Counts {
//    fun studentCount(): Int
//    fun scientistCount(): Int
//}