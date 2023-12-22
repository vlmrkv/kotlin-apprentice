import java.util.Calendar

enum class DayOfTheWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;
}

enum class DayOfTheWeek2(val isWeekend: Boolean) {
    Monday(false),
    Tuesday(false),
    Wednesday(false),
    Thursday(false),
    Friday(false),
    Saturday(true),
    Sunday(true);
}

enum class DayOfTheWeek3(val isWeekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);
}

enum class DayOfTheWeek4(val isWeekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);

    fun daysUntil(other: DayOfTheWeek4): Int {
        return if (this.ordinal < other.ordinal) {
            other.ordinal - this.ordinal
        } else {
            other.ordinal - this.ordinal + DayOfTheWeek4.values().count()
        }
    }

    companion object {
        fun today(): DayOfTheWeek4 {
            val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            // adjusting index and the difference of the first day
            var adjustedDay = calendarDayOfWeek - 2
            val days = DayOfTheWeek4.values()
            println(days.count())
            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }

            return days.first { it.ordinal == adjustedDay }
        }
    }

    // Creating a sealed class
    sealed class AcceptedCurrency {
        abstract val valueInDollars: Float
        var amount: Float = 0.0f
        class Dollar: AcceptedCurrency() {
            override val valueInDollars = 1.0f
        }
        class Euro: AcceptedCurrency() {
            override val valueInDollars = 1.25f
        }
        class Crypto: AcceptedCurrency() {
            override val valueInDollars = 2534.92f
        }

        val name: String
            get() = when (this) {
                is Euro -> "Euro"
                is Dollar -> "Dollars"
                is Crypto -> "NerdCoin"
            }

        fun totalValueInDollars(): Float {
            return amount * valueInDollars
        }
    }
}

fun main() {
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}")
    }
    println("----------------------")

    val dayIndex = 0
    val dayAtIndex = DayOfTheWeek.values()[dayIndex]
    println("Day at $dayIndex is $dayAtIndex")
    println("----------------------")

    val tuesday = DayOfTheWeek.valueOf("Tuesday")
    println("Tuesday is day ${tuesday.ordinal}")
    println("----------------------")

    for (day in DayOfTheWeek2.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
    }
    println("----------------------")

    for (day in DayOfTheWeek3.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
    }
    println("----------------------")

    val today = DayOfTheWeek4.today()
    val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
    println("It is $today. $isWeekend.")
    println("----------------------")

    val secondDay = DayOfTheWeek4.Friday
    val daysUntil = today.daysUntil(secondDay)
    println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")
    println("----------------------")

    when (today) {
        DayOfTheWeek4.Monday -> println("I don't care if $today's blue")
        DayOfTheWeek4.Tuesday -> println("$today's gray")
        DayOfTheWeek4.Wednesday -> println("And $today, too")
        DayOfTheWeek4.Thursday -> println("$today, I don't care 'bout you")
        DayOfTheWeek4.Friday -> println("It's $today, I'm in love")
        DayOfTheWeek4.Saturday -> println("$today, Wait...")
        DayOfTheWeek4.Sunday -> println("$today always comes too late")
        else -> println("I don't feel like singing")
    }
    println("----------------------")

    val currency = DayOfTheWeek4.AcceptedCurrency.Crypto()
    println("You've got some $currency!")
    println("You've got some ${currency.name}!")

    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")
    println("----------------------")

    Downloader().downloadData("foo.com/bar",
        progress = { downloadState ->
            when (downloadState) {
                null -> println("No download state yet.")
                DownloadState.Starting -> println("Starting download...")
                DownloadState.InProgress -> println("Downloading data...")
                DownloadState.Error -> println("An error occurred. Download terminated.")
                DownloadState.Success -> println("Download completed successfully.")
            }
        },
        completion = { error, list ->
            error?.let { println("Got error: ${error.message}") }
            list?.let { println("Got list with ${list.size} items") }
        })
}