package com.itarm.calculatorapp.designLearning

enum class Difficulty {
    EASY, MEDIUM, HARD;
}

data class Questions<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

//object StudentProgress {
//    var total: Int = 10
//    var answer: Int = 3
//}

class Quiz : ProgressPrintable {
    val questions1 = Questions("i am ____", "Amrit", Difficulty.EASY)
    val questions2 = Questions("2*2 = 4", true, Difficulty.MEDIUM)
    val questions3 = Questions("How many days are there between full moons", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answer: Int = 3
    }

    override val progressText: String
        get() = "$answer of $total answered."

    override fun printProgressBar() {
        repeat(answer) { print("▓") }
        repeat(total - answer) { print("▒") }
    }
}

//add extension  property
//val Quiz.StudentProgress.properText: String
//    get() = "$answer of $total answered."

//add extension function
//fun Quiz.StudentProgress.printProgressBar() {
//    repeat(answer) { print("▓") }
//    repeat(total - answer) { print("▒") }
//}

//re-write extension function

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

fun main() {
    val textQuestion = Questions("i am ____", "Amrit", Difficulty.EASY)
    val trueFalseQuestion = Questions("2*2 = 4", true, Difficulty.MEDIUM)
    val numericQuestion =
        Questions("How many days are there between full moons", 28, Difficulty.HARD)

    println(textQuestion.toString())
    println(trueFalseQuestion.toString())
    println(numericQuestion.toString())

    // println("total:-${StudentProgress.total}, answers:-${StudentProgress.answer}")

    println("${Quiz.answer} of ${Quiz.total} answered.")

//    println(Quiz.properText)
//    println(Quiz.printProgressBar())

    Quiz().printProgressBar()
    Quiz().progressText


}


