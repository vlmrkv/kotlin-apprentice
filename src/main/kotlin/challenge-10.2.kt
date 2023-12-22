//fun main() {
//
//}
//
//// Build a set of objects to support a T-shirt store. Decide if each object should be a class or
//// data class, and go ahead and implement them all.
///*
//* TShirt: Represents a shirt style you can buy. Each TShirt has a size, color, price, and an
//* optional image on the front.
//*
//* User: A registered user of the t-shirt store app. A user has a name, email, and a 'ShoppingCart
//* (see below).
//*
//* Address: Represents a shipping address, containing the name, street, city, and zip code.
//*
//* ShoppingCart: Holds a current order, which is composed of a list of 'TShirts' that the 'User'
//* wants to buy, as well as a method to calculate the total cost. Additionally, there is an 'Address'
//* that represents where the order will be shipped.
//*/
//
//data class TShirt(
//    val size: Int,
//    val color: String,
//    var price: Int,
//    val image: String?
//)
//
//class User(
//    var name: String,
//    var email: String,
//    val cart: ShoppingCart
//)
//
//data class Address(
//    var name: String,
//    var street: String,
//    var city: String,
//    var zipcode: Int
//)
//
//class ShoppingCart(
//    val tShirts: MutableList<TShirt> = mutableListOf(),
//    var address: Address
//    ) {
//    fun totalCost(tShirts: MutableList<TShirt>, address: Address): Double {
//        var totalCost = 0.0
//        tShirts.forEach {
//            totalCost += it.price
//        }
//        return totalCost
//    }
//}