fun main() {
    val jane = User()
    val john = User()
    val horrorList = MovieList("Horror")

    jane.addList(horrorList)
    john.addList(horrorList)

    // Add films to jane's list
    jane.movieLists["Horror"]?.movieTitles?.add("Insomnia")
    jane.movieLists["Horror"]?.movieTitles?.add("Exorcist")
    // Add films to john's list
    john.movieLists["Horror"]?.movieTitles?.add("Silent Hill")

    // Print lists
    jane.movieLists["Horror"]?.print()
    john.movieLists["Horror"]?.print()
}

// Imagine you're writing a movie-viewing application in Kotlin. Users can create lists of movies
// and share those lists with other users.
/*
* Create a 'User' class and a 'MovieList' class that maintains lists for users.
*
* MovieList: Contains a name and a mutable list of movie titles. The name and titles can all be
* represented by Strings. A 'print' method will print all the movies in the movie list.
*
* User: Has a method 'addList()' which adds the given 'MovieList' to a mutable map of 'MovieList'
* objects (using the 'name' as a key), and 'list(name: String): MovieList?' which will return the
* 'MovieList' for the provided name.
*
* Create 'jane' and 'john' users and have them create and share lists. Have both 'jane' and 'john'
* modify the same list and call 'print' from both users. Are all the changes reflected?
*/

class User(
    val movieLists: MutableMap<String, MovieList> = mutableMapOf()
) {
    fun addList(movieList: MovieList) {
        movieLists[movieList.name] = movieList
    }

    fun list(name: String): MovieList? {
        return movieLists[name]
    }
}

class MovieList(
    val name: String,
    val movieTitles: MutableList<String> = mutableListOf()
) {
    fun print() {
        for (i in movieTitles) {
            println(name)
            println(i)
        }
    }
}