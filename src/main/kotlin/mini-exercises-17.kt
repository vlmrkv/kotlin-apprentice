//import kotlin.math.roundToInt
//import kotlin.properties.Delegates
//
//// Class with 2 properties
////class Car(val make: String, val color: String)
//
//class Contact(var fullName: String, var emailAddress: String)
//
//class Contact2(var fullName: String, val emailAddress: String)
//
//class Contact3(
//    var fullName: String,
//    val emailAddress: String,
//    var type: String = "Friend"
//)
//
//class Person(val firstName: String, val lastName: String) {
//    val fullName = "$firstName $lastName"
//}
//
//class Address {
//    var address1: String
//    var address2: String? = null
//    var city = "Moscow"
//    var state: String
//
//    init {
//        address1 = "St.Petersburg"
//        state = ""
//    }
//}
//
//class TV(var height: Double, var width: Double) {
//    var diagonal: Int
//        get() {
//            val result = Math.sqrt(height * height + width * width)
//            return result.roundToInt()
//        }
//        set(value) {
//            val ratioWidth = 16.0
//            val ratioHeight = 9.0
//            val ratioDiagonal = Math.sqrt(
//                ratioWidth * ratioWidth + ratioHeight * ratioHeight
//            )
//            height = value.toDouble() * ratioHeight / ratioDiagonal
//            width = height * ratioWidth / ratioHeight
//        }
//}
//
//class Level(
//    val id: Int,
//    var boss: String,
//    var unlocked: Boolean
//) {
//    companion object {
//        var highestLevel = 1
//    }
//}
//
//class DelegatedLevel(val id: Int, var boss: String) {
//    companion object {
//        var highestLevel = 1
//    }
//
//    var unlocked: Boolean by Delegates.observable(false) { _, old, new ->
//        if (new && id > highestLevel) {
//            highestLevel = id
//        }
//        println("$old -> $new")
//    }
//}
//
//class LightBulb {
//    companion object {
//        const val maxCurrent = 40
//    }
//
//    var current by Delegates.vetoable(0) { _, _, new ->
//        if (new > maxCurrent) {
//            println("Current too high, falling back to previous setting.")
//            false
//        } else {
//            true
//        }
//    }
//}
//
////class Circle(var radius: Double = 0.0) {
////    val pi: Double by lazy {
////        ((4.0 * Math.atan(1.0 / 5.0)) - Math.atan(1.0 / 239.0)) * 4.0
////    }
////    val circumference: Double
////        get() = pi * radius * 2
////}
//
//class Circle(var radius: Double = 0.0) {
//    private val pi = Math.PI
//    val circleArea: Double by lazy {
//        (pi * radius * radius)
//    }
//    val circumference: Double
//        get() = pi * radius * 2
//}
//
//val Circle.diameter: Double
//    get() = 2.0 * radius
//
//class Lamp {
//    lateinit var bulb: LightBulb
//}
//
//fun main() {
//    // Create object with 2 arguments
//    val contact = Contact(
//        fullName = "Grace Murray",
//        emailAddress = "grace@navy.mil"
//    )
//
//    val contact2 = Contact("Grace Murray", "grace@navy.mil")
//
//    val name = contact.fullName // Grace Murray
//    val email = contact.emailAddress // grace@navy.mil
//    println(name)
//
//    contact.fullName = "Grace Hopper"
//    val grace = contact.fullName // Grace Hopper
//    println(grace)
//
//    var contact3 = Contact2(
//        fullName = "Grace Murray",
//        emailAddress = "grace@navy.mil"
//    )
//
////    contact3.emailAddress = "grace@gmail.com" // val cannot be reassign
//
//    var contact4 = Contact3(
//        fullName = "Grace Murray",
//        emailAddress = "grace@navy.mil"
//    )
//
//    contact4.type = "Work"
//
//    // Or
//    var workContact = Contact3(
//        fullName = "Grace Murray",
//        emailAddress = "grace@navy.mil",
//        type = "Work"
//    )
//
//    // Property initializers
//    val person = Person("Grace", "Hopper")
//    person.fullName // Grace Hopper
//
//    val address = Address()
//    println(address.address1) // from init block
//    address.address1 = "Great Novgorod"
//    println(address.address1) // address1 is reassigned
//
//    val tv = TV(height = 53.93, width = 95.87)
//    val size = tv.diagonal // 110
//    println(size)
//    tv.width = tv.height
//    val diagonal = tv.diagonal // 76
//    println(diagonal)
//
//    val myMonitor = TV(height = 19.50, width = 34.50)
//    val myMonitorDiagonal = myMonitor.diagonal // 40
//    println(myMonitorDiagonal)
//    val myMonitorDiagInInches = myMonitorDiagonal / 2.54 // 15.75"
//    println(myMonitorDiagInInches)
//
//    tv.diagonal = 70
//    println(tv.height) // 34.32...
//    println(tv.width) // 61.01...
//
//    // companion object
//    val level1 = Level(id = 1, boss = "Chameleon", unlocked = true)
//    val level2 = Level(id = 2, boss = "Squid", unlocked = false)
//    val level3 = Level(id = 3, boss = "Chupacabra", unlocked = false)
//    val level4 = Level(id = 4, boss = "Yeti", unlocked = false)
//
//    // val highestLevel = Level3.highestLevel // unresolved reference
//    val highestLevel = Level.highestLevel // 1
//
//    // delegated properties
//    val delegatedLevel1 = DelegatedLevel(id = 1, boss = "Chameleon")
//    val delegatedLevel2 = DelegatedLevel(id = 2, boss = "Squid")
//
//    println(DelegatedLevel.highestLevel) // 1
//    delegatedLevel2.unlocked = true
//    println(DelegatedLevel.highestLevel) // 2
//
//    // limiting a variable
//    val light = LightBulb()
//    light.current = 50
//    var current = light.current // 0
//    println(current)
//    light.current = 40
//    current = light.current // 40
//    println(current)
//
//    // lazy properties
//    val circle = Circle(5.0) // got a circle, pi has not been run
//    val circumference = circle.circumference // 31.42
//    println(circumference)
//    val circleArea = circle.circleArea // 78.54
//    println(circleArea)
//
//    // lateinit
//    val lamp = Lamp() // lamp has no lightbulb
//    //println(lamp.bulb) // Error. lateinit property bulb has not been initialized
//    lamp.bulb = LightBulb() // lamp has a bulb now
//
//    // extention properties
//    val unitCircle = Circle(1.0)
//    println(unitCircle.diameter) // 2.0
//}