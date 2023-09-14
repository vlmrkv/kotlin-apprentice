enum class DayOfTheWeek {
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}

fun main() {
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}")
    }

    val dayIndex = 0
    val dayAtIndex = DayOfTheWeek.values()[dayIndex]
    println("Day at $dayIndex is $dayAtIndex")

    val tuesday = DayOfTheWeek.valueOf("Tuesday")
    println("Tuesday is day ${tuesday.ordinal}")


}