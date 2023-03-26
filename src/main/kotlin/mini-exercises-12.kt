fun main() {
    val players = mutableListOf("Alice", "Bob", "Cindy", "Dan", "Zander")
    println(players.isEmpty()) // false

    if (players.size < 2) {
        println("We need at least two players!")
    } else {
        println("Let's start!")
    }

    var currentPlayer = players.first()
    println(currentPlayer)
    println(players.last())

    val minPlayer = players.minOrNull()
    minPlayer.let {
        println("$minPlayer will start")
    }

    println(arrayOf(2, 3, 1).first())
    println(arrayOf(2, 3, 1).min())

    val maxPlayer = players.maxOrNull()
    if (maxPlayer != null) {
        println("$maxPlayer is the MAX")
    }

    val firstPlayer = players[0]
    println("First player is $firstPlayer")

    val secondPlayer = players.get(1)
    println(secondPlayer)

    val player = players[5]
    println(player) // Index out of bounds

    val upcomingPlayerSlice = players.slice(1..2)
    println(upcomingPlayerSlice.joinToString())

    fun isEliminated(player: String): Boolean {
        return player !in players
    }
    println(isEliminated("Bob")) // false

    println(players.slice(1..3).contains("Alice")) // false

    players.add("Eli")
    players += "Gina"
    println(players.joinToString())

    var array = arrayOf(1, 2, 3)
    array += 4
    println(array.joinToString())

    players.add(5, "Frank")
    println(players.joinToString())

    val wasPlayerRemoved = players.remove("Gina")
    println("It is $wasPlayerRemoved that Gina was removed")

    val removedPlayer = players.removeAt(2)
    println("$removedPlayer was removed")

    // Use indexOf() to determine the position of the element "Dan" in 'players'.
    println(players.indexOf("Dan")) // 2

    players[4] = "Franklin"
    println(players.joinToString())

    players[3] = "Anna"
    players.sort()
    println(players.joinToString())

    players.set(3, "Anna")
    println(players.joinToString())

    val arrayOfInts = arrayOf(1, 2, 3)
    arrayOfInts[0] = 4
    println(arrayOfInts.joinToString())

    val scores = listOf(2, 2, 8, 6, 1)
    for (player in players) {
        println(player)
    }

    for ((index, player) in players.withIndex()) {
        println("${index + 1}. $player")
    }

    fun sumOfElements(list: List<Int>): Int {
        var sum = 0
        for (number in list) {
            sum += number
        }
        return sum
    }
    println(sumOfElements(scores)) // 19

    // Write a 'for' loop that prints the players' names and scores
    fun topPlayers(list1: List<String>, list2: List<Int>) {
        for ((index, player) in list1.withIndex()) {
            println("${index + 1}. $player - ${list2[index]}")
        }
    }
    println(topPlayers(players, scores))
}