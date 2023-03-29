fun main() {
    // 1. Which of the following 1-10 are valid statements?
    val array1 = Array<Int>() // not valid - required values for parameter 'size' and 'init'
    val array2 = arrayOf() // not valid - required reified type
    val array3: Array<String> = arrayOf() // valid
    // For the next three statements, 'array4' has been declared as:
    val array4 = arrayOf(1, 2, 3)
    println(array4[0]) // valid
    println(array4[5]) // not valid - index out of bounds
    array4[0] = 4 // valid
    // For the final five statements, 'array5' has been declared as:
    val array5 = arrayOf(1, 2, 3)
    array5[0] = array5[1] // valid - elements of array can be reassigned
    array5[0] = "Six" // not valid - 'array5' has type Int
    array5 += 6 // not valid - val can't be reassigned
    for item in array5 { println(item) } // not valid - a 'for' loop must contain parentheses

    val list: List<Int> = mutableListOf(1, 2, 3, 4, 2)
    val item = 2
    println(removeOne(item, list).joinToString())

}

// 2. Write a function that removes the first occurrence of a given integer from a list of
// integers. This is the signature of the function:
fun removeOne(item: Int, list: List<Int>): List<Int> {
    var result = listOf<Int>()
    if (list.contains(item)) {
        result = list.minus(item)
    }
    return result
}

// 3. Write a function that removes all occurrences of a given integer from a list of integers.
// This is the signature of the function:
//fun remove(item: Int, list: List<Int>): List<Int> {
//    var result = listOf<Int>()
//    for (i in 0 .. list.lastIndex) {
//        if (list[i] == item) {
//            result = list.minus(list[i])
//        }
//    }
//    return result
//}

// 4. Arrays and lists have a 'reverse()' method that reverses all the elements in-place,
// that is, within the original array or list. Write a function that does a similar thing,
// without using 'reverse()', and returns a new array with the elements of the original array
// in reverse order. This is the signature of the function:
fun reverse(array: Array<Int>): Array<Int> {
    return array
}

// 5. The function below returns a random number between 'from' (inclusive) and the 'to' (exclusive):
val random = 2
//fun rand(from: Int, to: Int): Int {
//    return random.nextInt(to - from) + from
//}
// Use it to write a function that shuffles the elements of an array in random order. This is the
// signature of the function:
//fun randomized(array: Array<Int>): Array<Int> {
//
//}

// 6. Write a function that calculates the minimum and maximum value in an array of integers.
// Calculate these values yourself; don't use the methods 'min' and 'max'. Return 'null' if the
// given array is empty. This is the signature of the function:
//fun minMax(numbers: Array<Int>): Pair<Int, Int>? {
//
//}