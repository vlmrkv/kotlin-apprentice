fun main() {
    // Creating maps
    var yearOfBirth = mapOf(
        "Anna" to 1990,
        "Brian" to 1991,
        "Craig" to 1992,
        "Donna" to 1993
    )

    var namesAndScores = mutableMapOf(
        "Anna" to 2,
        "Brian" to 2,
        "Craig" to 8,
        "Donna" to 6
    )

    println(namesAndScores.isEmpty()) // false
//    namesAndScores = mutableMapOf()
//    println(namesAndScores.isEmpty()) // true

    var pairs = HashMap<String, Int>()
    pairs = HashMap<String, Int>(20) // Define capacity

    println(namesAndScores["Anna"]) // 2
    println(namesAndScores["Greg"]) // null
    println(namesAndScores.get("Craig")) // 8
    println(namesAndScores.size) // 4

    val bobData = mutableMapOf(
        "name" to "Bob",
        "profession" to "CardPlayer",
        "country" to "USA"
    )

    bobData.put("state", "CA")
    bobData["city"] = "San Francisco"

    printCityAndState(bobData)

    bobData.put("name", "Bobby") //
    println(bobData)

    bobData["profession"] = "Mailman"

    val pair = "nickname" to "Bobby D"
    bobData += pair
    println(bobData)

    bobData.remove("city")
    bobData.remove("state", "CA")
    println(bobData)

    for ((player, score) in namesAndScores) {
        println("$player - $score")
    }

    for (player in namesAndScores.keys) {
        println("$player, ")
    }

    println("some string".hashCode())
    println(1.hashCode())
    println(false.hashCode())
}

fun printCityAndState(mutableMap: MutableMap<String, String>) {
    println("City: ${mutableMap["city"]}, State: ${mutableMap["state"]}")
}