fun main() {
//    // Creating Sets
//    val names = setOf("Anna", "Brian", "Craig", "Anna")
//    println(names)
//
//    val hashSet = HashSet<Int>()
//    println(hashSet.isEmpty()) // true
//
//    // Set from arrays
//    val someArray = arrayOf(1, 2, 3, 1)
//    println(someArray.joinToString()) // 1, 2, 3, 1
//    var someSet = mutableSetOf(*someArray)
//    println(someSet) // [1, 2, 3]
//
//    // Accessing elements
//    println(someSet.contains(1)) // true
//    println(4 in someSet) // false
//
//    for (number in someSet) {
//        println(number)
//    }
//
//    // Adding and removing elements
//    someSet.add(5)
//
//    val removedOne = someSet.remove(1)
//    println(removedOne) // true
//    println(someSet) // [2, 3, 5]
//
//    // 1. Which of the following are valid statements?
//    val map1: Map<Int to Int> = emptyMap() // not valid
//    val map2 = emptyMap() // not valid
//    val map3: Map<Int, Int> = emptyMap() // valid
//
//    // For the next four statements, use the following map:
//    val map4 = mapOf("One" to 1, "Two" to 2, "Three" to 3)
//    map4[1] // not valid. Key has a String type
//    map4["One"] // valid
//    map4["Zero"] = 0 // not valid. no set method providing array access
//    map4[0] = "Zero" // not valid. no set method providing array access
//
//    // For the next three statements, use the following map:
//    val map5 = mutableMapOf(
//        "NY" to "New York",
//        "CA" to "California"
//    )
//    map5["NY"] // valid
//    map5["WA"] = "Washington" // valid
//    map5["CA"] = null // not valid. variables of this map has non-nullable type

    val codesOfStates = mapOf(
        "AL" to "Alabama",
        "AK" to "Alaska",
        "AS" to "American Samoa",
        "AZ" to	"Arizona",
        "AR" to "Arkansas",
        "CA" to "California",
        "CO" to "Colorado",
        "CT" to "Connecticut",
        "DE" to "Delaware",
        "DC" to "District Columbia",
        "FL" to "Florida",
        "FM" to "Federated states of micronesia",
        "GA" to "Georgia",
        "GU" to "Guam",
        "HI" to "Hawaii",
        "ID" to "Idaho",
        "IL" to "Illinois",
        "IN" to "Indiana",
        "IA" to "Iowa",
        "KS" to "Kansas",
        "KY" to "Kentucky",
        "LA" to "Louisiana",
        "ME" to "Maine",
        "MH" to "Marshall Islands",
        "MD" to "Maryland",
        "MA" to "Massachusetts",
        "MI" to "Michigan",
        "MN" to "Minnesota",
        "MS" to "Mississippi",
        "MO" to "Missouri",
        "MT" to "Montana",
        "NE" to "Nebraska",
        "NV" to "Nevada",
        "NH" to "New Hampshire",
        "NJ" to "New Jersey",
        "NM" to "New Mexico",
        "NY" to "New York",
        "NC" to "North Carolina",
        "ND" to "North Dakota",
        "MP" to "North Mariana Islands",
        "OH" to "Ohio",
        "OK" to "Oklahoma",
        "OR" to "Oregon",
        "PW" to "Palau",
        "PA" to "Pennsylvania",
        "PR" to "Puerto Rico",
        "RI" to "Rhode Island",
        "SC" to "South Carolina",
        "SD" to "South Dakota",
        "TN" to "Tennessee",
        "TX" to "Texas",
        "UM" to "Outer small islands of usa",
        "UT" to "Utah",
        "VT" to "Vermont",
        "VA" to "Virginia",
        "VI" to "Virginia Islands",
        "WA" to "Washington",
        "WV" to "West Virginia",
        "WI" to "Wisconsin",
        "WY" to "Wyoming"
    )
    printState(codesOfStates)

    val mapTest1 = mapOf(
        "Bee" to "Honey",
        "Cow" to "Milk"
    )
    val mapTest2 = mapOf(
        "Bull" to "Meat",
        "Programmer" to "Code"
    )
    println(mergeMaps(mapTest1, mapTest2))

    val test = "Apocalypto"
    println(occurrencesOfCharacters(test))

    nameTitleLookup["Patrick"] = null
    println(nameTitleLookup)
    nameTitleLookup.remove("Ray")
    println(nameTitleLookup)

    val testMap = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 7,
        "five" to 2
    )
    println(isInvertible(testMap))
}

// 2. Given a map with two-letter state codes as keys, and the full state names as values, write
// a function that prints all the states with names longer than eight characters. For example,
// for the mapOf("NY" to "New York", "CA" to "California"), the output would be 'California'.
fun printState(map: Map<String, String>) {
    for ((k, v) in map) {
        if (v.length > 8) {
            println(v)
        }
    }
}

// 3. Write a function that combines two maps into one. If a certain key appears in both maps,
// ignore the pair from the first maps. This is the function's signature:
fun mergeMaps(
    map1: Map<String, String>,
    map2: Map<String, String>
): Map<String, String> {
    val mergedMaps: MutableMap<String, String> = mutableMapOf()
    mergedMaps.putAll(map1)
    mergedMaps.putAll(map2)
    mergedMaps.toMap()
    return mergedMaps
}

// 4. Declare a function 'occurrencesOfCharacters' that calculates which characters occur
// in a string, as well as how often each of these characters occur. Return the result as a map.
// This is the function signature:
fun occurrencesOfCharacters(text: String): Map<Char, Int> {
    val map: MutableMap<Char, Int> = mutableMapOf()
    for (ch in text) {
        val counter = map.getOrDefault(ch, defaultValue = 0)
        println(counter)
        map[ch] = counter + 1
    }
    return map
}

// 5. Write a function that returns 'true' if all of the values of a map are unique. Use a set
// to test uniqueness. This is the function signature:
fun isInvertible(map: Map<String, Int>): Boolean {
    val setSize = map.values.toSet().size
    val mapSize = map.values.size
    return setSize == mapSize
}

// 6. Given the map. Set the value of the key "Patrick" to 'null' and completely remove the key
// and value for "Ray".
val nameTitleLookup: MutableMap<String, String?> = mutableMapOf(
    "Mary" to "Engineer",
    "Patrick" to "Intern",
    "Ray" to "Hacker"
)