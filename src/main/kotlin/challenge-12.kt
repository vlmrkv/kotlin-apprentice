import kotlin.properties.Delegates

// 1. Rewrite the 'IceCream' class below to use default values and lazy initialization:
// - use a default value for the 'name' property
// - lazily initialize the 'ingredients' list.
class IceCream {
    val name: String = "Vanilla Ice"
    val ingredients by lazy {
        arrayListOf<String>()
    }
}

// 2. At the beginning of the chapter, you saw a 'Car' class. Dive into the inner workings of the car and
// rewrite the 'FuelTank' class below with delegated property observer functionality:
// - add a 'lowFuel' property of Boolean type to the class
// - flip the 'lowFuel' Boolean when the level drops below 10%
// - ensure that when the tank fills back up, the 'lowFuel' warning will turn off
// - add a 'FuelTank' property to 'Car' and fill the tank. Then drive around for awhile
class Car(val make: String, val color: String, val fuelTank: FuelTank = FuelTank())
class FuelTank {
    var lowFuel = true
    var level: Double by Delegates.observable(0.0) { _, _, new ->
        lowFuel = new < 0.1
    }

}

fun main() {
    val iceCream = IceCream()
    println(iceCream.name)
    iceCream.ingredients.add("Chocolate")
    println(iceCream.ingredients)

    val fordGT500 = Car("Ford", "Black")
    fordGT500.fuelTank.level = 1.0 // fill the tank
    // drive around...
    fordGT500.fuelTank.level = 0.3
    println(fordGT500.fuelTank.lowFuel)
    // drive around again...
    fordGT500.fuelTank.level = 0.07
    println(fordGT500.fuelTank.lowFuel)
}