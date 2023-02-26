import kotlin.random.Random

fun main() {
    // #1 Create a variable named 'counter' and set it equal to 0. Create a while loop with
    // the condition 'counter < 10' which prints out 'counter is X' (where X is replaced with
    // 'counter' value) and then increments 'counter' by 1.
    var counter = 0
    while (counter < 10) {
        println(counter)
        counter += 1
    }
    // #2 Create a variable named 'counter' and set it equal to 0. Create another variable named 'roll'
    // and set it equal to 0. Create a do-while loop. Inside the loop, set 'roll' equal to Random().nextInt(6)
    // which means to pick a random number berween 0 and 5. Then increment 'counter' by 1.
    // Finally, print 'After X rolls, roll is Y' where 'X' is the value of 'counter' and 'Y' is the value
    // of 'roll'. Set the loop condition such that loop finishes when the first 0 is rolled.
    var counter2 = 0
    var roll = 0
    do {
        roll = Random.nextInt(6)
        counter2 += 1
        println("After $counter2 rolls, roll is $roll")
    } while (roll != 0)
}