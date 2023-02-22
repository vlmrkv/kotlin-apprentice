fun main() {
    val date = Triple(2, 22, 23)
    val month = date.first
    val day = date.second
    val year = date.third
    println("$month-$day-$year") // 2-22-23
    var (month2, _, year2) = date
    println("$month2-$year2") // 2-23
    month2 = 3
    val newDate = Pair(month2, year)
    println("${newDate.first}-${newDate.second}") // 3-23
}