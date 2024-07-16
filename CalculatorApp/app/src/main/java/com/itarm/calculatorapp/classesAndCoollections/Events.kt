package com.itarm.calculatorapp.classesAndCoollections

//Task 2
enum class DayPart {
    MORNING, AFTERNOON, EVENING;
}

//Task 1
data class Events(
    val title: String,
    val description: String? = null,
    val dayPart: DayPart,
    val duration: Int
)


//Task 7
val Events.durationOFEvents: String
    get() = if (this.duration < 60) "short" else "long"

fun main() {
    val events1 = Events(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.MORNING,
        15
    )
    val events2 = Events(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.EVENING,
        35
    )
    val events3 = Events(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.AFTERNOON,
        55
    )
    val events4 = Events(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.EVENING,
        75
    )
    val events5 = Events(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.AFTERNOON,
        95
    )
    val events6 = Events(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.EVENING,
        115
    )

    //Task 3
    val eventList = mutableListOf(events1, events2, events3, events4, events5, events6)
    //Task 4
    val durationLessThanSixty = eventList.filter { it.duration < 60 }
    println(durationLessThanSixty)

    //Task 5
    val groupEvents = eventList.groupBy { it.dayPart }
    groupEvents.forEach { (dayPart, event) ->
        println("$dayPart: ${event.size} events.")
    }

    //Task 6
    println("Last event of the day is :${eventList.last().title}")

    //Task 7 print
    println("Duration of first event of the day: ${eventList.first().durationOFEvents}")

}
