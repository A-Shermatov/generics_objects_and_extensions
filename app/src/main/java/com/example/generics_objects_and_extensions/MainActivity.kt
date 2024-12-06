package com.example.generics_objects_and_extensions


data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz {
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}


val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"


fun Quiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("▓") }
    repeat(total - answered) { print("▒") }
    println()
    println(Quiz.progressText)
}


fun main() {
    println("${Quiz.answered} of ${Quiz.total} answered.")
    println(Quiz.progressText)
    Quiz.printProgressBar()
}