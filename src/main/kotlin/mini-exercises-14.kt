import java.lang.NullPointerException

fun main() {
    // Basics
    var multiplyLambda: (Int, Int) -> Int
    multiplyLambda = { a: Int, b: Int -> Int
        a * b
    }

    val lambdaResult = multiplyLambda(4, 2) // 8
    println(lambdaResult)

    // Shorthand syntax
    multiplyLambda = { a, b ->
        a * b
    }

    var doubleLambda = { a: Int ->
        2 * a
    }
    // it keyword
    doubleLambda = { 2 * it } // 4
    println(doubleLambda(2))

    val square: (Int) -> Int = { it * it } // 9
    println(square(3))

    // Lambdas as arguments
    val addLambda = { a: Int, b: Int ->
        a + b
    }
    operateOnNumbers(4, 2, operation = addLambda) // 6

    operateOnNumbers(4, 2, operation = ::addFunction) // 6

    operateOnNumbers(4, 2, operation = { a: Int, b: Int ->
        a + b
    }) // 6

    operateOnNumbers(4, 2, { a, b ->
        a + b
    }) // 6

    operateOnNumbers(4, 2, operation = Int::plus) // 6

    operateOnNumbers(4, 2) { a, b ->
        a + b
    }

    // Lambdas with no meaningful return value
    val unitLambda: () -> Unit = {
        println("Kotlin Apprentice is awesome!")
    }
    unitLambda()

    var nothingLambda: () -> Nothing = {
        throw NullPointerException()
    }

    // Capturing from the enclosing scope
    var counter = 0
    val incrementCounter = {
        counter += 1
    }
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    println(counter)

    val counter1 = countingLambda()
    val counter2 = countingLambda()

    println(counter1()) // 1
    println(counter2()) // 1
    println(counter1()) // 2
    println(counter1()) // 3
    println(counter2()) // 2

    // Custom sorting with lambdas
    val names = arrayOf("ZZZZZZ", "BB", "AAA", "CCCC", "EEEEE")
    println(names.sorted()) // "AAA", "BB", "CCCC", "EEEEE", "ZZZZZZ"

    val namesByLength = names.sortedWith(compareBy { -it.length })
    println(namesByLength) // "ZZZZZZ", "EEEEE", "CCCC", "AAA", "BB"

    // Iterating over collections with lambdas
    val values = listOf(1, 2, 3, 4, 5, 6)
    values.forEach {
        println("$it: ${it * it}")
    }

    val prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)

    val largePrices = prices.filter {
        it > 5.0
    }
    println(largePrices)

    val salePrices = prices.map {
        it * 0.9
    }
    println(salePrices)

    val userInput = listOf("0", "11", "haha", "42")
    val numbers = userInput.map {
        it.toIntOrNull()
    }
    println(numbers)

    val numbers2 = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println(numbers2)

    val sum = prices.fold(0.0) { a, b ->
        a + b
    }
    println(sum)

    val stock = mapOf(
        1.5 to 5,
        10.0 to 2,
        4.99 to 20,
        2.30 to 5,
        8.19 to 30
    )
    var stockSum = 0.0
    stock.forEach {
        stockSum += it.key * it.value
    }
    println(stockSum)

    // 1. Create a constant list called 'nameList' which contains some names as strings.
    // Any names will do - make sure there's more than three. Now use 'fold' to create a string
    // which is the concatenation of each name in the list.
    val nameList = listOf(
        "Peter",
        "Ann",
        "Jane",
        "Kendra"
    )
    val stringSum = nameList.fold("") { a: String, b: String ->
        a + b
    }
    println(stringSum)

    // 2. Using the same 'nameList' list, first filter the list to contain only names which have more
    // than four characters in them, and then create the same concatenation of names as in the above
    // exercise.
    val filteredNames = nameList.filter {
        it.length > 3
    }
    val concatFilteredNames = filteredNames.fold("") { a: String, b: String ->
        a + b
    }
    println(concatFilteredNames)

    // 3. Create a constant map called 'namesAndAges' which contains some names as strings mapped to ages
    // as integers. Now use 'filter' to create a map containing only people under the age of 18.
    val namesAndAges = mapOf(
        "Peter" to 25,
        "Katie" to 16,
        "Alex" to 20,
        "Lucie" to 18
    )
    val filteredNamesAndAges = namesAndAges.filter {
        it.value > 18
    }
    println(filteredNamesAndAges)

    // 4. Using the same 'namesAndAges' map, filter out the adults (those 18 or older) and then use map
    // to convert to a list containing just the names (i.e., drop the ages).
    val listOfNames = filteredNamesAndAges.map {
        it.key
    }.toList()
    println(listOfNames)
}

// Lambdas as arguments
fun operateOnNumbers(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int {
    val result = operation(a, b)
    println(result)
    return result
}

fun addFunction(a: Int, b: Int) = a + b

fun countingLambda(): () -> Int {
    var counter = 0
    val incrementCounter: () -> Int = {
        counter += 1
        counter
    }
    return incrementCounter
}