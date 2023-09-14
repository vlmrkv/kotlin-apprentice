fun main() {

    // 1. Create three simple class called 'A', 'B', and 'C' where 'C' inherits from 'B' and 'B' inherits from 'A'.
// In each class initializer, call println("I'm <X>!") where X is the name of the class.
// Create an instance of 'C' called 'c'. What order do you see each 'println()' called in?
    open class A {
        init {
            println("I'm A!")
        }
    }

    open class B : A() {
        init {
            println("I'm B!")
        }
    }

    class C : B() {
        init {
            println("I'm C!")
        }
    }

    val c = C()
    val a = A()
    println(c)
    // I'm A!
    // I'm B!
    // I'm C!

// 2. Cast the instance of type 'C' to an instance of type 'A'. Which casting operation do you use and why?
// Create an instance of 'A' called 'a'. What happens if you try to cast 'a' to 'C'?
    println(c as A) // class C is a subclass of class A and I use 'as' to cast C to A
    println(a as? C) // class A is not a subclass of class C and I use nullable cast with 'as?' to avoid Runtime exception

// 3. Create a subclass of 'StudentAthlete' called 'StudentBaseballPlayer' and include properties for 'position',
// 'number', and 'battingAverage'. What are the benefits and drawbacks of subclassing 'StudentAthlete' in this scenario?
class StudentBaseballPlayer(
    firstName: String,
    lastName: String,
    val position: String,
    val number: Int,
    val battingAverage: Double): StudentAthlete(firstName, lastName)

// 4. Create a sealed class 'Resource' with subtypes 'Success', 'Loading', and 'Error'. Give the 'Success' type a string
// 'data' property and the 'Error' type a string 'error' property. Can you imagine a use for this 'Resource' type?
    val image = Resource.Success("Logo.jpg")
    val loading = Resource.Loading()
    val error = Resource.Error("Can't load image")

}

sealed class Resource {
    class Success(data: String): Resource()
    class Loading(): Resource() {
        override fun equals(other: Any?): Boolean {
            return this === other
        }

        override fun hashCode(): Int {
            return System.identityHashCode(this)
        }
    }

    class Error(error: String): Resource()
}
