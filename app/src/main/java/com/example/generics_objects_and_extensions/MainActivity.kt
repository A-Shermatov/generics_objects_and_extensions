package com.example.generics_objects_and_extensions


data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


enum class Difficulty {
    EASY, MEDIUM, HARD
}


interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}


class Quiz: ProgressPrintable {
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}


fun main() {
    val quiz = Quiz()
    quiz.printProgressBar()
    Quiz().apply {
        printQuiz()
    }
}